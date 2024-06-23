package mpww.helper.domain.board.post.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "board")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    private int seq;
    private String title;
    private String type;
    private String content;
    private String registDate;
    private int likes;
    private int viewCnt;
//    private String userNickname;
//    private String gymName;


}
