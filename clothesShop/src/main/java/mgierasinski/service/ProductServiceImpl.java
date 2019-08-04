package mgierasinski.service;


import mgierasinski.dao.ProductRepository;
import mgierasinski.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.sql.DataSource;
import java.sql.Blob;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    private JdbcTemplate jdbcTemp;

    public ProductServiceImpl(DataSource dataSource) {
        jdbcTemp = new JdbcTemplate(dataSource);
    }

    @Transactional
    public List<Product> listAccurateProduct(String typProduktu) {
        return productRepository.listAccurateProduct(typProduktu);
    }

    @Transactional
    public Blob getPhotoById(long id) {

        String query = "select p.picture from product p where p.productId=?";

        Blob photo = jdbcTemp.queryForObject(query, new Object[] { id }, Blob.class);

        return photo;
    }

    @Transactional
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void addProduct(Product product) {
        productRepository.save(product);

    }

    @Transactional
    public void editProduct(Product product) {

        productRepository.save(product);
    }

    @Transactional
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public void removeProduct(long id) {

        productRepository.delete(id);
    }

    @Transactional
    public Product getProduct(long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void insertQS(String quantity, String size,long pId) {
        productRepository.insertQS(quantity,pId,size);
    }

    @Transactional
    public List<Product> listProductsWithSizes() {
        return productRepository.listProductsWithSizes();
    }

    @Transactional
    public List<Product> listProductsOrderName() {
        return productRepository.listProductsOrderName();
    }
    @Transactional
    public List<Product> listProductsOrderNameDesc() {
        return productRepository.listProductsOrderNameDesc();
    }

    @Transactional
    public List<Product> listProductsOrderPrice() {
        return productRepository.listProductsOrderPrice();
    }

    @Transactional
    public List<Product> listProductsOrderPriceDesc() {
        return productRepository.listProductsOrderPriceDesc();
    }

    @Transactional
    public List<Product> searchForProducts(String search) {
        return productRepository.searchForProducts(search);
    }

    @Transactional
    public List<Product> showProductsInMyBag(long id) {
        return productRepository.showProductsInMyBag(id);
    }




}



