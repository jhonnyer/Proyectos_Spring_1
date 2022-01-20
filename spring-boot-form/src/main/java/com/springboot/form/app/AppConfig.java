package com.springboot.form.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
//Para añadir mas properties se hace separados por coma 
@PropertySources({
	@PropertySource("classpath:messages.properties")
})
public class AppConfig {

}
