package mgierasinski.service;

import mgierasinski.domain.Product;

import java.sql.Blob;
import java.util.List;

public interface ProductService {

    List<Product> listAccurateProduct(String typProduktu);

    Blob getPhotoById(long id);

    Product findById(long id);

    void addProduct(Product product);

    void editProduct(Product product);

    List<Product> listProducts();

    void removeProduct(long id);

    Product getProduct(long id);

    void insertQS(String quantity, String size, long pId);

    List<Product> listProductsWithSizes();

    List<Product> listProductsOrderName();
    List<Product> listProductsOrderNameDesc();

    List<Product> listProductsOrderPrice();

    List<Product> listProductsOrderPriceDesc();

    List<Product> searchForProducts(String search);

}
