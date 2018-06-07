package com.casic.demo;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class SpringVueDemoApplication {
    public static void main(String[] args) throws IOException {
        Desktop.getDesktop().browse(URI.create("http://localhost:8888/"));
        SpringApplication.run(SpringVueDemoApplication.class, args);
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            container.addErrorPages(error404Page);
        });
    }
}
