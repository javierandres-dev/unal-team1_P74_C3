package com.miempresa.aplicacion;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@EnableAdminServer
@SpringBootApplication
//public class AplicacionApplication(exclude = AdminServerHazelcastAutoConfiguration.class){
public class AplicacionApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AplicacionApplication.class);
    }
    
    public static void main(String[] args) {
            SpringApplication.run(AplicacionApplication.class, args);
    }

}

