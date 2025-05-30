package com.alejandro.msvc_processing_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
@PropertySource("classpath:messages.properties")
public class MsvcProcessingDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcProcessingDataApplication.class, args);
	}

}
