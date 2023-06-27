package lomayd.DBMSLabOptimizing.api.domain.user.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import lomayd.DBMSLabOptimizing.api.domain.user.User;
import lomayd.DBMSLabOptimizing.api.domain.user.dto.UserRequestDto;
import lomayd.DBMSLabOptimizing.api.domain.user.dto.UserResponseDto;
import lomayd.DBMSLabOptimizing.api.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    
    @PostConstruct
    public void init(){
        StopWatch stopWatch = new StopWatch();
        
        stopWatch.start();
        
        for(int i=1; i<=5; i++){
            User user = User.builder()
                .id("id_" + i)
                .password("password_" + i)
                .name("name_" + i)
                .nickname("nickname_" + i)
                .email("email_" + i)
                .age(i)
                .build();
                
            userRepository.save(user);
        }
        
        stopWatch.stop();
        
        System.out.println("NO_INDEX_INIT - " + stopWatch.prettyPrint());
    }
    
    public void joinUser(UserRequestDto.UserJoin userJoin){
        User user = User.builder()
                .id(userJoin.getId())
                .password(userJoin.getPassword())
                .name(userJoin.getName())
                .nickname(userJoin.getNickname())
                .email(userJoin.getEmail())
                .age(userJoin.getAge())
                .build();
        
        StopWatch stopWatch = new StopWatch();
        
        stopWatch.start();
        
        userRepository.save(user);
        
        stopWatch.stop();
        
        System.out.println("NO_INDEX_INSERT - " + stopWatch.prettyPrint());
    }

    public UserResponseDto.UserInfo getUser(String name) {
        StopWatch stopWatch = new StopWatch();
        
        stopWatch.start();
        
        User user = userRepository.findByName(name);
        
        stopWatch.stop();
        
        System.out.println("NO_INDEX_SELECT - " + stopWatch.prettyPrint());

        return UserResponseDto.UserInfo.of(user);
    }

    public void modifyUser(String name, UserRequestDto.UserModify userModify) {
        StopWatch stopWatch = new StopWatch();
        
        stopWatch.start();
        
        User user = userRepository.findByName(name);

        user.setPassword(userModify.getPassword());
        user.setName(userModify.getName());
        user.setNickname(userModify.getNickname());
        user.setEmail(userModify.getEmail());
        user.setAge(userModify.getAge());

        userRepository.save(user);
        
        stopWatch.stop();
        
        System.out.println("NO_INDEX_UPDATE - " + stopWatch.prettyPrint());
    }
    public void removeUser(String name) {
        StopWatch stopWatch = new StopWatch();
        
        stopWatch.start();
        
        userRepository.deleteByName(name);
        
        stopWatch.stop();
        
        System.out.println("NO_INDEX_DELETE - " + stopWatch.prettyPrint());
    }
}