package mgierasinski.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="VerificationToken")
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private long tokenid;

    @Column(name = "confirmation_token")
    private String confirmationToken;



    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private AppUser appUser;

    public VerificationToken(AppUser appUser){
        this.appUser = appUser;
        confirmationToken = UUID.randomUUID().toString();
    }

    public VerificationToken() {

    }

    public long getTokenid() {
        return tokenid;
    }

    public void setTokenid(long tokenid) {
        this.tokenid = tokenid;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
