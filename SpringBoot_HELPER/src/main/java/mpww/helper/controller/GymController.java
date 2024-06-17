package mpww.helper.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import mpww.helper.domain.gym.model.dto.GymDto;
import mpww.helper.domain.gym.model.service.GymService;
import mpww.helper.global.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Tag(name = "헬스장API", description = "헬스장 정보를 불러오는 API입니다")
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/gymapi")
@RestController
public class GymController {

    private final GymService gymService;
    private final JwtUtil jwtUtil;

    @GetMapping("/allgyms")
    @Operation(summary = "전체 헬스장 불러오기",description = "등록된 전체 헬스장을 불러옵니다")
    public ResponseEntity<?> selectAll(){
        List<GymDto> gyms = gymService.getAllgyms();

        if(gyms.isEmpty()) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(gyms);
    }

    @GetMapping("/helper/{name}")
    @Operation(summary = "헬스장 선택하기", description = "선택한 헬스장 커뮤니티로 이동합니다")
    public ResponseEntity<?> selectGym(@PathVariable String name){
       GymDto gym = gymService.selectOneGym(name);

        if(gym == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(gym);
    }

    @GetMapping("/domain")
    public Map<String, String> getGymName(@RequestHeader("Authorization") String tokenHeader) {
        String token = tokenHeader.substring(7); // "Bearer "를 제거합니다.
        String gymName = jwtUtil.getGymNameFromToken(token);
        Map<String, String> response = new HashMap<>();
        response.put("gymName", gymName);
        return response;
    }



}
