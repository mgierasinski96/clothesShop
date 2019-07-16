package mgierasinski.dao;

import mgierasinski.domain.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface QuantityRepostitory  extends JpaRepository<Quantity,Long> {


    Quantity findByQuantityId(long id);

    @Transactional
    @Modifying
    @Query(value = "delete from quantityandsize where productId=:productId",nativeQuery = true)
    void deletePrevious(@Param("productId") long productId);

    @Transactional
    @Query(value = "select * from quantityandsize where productId=:productId",nativeQuery = true)
    List<Quantity> selectAllForProduct(@Param("productId") long productId);

}
