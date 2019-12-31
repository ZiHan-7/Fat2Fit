package fat2fit.spring.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fat2fit.spring.models.Record;
import fat2fit.spring.models.User;
import fat2fit.spring.repositories.RecordRepository;
import fat2fit.spring.repositories.UserRepository;

/**
 * RecordController
 */
@RestController
public class RecordController {

    @Autowired
    RecordRepository repo;

    @Autowired
    UserRepository userRepo;

    @GetMapping(value = "/records")
    public List<Record> index(){
        return repo.findAll();
    }

    @PostMapping(value="/records")
    public Record create(@RequestBody Record record) {
        System.out.println("");


        User existingUser = userRepo.findById(record.getUser().getId()).orElse(null);

        if (existingUser != null) {
            record.setUser(existingUser);
            record.setCreatedAt(LocalDateTime.now());
            record.setUpdatedAt(LocalDateTime.now());
            repo.save(record);  
        }
                             
        return record;
    }

    @PutMapping(value = "/records/{id}")
    public Record update(@PathVariable("id") Long id, @RequestBody Record data){
       Record existingRecord = repo.findById(id).orElse(null);
       User existingUser = userRepo.findById(data.getUser().getId()).orElse(null);

       if (existingRecord != null && existingUser != null) {
           existingRecord.setUser(existingUser);
           repo.save(existingRecord);
       }

       return existingRecord;
    }

    @DeleteMapping(value = "/records/{id}")
    public String delete(@PathVariable("id") Long id){
        Record existingRecord = repo.findById(id).orElse(null);

        if(existingRecord != null){
            repo.delete(existingRecord);
            return "Sucessfully deleted Record";
        } else {
            return "Record could not be found";
        }
    }



    
}