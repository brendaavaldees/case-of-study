package com.brenda.employmentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication()
@EntityScan("com.brenda.employmentsystem.model")
@EnableJpaRepositories("com.brenda.employmentsystem.repository")
public class CaseofstudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseofstudyApplication.class, args);
	}


}
