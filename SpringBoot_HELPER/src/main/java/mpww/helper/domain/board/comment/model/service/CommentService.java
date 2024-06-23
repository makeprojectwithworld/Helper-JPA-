package mpww.helper.domain.board.comment.model.service;


import mpww.helper.domain.board.comment.model.dto.Comment;
import mpww.helper.domain.board.comment.model.dto.CommentDto;

import java.util.List;

public interface CommentService {
    int removeComment(int seq);
    void addComment(Comment comment, String userNickname, String gymName);
    int updateComment(Comment comment);

    List<Comment> SelectAll(int boardSeq);
}
