package lomayd.DBMSLabOptimizing.api.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lomayd.DBMSLabOptimizing.api.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    User findByName(String name);
    
    User deleteByName(String name);
}