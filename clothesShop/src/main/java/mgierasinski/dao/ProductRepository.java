package mgierasinski.dao;

import mgierasinski.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findById(long id);
    Product findByName(String name);


    @Query(value = "insert into quantityandsize(quantity,size,productId) values (:quantity,:size,:productId)", nativeQuery = true)
    @Transactional
    @Modifying
    void insertQS(@Param("quantity") String quantity,@Param("productId") long productId,@Param("size") String size);

    @Query(value="select * from product p join product_sizes ps join productsize psz where p.productId=ps.productId and ps.sizeId=psz.sizeId",nativeQuery = true)
    @Transactional
    List<Product> listProductsWithSizes();

}