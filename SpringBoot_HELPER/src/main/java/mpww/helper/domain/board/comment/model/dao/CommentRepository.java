package mpww.helper.domain.board.comment.model.dao;


import mpww.helper.domain.board.comment.model.dto.CommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentRepository extends JpaRepository<CommentDto, Long> {
    void addComment(CommentDto comment);
    int removeComment(int seq);
    int updateComment(CommentDto comment);

    List<CommentDto> getComments(int boardSeq);
}
