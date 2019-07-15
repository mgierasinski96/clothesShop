package mgierasinski.domain;

import javax.persistence.*;

@Entity
@Table(name = "quantityAndSize")
public class Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUANTITY_ID")
    private long quantityId;

    public long getQuantityId() {
        return quantityId;
    }

    public void setQuantityId(long quantityId) {
        this.quantityId = quantityId;
    }


    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private String quantity;


    public String getSize() {
        return size;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
