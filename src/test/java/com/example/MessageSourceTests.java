package com.example;

import java.util.Locale;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

@SpringBootTest
class MessageSourceTests {

	@Autowired
	MessageSource messageSource;

	@Test
	void defaultMessageSource() {
		String message = messageSource.getMessage("hello", null, Locale.getDefault());
		Assertions.assertThat(message).isEqualTo("Hello!");
	}

	@Test
	void frenchMessageSource() {
		String message = messageSource.getMessage("hello", null, Locale.FRENCH);
		Assertions.assertThat(message).isEqualTo("Salut!");
	}
}
