package mgierasinski.domain;

import javax.persistence.*;

@Entity
@Table(name = "appuserrole")
public class AppUserRole {

    @Id
    @Column(name = "idr")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUserRole{" +
                "role='" + role + '\'' +
                '}';
    }
}

