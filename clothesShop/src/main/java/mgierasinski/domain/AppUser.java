package mgierasinski.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    long userId;

    @Column(name="firstName")
    String firstName;

    @Column(name="lastName")
    String lastName;

    @Column(name="email")
    String email;

    @Column(name="address")
    String address;

    @NotNull
    @Column(name = "login", unique = true)
    private String login;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "telephone")
    private String telephone;

    @Column(name="activated")
    private Boolean activated;


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUserRole> appUserRole = new HashSet<AppUserRole>(0);

    public Set<AppUserRole> getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(Set<AppUserRole> appUserRole) {
        this.appUserRole = appUserRole;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }


}
