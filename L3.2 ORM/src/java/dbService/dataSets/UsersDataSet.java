package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
@Entity
@Table(name = "users")
public class UsersDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final Long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", unique = true, updatable = false)
    private String login;
    @Column(name = "password")
    private String pass;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet(Long id, String login, String pass) {
        this.setId(id);
        this.setLogin(login);
        this.setPass(pass);
    }

    public UsersDataSet(String login , String pass) {
        this.setId(-1L);
        this.setLogin(login);
        this.setPass(pass);
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getLogin() {
        return login;
    }
    @SuppressWarnings("UnusedDeclaration")
    public String getPass() {
        return pass;
    }
    @SuppressWarnings("UnusedDeclaration")
    public Long getId() {
        return id;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UsersDataSet{" + "id=" + id + ", login='" + login + '\'' + ", pass='" + pass + '\'' + '}';
    }
}