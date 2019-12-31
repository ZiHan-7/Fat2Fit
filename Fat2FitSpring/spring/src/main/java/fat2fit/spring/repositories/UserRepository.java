package fat2fit.spring.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fat2fit.spring.models.User;

@Transactional
@Repository

public interface UserRepository extends JpaRepository<User,Long> {

    // List<User> findByName(String name);

    
}