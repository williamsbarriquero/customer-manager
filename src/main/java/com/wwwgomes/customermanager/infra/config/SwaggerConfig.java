package com.wwwgomes.customermanager.infra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("${swagger.owner.url}")
	private String ulr;
	@Value("${swagger.owner.name}")
	private String nameOwner;
	
	@Bean
	public Docket apiV1() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("v1")
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfo("v1"))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.wwwgomes.customermanager.api.resources.v1"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo(String version) {
	    return new ApiInfoBuilder()
	    		.title("Customer Manager - RESTful API")
	    		.description("Customer registration management.")
	    		.version(version)
	    		.contact(new Contact("Williams Gomes", "", "williamsgomess@outlook.com"))
	    		.build();
	}

}
