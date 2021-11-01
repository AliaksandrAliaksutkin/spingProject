package org.example.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity  // @Configuration в составе данной аннотации
public class SecurityConfig extends WebSecurityConfigurerAdapter { // первым делам унаследуемся
    @Override
    protected void configure(HttpSecurity http) throws Exception { // вторым переопределяем класс configure
//        http.authorizeRequests()
//                .antMatchers("/homepage/**").authenticated()       // доступ к homepage жоступен только авторизованным пользователям
//                .antMatchers("/update","/delete").hasAnyRole("ADMIN")
//                .antMatchers("/homepage","/address").authenticated()
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/homepage")
//                .and()
//                .logout().logoutSuccessUrl("/");
        super.configure(http);
    }


    @Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }
}
