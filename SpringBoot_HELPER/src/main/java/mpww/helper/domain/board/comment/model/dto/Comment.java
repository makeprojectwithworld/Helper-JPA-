package mpww.helper.domain.board.comment.model.dto;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "comment")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
//    private int boardSeq;
    @Id
    private int seq;
//    private String userNickname;
//    private String gymName;
    private String content;
    private String registDate;
}
