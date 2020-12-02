/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantingtask;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tasks")
public class Task_POJO implements java.io.Serializable{
    
    @Id
    @Column(name="taskID")
    private String taskID;
    @Column(name="taskName")
    private String taskName;
    @Column(name="taskScore")
    private String taskScore;
    @Column(name="taskState")
    private double taskState;
    @Column(name="user_name")
    private double user_name;

    public Task_POJO() {
    }

    public Task_POJO(String taskID, String taskName, String taskScore, double taskState, double user_name) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskScore = taskScore;
        this.taskState = taskState;
        this.user_name = user_name;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskScore(String taskScore) {
        this.taskScore = taskScore;
    }

    public void setTaskState(double taskState) {
        this.taskState = taskState;
    }

    public void setUser_name(double user_name) {
        this.user_name = user_name;
    }

    public String getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskScore() {
        return taskScore;
    }

    public double getTaskState() {
        return taskState;
    }

    public double getUser_name() {
        return user_name;
    }
    
    
}
