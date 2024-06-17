package mpww.helper.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import mpww.helper.domain.board.comment.model.dto.CommentDto;
import mpww.helper.domain.board.comment.model.service.CommentService;
import mpww.helper.global.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Comment", description = "댓글 관리")
@RequestMapping("/commentapi")
@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class CommentController {

    private final CommentService commentService;
    private final JwtUtil jwtUtil;

    @Operation(summary = "댓글 작성", description = "게시글에 댓글을 작성합니다")
    @PostMapping("/comment/add")
   public ResponseEntity<?> addComment(@RequestBody CommentDto comment, @RequestHeader("Authorization") String token) {

        try {
            // 토큰에서 유저 정보 추출
            token = token.replace("Bearer ", "");
            String userNickname = jwtUtil.getuserNicknameFromToken(token);

            String gymName = jwtUtil.getGymNameFromToken(token);
            commentService.addComment(comment, userNickname, gymName);
            return ResponseEntity.ok().body("댓글작성이 완료되었습니다");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 작성에 실패했습니다");
        }
   }

   @Operation(summary = "댓글 삭제", description = "게시글에 등록된 댓글을 삭제합니다")
   @DeleteMapping("/comment/{seq}")
   public ResponseEntity<?> deleteComment(@PathVariable int seq) {
        int result = commentService.removeComment(seq);
        if (result == 1) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
   }

   @Operation(summary = "댓글 수정하기", description = "기존 댓글을 수정합니다.")
   @PutMapping("/comment/{seq}")
   public ResponseEntity<?> updateComment(CommentDto comment) {
        int result = commentService.updateComment(comment);
        if (result == 1) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
   }

   @Operation(summary = "댓글 전체 보기", description = "해당 게시글 댓글을 모두 봅니다.")
    @GetMapping("/comment/{boardSeq}")
    public ResponseEntity<?> getComments(@PathVariable int boardSeq) {
       List<CommentDto> commentDtoList = commentService.SelectAll(boardSeq);

       return ResponseEntity.ok().body(commentDtoList);
   }
}
