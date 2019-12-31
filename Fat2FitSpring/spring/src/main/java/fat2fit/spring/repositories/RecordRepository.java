package fat2fit.spring.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fat2fit.spring.models.Record;



/**
 * RecordRepository
 */

@Transactional
@Repository
public interface RecordRepository extends JpaRepository<Record,Long>{

    
}