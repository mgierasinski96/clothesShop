package mgierasinski.domain;


import javax.persistence.*;

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
    @JoinColumn(name = "appUserIdBag")
    private AppUser appUser;

    @Column(name="productSize")
    private String productSize;

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
}
