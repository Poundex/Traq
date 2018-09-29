package net.poundex.traq.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@SpringBootApplication
class TraqServerApplication
{

	static void main(String[] args)
	{
		SpringApplication.run TraqServerApplication, args
	}

	@Bean
	WebMvcConfigurer corsConfigurer()
	{
		return new WebMvcConfigurer() {
			@Override
			void addCorsMappings(CorsRegistry registry)
			{
				registry.addMapping("/**")
			}
		}
	}
}
