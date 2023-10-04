package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket restAPI() {
        return new Docket(springfox.documentation.spi.DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(springfox.documentation.builders.RequestHandlerSelectors.basePackage("org.example"))
                .paths(springfox.documentation.builders.PathSelectors.ant("/money/**"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .build();
    }
}
