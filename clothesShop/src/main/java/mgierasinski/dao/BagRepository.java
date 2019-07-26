package mgierasinski.dao;

import mgierasinski.domain.Bag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BagRepository extends JpaRepository<Bag,Long> {

    Bag findByBagId(long id);


}
