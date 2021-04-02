package t1907m.springboot_crud_product_user.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Transient
    private String passwordConfirm;

    @OneToMany(mappedBy = "userId")
    private List<User_roles> listUserRole;


    public User() {
    }

    public User(String username, String password, String passwordConfirm, List<User_roles> listUserRole) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.listUserRole = listUserRole;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public List<User_roles> getListUserRole() {
        return listUserRole;
    }

    public void setListUserRole(List<User_roles> listUserRole) {
        this.listUserRole = listUserRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
