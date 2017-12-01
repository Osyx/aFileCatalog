package server.model;

import java.io.Serializable;
import javax.persistence.*;



@NamedQueries({
        @NamedQuery(
                name = "deleteUser",
                query = "DELETE FROM users user WHERE user.username LIKE :username AND user.password LIKE :password"
        )
        ,
        @NamedQuery(
                name = "checkUser",
                query = "SELECT user FROM users user WHERE user.username LIKE :username",
                lockMode = LockModeType.OPTIMISTIC
        )
})


@Entity(name = "users")
public class User implements Serializable{
    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    public User() {}

    public User(String name, String password) {
        this.username = name;
        this.password = password;
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
