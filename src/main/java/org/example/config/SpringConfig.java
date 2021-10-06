package org.example.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // отмечаем этот класс как конфигурационный
@ComponentScan("org.example")
@PropertySource("org.example.repository")//?????????
public class SpringConfig {
}
