package com.z9devs.springmvccrud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// Questo segna il file come file di configurazioni
@Configuration
// Fa scan dei componenti dentro al package specificato
@ComponentScan("com.z9devs.springmvccrud")
// Configurazioni con cui starta l'application context
public class WebMvcConfig 
{
	@Bean(name="viewResolver")
	public InternalResourceViewResolver getViewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
