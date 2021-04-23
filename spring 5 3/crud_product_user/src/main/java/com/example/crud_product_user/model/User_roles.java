package t1907m.springboot_crud_product_user.model;


import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class User_roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "roles_id", referencedColumnName = "id")
    private Role roleId;

    public User_roles() {
    }

    public User_roles(User userId, Role roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }
}
