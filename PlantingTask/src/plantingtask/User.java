package plantingtask;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="userinformation")
public class User implements java.io.Serializable {
  
    @Id
    @Column(name="user_name")
    private String UserName;
    @Column(name="email")
    private String Email;
    @Column(name="password")
    private String Password;
    @Column(name="Score")
    private double score;
//    @Column(name="log")
//    private boolean log;
    @Transient
    private ArrayList<Task_POJO> tasks;
    

    public User() {
    }

    
    public User(String UserName, String Email, String Password, double score) {
        this.UserName = UserName;
        this.Email = Email;
        this.Password = Password;
        this.score = score;
    }

  
    
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    
}
