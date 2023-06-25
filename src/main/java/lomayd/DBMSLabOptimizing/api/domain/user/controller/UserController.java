package lomayd.DBMSLabOptimizing.api.domain.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lomayd.DBMSLabOptimizing.api.domain.user.dto.UserRequestDto;
import lomayd.DBMSLabOptimizing.api.domain.user.dto.UserResponseDto;
import lomayd.DBMSLabOptimizing.api.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    
    @PostMapping
    public ResponseEntity<Void> joinUser(@RequestBody UserRequestDto.UserJoin userJoin) {
        userService.joinUser(userJoin);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<UserResponseDto.UserInfo> getUser(@RequestParam String name) {
        return ResponseEntity.ok(userService.getUser(name));
    }

    @PatchMapping
    public ResponseEntity<Void> modifyUser(@RequestParam String name, @RequestBody UserRequestDto.UserModify userModify) {
        userService.modifyUser(name, userModify);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> removeUser(@RequestParam String name) {
        userService.removeUser(name);
        return ResponseEntity.ok().build();
    }
}