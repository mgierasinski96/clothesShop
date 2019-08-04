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

    @Query(value="select * from bag b where b.appUserIdBag=:userId",nativeQuery = true)
    List<Bag> listBagForUser(@Param("userId") long userId);

}
