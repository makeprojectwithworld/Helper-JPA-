package mpww.helper.domain.board.comment.model.service;


import lombok.AllArgsConstructor;
import mpww.helper.domain.board.comment.model.dao.CommentDao;
import mpww.helper.domain.board.comment.model.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{


    private final CommentDao commentDao;

    @Override
    public int removeComment(int seq) {
        return commentDao.removeComment(seq);
    }

    @Override
    public void addComment(CommentDto comment, String userNickname, String gymName) {
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
        //원하는 데이터 포맷 지정
        String strNowDate = simpleDateFormat.format(nowDate);
        //지정한 포맷으로 변환
        comment.setRegistDate(strNowDate);
        comment.setGymName(gymName);
        comment.setUserNickname(userNickname);

        commentDao.addComment(comment);
    }

    @Override
    public int updateComment(CommentDto comment) {
        return commentDao.updateComment(comment);
    }

    @Override
    public List<CommentDto> SelectAll(int boardSeq) {


        return commentDao.getComments(boardSeq);
    }
}
