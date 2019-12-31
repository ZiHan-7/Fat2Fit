package fat2fit.spring.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "age")
    private int age;


    @Column(name = "original_weight")
    private int originalWeight;

    @Column(name = "height")
    private int height;

    @JsonIgnore
    @Column(name="group_id", insertable = false, updatable = false)
    private Long groupId;

    @JsonIgnoreProperties("users")
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user")
    private Set<Record> records;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getOriginalWeight() {
        return this.originalWeight;
    }

    public void setOriginalWeight(int originalWeight) {
        this.originalWeight = originalWeight;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Group getGroup() {
        return this.group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    // public Set<Record> getRecords() {
    //     return this.records;
    // }

    // public void setRecords(Set<Record> records) {
    //     this.records = records;
    // }

    

    
}