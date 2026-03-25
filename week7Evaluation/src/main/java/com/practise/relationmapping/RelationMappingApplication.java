package com.practise.relationmapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication()
public class RelationMappingApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(RelationMappingApplication.class, args);

    }

}
