package com.dio.live.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        Parameter parameter = new ParameterBuilder()
                .name("Authorization")
                .description("Header para Token jwt")
                .modelRef(new ModelRef("header"))
                .parameterType("header")
                .required(false)
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dio.live"))//RequestHandlerSelectors.any()
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .globalOperationParameters(
                        Collections.singletonList(parameter)
                );
    }

    @Bean
    public ApiInfo apiInfo() {
        String apiTitle = "Api rest dio";
        String apiDescription = "Api para gerenciamento de ponto e acessso";
        String apiVersion = "1.0";
        String apiLicense = "Apache 2";
        String apiLicenseUrl = "https://www.apache.org/licenses/LICENSE-2.0";
        String name = "Dio";
        String url = "https://web.digitalinnovation.one";
        String email = "contato@digitalinnovationone.com.br";
        Contact contact = new Contact(name, url, email);
        return  new ApiInfoBuilder()
                .title(apiTitle)
                .description(apiDescription)
                .version(apiVersion)
                .license(apiLicense)
                .licenseUrl(apiLicenseUrl)
                .contact(contact)
                .build();
    }
}
