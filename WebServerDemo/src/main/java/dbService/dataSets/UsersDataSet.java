package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class UsersDataSet implements Serializable {
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="login", unique = true, updatable = false)
    private String login;

    @Column(name="password", unique = true)
    private String password;

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet() {
    }

    @SuppressWarnings("UnesedDeclaration")
    public UsersDataSet(String login, String password) {
        this.id=-1;
        this.login=login;
        this.password=password;
    }

    public String getLogin() {
        return login;
    }


    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return "UsersDataSet: " + "login = " + login + " password = " + password;
    }
}
