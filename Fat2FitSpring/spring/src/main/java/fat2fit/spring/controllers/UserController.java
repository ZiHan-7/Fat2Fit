package fat2fit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fat2fit.spring.models.Group;
import fat2fit.spring.models.User;
import fat2fit.spring.repositories.GroupRepository;
import fat2fit.spring.repositories.UserRepository;

/**
 * UserController
 */

@RestController
public class UserController {

    @Autowired
    UserRepository repo;

    @Autowired
    GroupRepository groupRepo;

    @GetMapping(value = "/users")
    public List<User> index(){
        return repo.findAll();
    }
    

    @PostMapping(value="/users")
    public User create(@RequestBody User user) {
        repo.save(user);        
        return user;
    }

    @PutMapping(value = "/users/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User data){
       User existingUser = repo.findById(id).orElse(null);
       Group existingGroup =  groupRepo.findById(data.getGroup().getId()).orElse(null);
       System.out.println(data.getGroup().getId());
       if (existingUser != null && existingGroup != null) {
           existingUser.setGroup(existingGroup);
           repo.save(existingUser);
       }

       return existingUser;
    }

    @DeleteMapping(value = "/users/{id}")
    public String delete(@PathVariable("id") Long id){
        User existingUser = repo.findById(id).orElse(null);

        if(existingUser != null){
            repo.delete(existingUser);
            return "Sucessfully deleted User";
        } else {
            return "User could not be found";
        }
    }





}