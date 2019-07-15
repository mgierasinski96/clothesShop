package mgierasinski.service;

import mgierasinski.dao.QuantityRepostitory;
import mgierasinski.domain.Quantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuantityServiceImpl implements QuantityService {

    @Autowired
    QuantityRepostitory quantityRepostitory;


    @Transactional
    public Quantity getQuantity(long id) {
        return quantityRepostitory.findByQuantityId(id);
    }

    @Transactional
    public void removePrevious(long productId) {
        quantityRepostitory.deletePrevious(productId);
    }
}
