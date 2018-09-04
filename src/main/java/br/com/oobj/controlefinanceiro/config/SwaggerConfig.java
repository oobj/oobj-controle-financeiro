package br.com.oobj.controlefinanceiro.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.io.IOException;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Autowired
	private ResourceLoader resourceLoader;

	@Bean
	public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(or(regex("/api/.*"), (regex("/sessao.*")))).build()
				.apiInfo(apiInfo())
				.tags(new Tag("Lançamentos", "Lançamentos de movimentação financeira"));
	}
	
	private ApiInfo apiInfo() {
		String description = "Controle Financeiro - Rest API";
		try {
			description = IOUtils.toString(
					resourceLoader.getResource("classpath:static/api-description.html").getInputStream(), "UTF-8");
		} catch (IOException e) {
			System.err.println(e);
		}
		return new ApiInfoBuilder().title("Controle Financeiro - Rest API").description(description).version("0.0.1-SNAPSHOT")
				.contact(new Contact("Oobj Tecnologia da Informação", "http://www.oobj.com.br", "")).build();

	}
	
}
