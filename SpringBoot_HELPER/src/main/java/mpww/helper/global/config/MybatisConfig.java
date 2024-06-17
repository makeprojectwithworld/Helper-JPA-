package mpww.helper.global.config;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@MapperScan({ "mpww.helper.domain.board.post.model.dao",
        "mpww.helper.domain.user.model.dao",
        "mpww.helper.domain.board.comment.model.dao",
        "mpww.helper.domain.gym.model.dao"
})
@Configuration
public class MybatisConfig {

}
