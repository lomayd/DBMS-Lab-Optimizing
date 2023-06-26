package lomayd.DBMSLabOptimizing.api.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lomayd.DBMSLabOptimizing.api.domain.user.IndexUser;

public interface IndexUserRepository extends JpaRepository<IndexUser, String> {
    
    IndexUser findByName(String name);
    
    IndexUser deleteByName(String name);
}