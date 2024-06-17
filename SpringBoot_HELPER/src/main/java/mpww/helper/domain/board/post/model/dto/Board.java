package mpww.helper.domain.board.post.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Board {
    private int seq;
    private String title;
    private String content;
    private String registDate;
    private int likes;
    private int viewCnt;
    private String userNickname;
    private String gymName;
    private String type;

}
