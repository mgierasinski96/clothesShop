package mgierasinski.domain;

import javax.persistence.*;

@Entity
@Table(name="payment")
public class Payment {

    @Id
    @Column(name="paymentId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long paymentId;

    @Column(name="charge")
    String charge;

    @ManyToOne
    @JoinColumn(name = "appUserId")
    AppUser appUser;

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
