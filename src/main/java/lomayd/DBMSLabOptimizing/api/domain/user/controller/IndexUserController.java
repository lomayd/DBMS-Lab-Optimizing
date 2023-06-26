package lomayd.DBMSLabOptimizing.api.domain.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lomayd.DBMSLabOptimizing.api.domain.user.dto.IndexUserRequestDto;
import lomayd.DBMSLabOptimizing.api.domain.user.dto.IndexUserResponseDto;
import lomayd.DBMSLabOptimizing.api.domain.user.service.IndexUserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class IndexUserController {

    private final IndexUserService indexUserService;
    
    @PostMapping("/index")
    public ResponseEntity<Void> joinUser(@RequestBody IndexUserRequestDto.UserJoin userJoin) {
        indexUserService.joinUser(userJoin);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/index")
    public ResponseEntity<IndexUserResponseDto.UserInfo> getUser(@RequestParam String name) {
        return ResponseEntity.ok(indexUserService.getUser(name));
    }

    @PatchMapping("/index")
    public ResponseEntity<Void> modifyUser(@RequestParam String name, @RequestBody IndexUserRequestDto.UserModify userModify) {
        indexUserService.modifyUser(name, userModify);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/index")
    public ResponseEntity<Void> removeUser(@RequestParam String name) {
        indexUserService.removeUser(name);
        return ResponseEntity.ok().build();
    }
}