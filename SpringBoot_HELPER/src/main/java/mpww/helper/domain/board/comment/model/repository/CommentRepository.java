package mpww.helper.domain.board.comment.model.repository;


import mpww.helper.domain.board.comment.model.dto.Comment;
import mpww.helper.domain.board.comment.model.dto.CommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    void addComment(Comment comment);
    int removeComment(int seq);
    int updateComment(Comment comment);

    List<Comment> getComments(int boardSeq);
}
