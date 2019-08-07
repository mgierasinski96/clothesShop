package mgierasinski.dao;

import mgierasinski.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    Payment findByPaymentId(long id);

    @Query(value="select * from payment p where p.appUserId=:userId",nativeQuery = true)
    List<Payment> listPaymentForUser(@Param("userId") long userId);
}
