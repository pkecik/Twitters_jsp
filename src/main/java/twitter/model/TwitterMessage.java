package twitter.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rafal on 2017-08-31.
 */
@Entity
@Table(name = "Twitters")
public class TwitterMessage {


    public TwitterMessage(String message, Date dateOfCreation, String userName) {
        this.message = message;
        this.dateOfCreation = dateOfCreation;
        this.userName = userName;
    }

    public TwitterMessage() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;
    private Date dateOfCreation;
    private String userName;
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
