package com.crud.tasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//@EnableSwagger2
@Configuration
public class CoreConfiguration /*implements WebMvcConfigurer*/ {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // Required by Swagger UI configuration
//
//        registry.addResourceHandler("/lib/**").addResourceLocations("/lib/").setCachePeriod(0);
//        registry.addResourceHandler("/images/**").addResourceLocations("/images/").setCachePeriod(0);
//        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(0);
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
}
