package lomayd.DBMSLabOptimizing.api.domain.user.dto;

import lomayd.DBMSLabOptimizing.api.domain.user.IndexUser;
import lombok.*;

public class IndexUserResponseDto {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfo {
        private String id;
        private String password;
        private String name;
        private String nickname;
        private String email;
        private Integer age;

        public static IndexUserResponseDto.UserInfo of(IndexUser indexUser) {
            return IndexUserResponseDto.UserInfo.builder()
                    .id(indexUser.getId())
                    .password(indexUser.getPassword())
                    .name(indexUser.getName())
                    .nickname(indexUser.getNickname())
                    .email(indexUser.getEmail())
                    .age(indexUser.getAge())
                    .build();
        }
    }
}