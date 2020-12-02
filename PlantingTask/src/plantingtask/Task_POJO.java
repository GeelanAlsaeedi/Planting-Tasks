/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantingtask;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "tasks")
public class Task_POJO implements java.io.Serializable{
    
    @Id
    @Column(name="taskID")
    private int taskID;
    
    @Column(name="taskName")
    private String taskName;
    
    @Column(name="taskScore")
    private double taskScore;
    
    @Column(name="taskState")
    private String taskState;
    
    @OneToMany
    @JoinColumn(name="user_name")
    private User user;

    public Task_POJO() {
    }

    public Task_POJO(int taskID, String taskName, double taskScore, String taskState, User user) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskScore = taskScore;
        this.taskState = taskState;
        this.user = user;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskScore(double taskScore) {
        this.taskScore = taskScore;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public double getTaskScore() {
        return taskScore;
    }

    public String getTaskState() {
        return taskState;
    }

    public User getUser() {
        return user;
    }
 
}
