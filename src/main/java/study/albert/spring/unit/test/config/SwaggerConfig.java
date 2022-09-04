package study.albert.spring.unit.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * @author albert.lv
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("Restful API")
                .apiInfo(apiInfo())
                .select()
                // 过滤条件，扫描指定路径下的文件
                .apis(RequestHandlerSelectors.basePackage("study.albert.spring.unit.test.rest"))
                .build();
    }

    private ApiInfo apiInfo() {
        /*作者信息*/
        Contact contact = new Contact("albert.lv", "https://github.com/albert-lv", "albert.lv@outlook.com");
        return new ApiInfo(
                "Spring Unit Test",
                "Spring 单元测试项目",
                "v1.0",
                "",
                contact,
                null,
                null,
                new ArrayList<>()
        );
    }
}
