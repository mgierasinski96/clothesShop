package mgierasinski.domain;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name="bag")
public class Bag {

    @Id
    @Column(name="bagId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long bagId;

    @ManyToOne
    @JoinColumn(name = "productIdBag")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "paymentId")
    private Payment payment;


    @ManyToOne
    @JoinColumn(name = "appUserIdBag")
    private AppUser appUser;

    @Column(name="productSize")
    private String productSize;

    @Column(name="data")
    private Date date;
public Bag()
{
    this.date=new Date();
}

    @Column(name="paid")
    private Boolean paid;

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public long getBagId() {
        return bagId;
    }

    public void setBagId(long bagId) {
        this.bagId = bagId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "bagId=" + bagId +
                ", product=" + product +
                ", appUser=" + appUser +
                ", productSize='" + productSize + '\'' +
                ", date=" + date +
                '}';
    }
}
