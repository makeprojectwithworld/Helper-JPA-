package mpww.springboot_helper;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
class SpringBootHelperApplicationTests implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelperApplicationTests.class,args);
    }

}
