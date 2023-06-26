package lomayd.DBMSLabOptimizing.api.domain.user.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import lomayd.DBMSLabOptimizing.api.domain.user.IndexUser;
import lomayd.DBMSLabOptimizing.api.domain.user.dto.IndexUserRequestDto;
import lomayd.DBMSLabOptimizing.api.domain.user.dto.IndexUserResponseDto;
import lomayd.DBMSLabOptimizing.api.domain.user.repository.IndexUserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IndexUserService {

    private final IndexUserRepository indexUserRepository;
    
    @PostConstruct
    public void init(){
        StopWatch stopWatch = new StopWatch();
        
        stopWatch.start();
        
        for(int i=1; i<=100000; i++){
            IndexUser indexUser = IndexUser.builder()
                .id("id_" + i)
                .password("password_" + i)
                .name("name_" + i)
                .nickname("nickname_" + i)
                .email("email_" + i)
                .age(i)
                .build();
                
            indexUserRepository.save(indexUser);
        }
        
        stopWatch.stop();
        
        System.out.println("YES_INDEX_INIT - " + stopWatch.prettyPrint());
    }
    
    public void joinUser(IndexUserRequestDto.UserJoin userJoin){
        IndexUser indexUser = IndexUser.builder()
                .id(userJoin.getId())
                .password(userJoin.getPassword())
                .name(userJoin.getName())
                .nickname(userJoin.getNickname())
                .email(userJoin.getEmail())
                .age(userJoin.getAge())
                .build();
        
        StopWatch stopWatch = new StopWatch();
        
        stopWatch.start();
        
        indexUserRepository.save(indexUser);
        
        stopWatch.stop();
        
        System.out.println("YES_INDEX_INSERT - " + stopWatch.prettyPrint());
    }

    public IndexUserResponseDto.UserInfo getUser(String name) {
        StopWatch stopWatch = new StopWatch();
        
        stopWatch.start();
        
        IndexUser indexUser = indexUserRepository.findByName(name);
        
        stopWatch.stop();
        
        System.out.println("YES_INDEX_SELECT - " + stopWatch.prettyPrint());

        return IndexUserResponseDto.UserInfo.of(indexUser);
    }

    public void modifyUser(String name, IndexUserRequestDto.UserModify userModify) {
        StopWatch stopWatch = new StopWatch();
        
        stopWatch.start();
        
        IndexUser indexUser = indexUserRepository.findByName(name);

        indexUser.setPassword(userModify.getPassword());
        indexUser.setName(userModify.getName());
        indexUser.setNickname(userModify.getNickname());
        indexUser.setEmail(userModify.getEmail());
        indexUser.setAge(userModify.getAge());

        indexUserRepository.save(indexUser);
        
        stopWatch.stop();
        
        System.out.println("YES_INDEX_UPDATE - " + stopWatch.prettyPrint());
    }
    public void removeUser(String name) {
        StopWatch stopWatch = new StopWatch();
        
        stopWatch.start();
        
        indexUserRepository.deleteByName(name);
        
        stopWatch.stop();
        
        System.out.println("YES_INDEX_DELETE - " + stopWatch.prettyPrint());
    }
}