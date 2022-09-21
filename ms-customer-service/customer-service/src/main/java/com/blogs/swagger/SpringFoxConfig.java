/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig {

    @Bean
    public Docket apiDocket() {
	return new Docket(DocumentationType.SWAGGER_2).groupName("customer-service").select()
		.apis(RequestHandlerSelectors.basePackage("com.blogs")).paths(PathSelectors.any()).build()
		.forCodeGeneration(true).apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {

	return new ApiInfoBuilder().title("21Blogs Customer Service")
		.description("Customer Service using REST-HTTPS protocol.").license("Apache 2.0")
		.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0").build();
    }

}