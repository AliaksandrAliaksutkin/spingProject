package org.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SprJPAConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};           /*все запоросы отправляем на диспетчерСервлет*/
    }
}


/*  public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer -
рабочая замена файлу web.xml, а также более раннему классу MyWebAppInitializer который реализует интерфейс
* org.springframework.web.WebApplicationInitializer*/