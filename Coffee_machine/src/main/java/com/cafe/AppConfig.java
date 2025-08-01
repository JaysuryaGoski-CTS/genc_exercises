package com.cafe;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring Configuration Class
 */
@Configuration
@ComponentScan(basePackages = "com.cafe")
@EnableAspectJAutoProxy
public class AppConfig {
    // Configuration is handled by annotations
}
