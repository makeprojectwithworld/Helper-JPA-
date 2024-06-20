package mpww.helper.domain.board.comment.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity (name = "comment")
@Getter
@Setter
public class CommentEntity {
    @Id
    @GeneratedValue
    private long seq;
    private String content;
    private LocalDateTime registDate;

}
