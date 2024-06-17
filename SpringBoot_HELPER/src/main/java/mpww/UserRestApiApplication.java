package mpww;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
//@MapperScan(basePackages ={ "mpww.helper.domain.board.model.dao", "mpww.helper.domain.user.model.dao"})
public class UserRestApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserRestApiApplication.class,args);
    }
}
