package mpww.helper.domain.board.post.model.dao;

import mpww.helper.domain.board.post.model.dto.Board;
import mpww.helper.domain.board.post.model.dto.SearchCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> selectAll();

    void writeBoard(Board board);

    List<Board> searchByCondition(SearchCondition con);

    int deleteBoard(int seq);

    int updateBoard(Board updateBoard);

    Board selectBoard(int seq);
}
