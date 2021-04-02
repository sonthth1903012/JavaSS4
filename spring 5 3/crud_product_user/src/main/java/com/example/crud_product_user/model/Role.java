package t1907m.springboot_crud_product_user.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "roleId")
    private List<User_roles> listUserRole;

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    public Role(String name, List<User_roles> listUserRole) {
        this.name = name;
        this.listUserRole = listUserRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User_roles> getListUserRole() {
        return listUserRole;
    }

    public void setListUserRole(List<User_roles> listUserRole) {
        this.listUserRole = listUserRole;
    }
}
