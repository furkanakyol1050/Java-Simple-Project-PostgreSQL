package com.example.sql_demo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.example.sql_demo"})
@ComponentScan(basePackages = {"com.example.sql_demo"})
@EnableJpaRepositories(basePackages = {"com.example.sql_demo"})
@SpringBootApplication
public class SqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlDemoApplication.class, args);
	}

}
