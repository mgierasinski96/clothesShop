package mgierasinski.domain;

import com.mysql.cj.jdbc.Blob;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {


    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "productName")
    private String name;

    @Column(name = "productPrice")
    private String price;

    @Column(name="productType")
    String productType;

    @Lob
    @Column(name="picture")
    private byte[] data;

    public byte[] getData() {

        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    //    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "product_sizes",
//            joinColumns = @JoinColumn(name = "productId"),
//            inverseJoinColumns = @JoinColumn(name = "sizeId")
//    )
//    private List<ProductSize> productSizes;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
            private Set<Quantity> quantity;

    public Set<Quantity> getQuantity() {
        return quantity;
    }

    public void setQuantity(Set<Quantity> quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

//    public List<ProductSize> getProductSizes() {
//        return productSizes;
//    }
//
//    public void setProductSizes(List<ProductSize> productSizes) {
//        this.productSizes = productSizes;
//    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }


}




