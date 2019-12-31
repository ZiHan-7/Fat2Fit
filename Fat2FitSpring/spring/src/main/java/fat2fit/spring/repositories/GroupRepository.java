package fat2fit.spring.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fat2fit.spring.models.Group;

@Transactional
@Repository

public interface GroupRepository extends JpaRepository <Group,Long>{

    
}