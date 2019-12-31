package fat2fit.spring.models;

import java.time.LocalDateTime;

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

    @JsonIgnoreProperties("records")
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

    @Column(name = "calory_burn")
    private String caloryBurn;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


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


    public String getCaloryBurn() {
        return this.caloryBurn;
    }

    public void setCaloryBurn(String caloryBurn) {
        this.caloryBurn = caloryBurn;
    }



    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    
    
}