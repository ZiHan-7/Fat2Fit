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
import fat2fit.spring.repositories.GroupRepository;

/**
 * GroupController
 */
@RestController
public class GroupController {
    @Autowired
    GroupRepository repo;

    @GetMapping(value = "/groups")
    public List<Group> index(){
        return repo.findAll();
    }

    @PostMapping(value = "/groups")
    public Group create(@RequestBody Group group){
        repo.save(group);
        return group;
    }

    @PutMapping(value = "/groups/{id}")
    public Group update(@PathVariable("id") Long id, @RequestBody Group data){
        Group existingGroup = repo.findById(id).orElse(null);

       if (existingGroup != null) {
           existingGroup.setName(data.getName());
           existingGroup.setUsers(data.getUsers());
           repo.save(existingGroup);
       }

       return existingGroup;
    }

    @DeleteMapping(value = "/groups/{id}")
    public String delete(@PathVariable("id") Long id){
        Group existingGroup = repo.findById(id).orElse(null);

        if(existingGroup != null){
            repo.delete(existingGroup);
            return "Sucessfully deleted Group";
        } else {
            return "Group could not be found";
        }
    }
    
}