package com.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class YamlMessageSourceApplication {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setPropertiesPersister(new YamlPropertiesLoader());
		messageSource.setFileExtensions(List.of(".yml", ".yaml"));
		return messageSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(YamlMessageSourceApplication.class, args);
	}

}
