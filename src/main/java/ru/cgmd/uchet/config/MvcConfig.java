package ru.cgmd.uchet.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("main");
        registry.addViewController("/main").setViewName("main");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String currentPath = String.format("%s%s%s", System.getProperty("user.dir"), File.separatorChar, uploadPath + "/");
        registry.addResourceHandler("/docx/**")
                .addResourceLocations("file:///" + currentPath + "/");
//        registry.addResourceHandler("/zip/**")
//                .addResourceLocations("file:///" + uploadPath + "/");
//        registry.addResourceHandler("/img/**")
//                .addResourceLocations("file:///" + uploadPath + "/");

    }
}