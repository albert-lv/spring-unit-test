package study.albert.spring.unit.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringUnitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringUnitTestApplication.class, args);
	}

}
