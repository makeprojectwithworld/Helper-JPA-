package mpww.helper.domain.board.comment.model.service;


import mpww.helper.domain.board.comment.model.dto.CommentDto;

import java.util.List;

public interface CommentService {
    int removeComment(int seq);
    void addComment(CommentDto comment, String userNickname, String gymName);
    int updateComment(CommentDto comment);

    List<CommentDto> SelectAll(int boardSeq);
}
