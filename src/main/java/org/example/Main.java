package org.example;

import org.example.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    }
}
