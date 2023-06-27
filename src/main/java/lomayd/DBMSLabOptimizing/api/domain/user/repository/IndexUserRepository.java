package lomayd.DBMSLabOptimizing.api.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lomayd.DBMSLabOptimizing.api.domain.user.IndexUser;

@Repository
public interface IndexUserRepository extends JpaRepository<IndexUser, String> {
    
    IndexUser findByName(String name);
    
    IndexUser deleteByName(String name);
}