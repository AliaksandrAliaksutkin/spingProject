package org.example.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.sql.DataSource;
import java.util.Properties;
@AllArgsConstructor
@Configuration
@ComponentScan("org.example")
@EnableJpaRepositories("org.example.repository")
@EnableWebMvc
@EnableTransactionManagement
public class SprJPAConfig implements WebMvcConfigurer {  /*интерфей WebMvcConfigurer используется тогда, когда мы под себя хотим настроить работу Spring MVC, в данном случаемы используем шаблонизатор Thymeleaf вместо стандартного */
    private final ApplicationContext applicationContext;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("org.example.model");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaProperties(hibernateProperties());
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();                             /*  DriverManagerDataSource - простая реализация стандартного интерфейса JDBC DataSource, настройка простого старого JDBC DriverManager через свойства bean-компонента и возврат нового соединения из каждого вызова getConnection.*/
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("821252");
        return dataSource;
    }

    Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"); //org.hibernate.dialect.MySQL8Dialect, org.hibernate.dialect.MySQL5Dialect
        return properties;
    }
    /*Возможные значения hbm2ddl свойства конфигурации следующие:
    none- Никаких действий не выполняется. Схема не будет создана.
    create-only - Будет создана схема базы данных.
    drop - Схема базы данных будет удалена.
    create - Схема базы данных будет удалена и создана позже.
    create-drop- Схема базы данных будет удалена и создана позже. После закрытия SessionFactory схема базы данных будет удалена.
    validate - Схема базы данных будет проверена с использованием сопоставлений сущностей.
    update - Схема базы данных будет обновлена путем сравнения существующей схемы базы данных с сопоставлениями сущностей.
    Это hibernate.hbm2ddl.auto="update"удобно, но менее гибко, если вы планируете добавлять функции или выполнять некоторые пользовательские сценарии.
    */

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext); /*здесь используем applicationContext для настройки Thymeleaf */
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) { /*реализация метода интерфейса WebMvcConfigurer в котором указываем тип используемого шаблонизатора*/
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }
}
