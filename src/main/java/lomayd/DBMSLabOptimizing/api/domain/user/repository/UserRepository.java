package lomayd.DBMSLabOptimizing.api.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lomayd.DBMSLabOptimizing.api.domain.user.User;

public interface UserRepository extends JpaRepository<User, String> {
    
    User findByName(String name);
    
    User deleteByName(String name);
}