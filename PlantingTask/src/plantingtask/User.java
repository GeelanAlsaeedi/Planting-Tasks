package plantingtask;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="contact")
public class User implements java.io.Serializable {
    @Id
    @Column(name="Mobile")
    private String Mobile;
    @Column(name="Name")
    private String Name;
    

    public User() {
    }

    public User(String Name, String Moblie) {
        this.Name = Name;
        this.Mobile = Moblie;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMoblie() {
        return Mobile;
    }

    public void setMoblie(String Moblie) {
        this.Mobile = Moblie;
    }

    
}
