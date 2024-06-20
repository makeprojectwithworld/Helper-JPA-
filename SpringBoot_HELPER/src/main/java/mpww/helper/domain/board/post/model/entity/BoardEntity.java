package mpww.helper.domain.board.post.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "board")
@NoArgsConstructor
@Getter
@Setter
public class BoardEntity {
    @Id
    @GeneratedValue
    private Long seq;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private LocalDateTime registDate;
    private int viewCnt;

}
