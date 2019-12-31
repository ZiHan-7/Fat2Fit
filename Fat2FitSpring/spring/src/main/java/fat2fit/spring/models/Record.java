package fat2fit.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Record
 */
@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "week_num")
    private int weekNum;

    @Column(name = "weight")
    private int weight;

    @JsonIgnore
    @Column(name="user_id", insertable = false, updatable = false)
    private Long userId;

    @JsonIgnoreProperties("user")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "water_intake")
    private int waterIntake;

    @Column(name = "food_list")
    private String foodList;

    @Column(name = "calory_intake")
    private int caloryIntake;

    @Column(name = "exercise_list")
    private String exerciseList;

    @Column(name = "created_time")
    private String createdTime;

    @Column(name = "updated_time")
    private String updatedTime;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWeekNum() {
        return this.weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getWaterIntake() {
        return this.waterIntake;
    }

    public void setWaterIntake(int waterIntake) {
        this.waterIntake = waterIntake;
    }

    public String getFoodList() {
        return this.foodList;
    }

    public void setFoodList(String foodList) {
        this.foodList = foodList;
    }

    public int getCaloryIntake() {
        return this.caloryIntake;
    }

    public void setCaloryIntake(int caloryIntake) {
        this.caloryIntake = caloryIntake;
    }

    public String getExerciseList() {
        return this.exerciseList;
    }

    public void setExerciseList(String exerciseList) {
        this.exerciseList = exerciseList;
    }

    public String getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return this.updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
    
}