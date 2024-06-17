package mpww.helper.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import mpww.helper.domain.board.post.model.dto.Board;
import mpww.helper.domain.board.post.model.service.BoardService;
import mpww.helper.global.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Board", description = "게시글 관리")
@RestController
@RequestMapping("/boardapi")
@CrossOrigin(origins = "*")
public class BoardController {

    private final BoardService boardService;
    private final JwtUtil jwtUtil;

    public BoardController(BoardService boardService, JwtUtil jwtUtil) {
        this.boardService = boardService;
        this.jwtUtil = jwtUtil;
    }

    @Operation(summary = "해당 헬스장 전체 게시글 조회", description = " ㅇㅇ헬스장의 전체 게시글을 조회합니다")
    @GetMapping("/allBoard")
    public ResponseEntity<?> selectAll(){
        List<Board> boardList = boardService.selectAll();

        if(!boardList.isEmpty()){
            return ResponseEntity.ok(boardList);
        }
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "게시글 상세 보기", description = "선택한 게시글을 확인합니다")
    @GetMapping("/board/{id}")
    public ResponseEntity<?> selectOne(@PathVariable int id){
        Board board = boardService.getBoard(id);
        if(board != null){
            return ResponseEntity.ok(board);
        }
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "게시글 삭제하기", description = "해당 게시글을 삭제합니다")
    @DeleteMapping("/board/{id}")
    public ResponseEntity<?> remove(@PathVariable int id){
        int result = boardService.removeBoard(id);
        return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "게시글 수정하기", description = "해당 게시글을 수정합니다")
    @PutMapping("/board/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Board updatedBoard){
        updatedBoard.setSeq(id);
        int result  = boardService.updateBoard(updatedBoard);
        return new ResponseEntity<>(result,result ==1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "게시글 작성하기", description = "새로운 게시글을 작성합니다")
    @PostMapping("/board")
    public ResponseEntity<?> create(@RequestBody Board board, @RequestHeader("Authorization") String token){

        try {
            // 토큰에서 유저 정보 추출
            token = token.replace("Bearer ", "");

            String userNickname = jwtUtil.getuserNicknameFromToken(token);
            String gymName = jwtUtil.getGymNameFromToken(token);
            boardService.writeBoard(board, userNickname, gymName);

            return ResponseEntity.ok().body("게시글 작성이 완료되었습니다");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시글 작성에 실패했습니다");
        }
    }

}
