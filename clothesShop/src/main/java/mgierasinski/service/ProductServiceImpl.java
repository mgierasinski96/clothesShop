package mgierasinski.service;


import mgierasinski.dao.ProductRepository;
import mgierasinski.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.sql.DataSource;
import java.io.IOException;
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

    @Override
    public List<Product> listProductsWithSizes() {
        return productRepository.listProductsWithSizes();
    }


}



