package mpww.helper.domain.board.post.model.service;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mpww.helper.domain.board.post.model.dao.BoardDao;
import mpww.helper.domain.board.post.model.dto.Board;
import mpww.helper.domain.board.post.model.dto.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements  BoardService {

    private final BoardDao boardDao;



    @Override
    public int removeBoard(int id) {
        return boardDao.deleteBoard(id);
    }

    @Override
    public List<Board> selectAll() {
        return boardDao.selectAll();
    }

    @Override
    public List<Board> searchByCondition(SearchCondition con) {
        return boardDao.searchByCondition(con);
    }

    @Override
    public int updateBoard(Board updateBoard) {
        return boardDao.updateBoard(updateBoard);
    }

    @Override
    public void writeBoard(Board board, String userNickname, String GymName) {
        System.out.println("오잉");
        board.setUserNickname(userNickname);
        board.setGymName(GymName);
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
        //원하는 데이터 포맷 지정
        String strNowDate = simpleDateFormat.format(nowDate);
        //지정한 포맷으로 변환
        board.setRegistDate(strNowDate);
        boardDao.writeBoard(board);
    }

    @Override
    public Board getBoard(int seq) {
        return boardDao.selectBoard(seq);
    }


}


