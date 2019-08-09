package mgierasinski.dao;

import mgierasinski.domain.Bag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BagRepository extends JpaRepository<Bag,Long> {

    Bag findByBagId(long id);


    @Query(value = "update bag b set b.paid=true where appUserIdBag=:userId",nativeQuery = true)
    @Modifying
    @Transactional
    void  payForBag(@Param("userId") long appUserId);

    @Query(value = "update bag b set b.paymentId=:paymentId where appUserIdBag=:userId and b.paid is null",nativeQuery = true)
    @Modifying
    @Transactional
    void  payForBagPayment(@Param("userId") long appUserId,@Param("paymentId") long paymentId);

    @Query(value="select * from bag b where b.appUserIdBag=:userId and b.paid is null",nativeQuery = true)
    List<Bag> listBagForUser(@Param("userId") long userId);

    @Query(value="select * from bag b where b.paymentId=:paymentId and b.paid is true",nativeQuery = true)
    List<Bag> listBagWherePayment(@Param("paymentId") long paymentId);

    @Query(value = "select * from clothesshop_tracker.bag where TIMESTAMPDIFF(MINUTE,clothesshop_tracker.bag.data,UTC_TIMESTAMP())>=2 and paid is null; ", nativeQuery = true)
    @org.springframework.transaction.annotation.Transactional
    List<Bag> selectMoreEq2mins();





    @Query(value = "delete FROM clothesshop_tracker.bag where TIMESTAMPDIFF(MINUTE,clothesshop_tracker.bag.data,UTC_TIMESTAMP())>=2 and paid is null; ", nativeQuery = true)
    @org.springframework.transaction.annotation.Transactional
    @Modifying
    void deleteMoreEq2mins();
}
