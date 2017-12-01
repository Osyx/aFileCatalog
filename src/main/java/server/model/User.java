package server.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;


@Entity(name = "User")
public class User implements Serializable{
    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Version
    @Column(name = "OPTLOCK")
    private int versionNum;

    public User() {
        this(null);
    }

    public User(String name) {
        this.username = name;
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
