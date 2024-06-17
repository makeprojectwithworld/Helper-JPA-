package mpww.helper.domain.board.comment.model.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDto {
    private int boardSeq;
    private int seq;
    private String userNickname;
    private String gymName;
    private String content;
    private String registDate;
}
