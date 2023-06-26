package lomayd.DBMSLabOptimizing.api.domain.user;

import javax.persistence.*;

import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "IndexUser", indexes = @Index(name = "idx_name", columnList = "name"))
public class IndexUser{
    
    @Id
    private String id;
    
    @Column
    private String password;
    
    @Column
    private String name;
    
    @Column
    private String nickname;
    
    @Column
    private String email;
    
    @Column
    private Integer age;
}