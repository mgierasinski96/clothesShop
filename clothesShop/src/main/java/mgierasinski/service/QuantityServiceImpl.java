package mgierasinski.service;

import mgierasinski.dao.QuantityRepostitory;
import mgierasinski.domain.Quantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public void addQuantity(Quantity quantity) {
        quantityRepostitory.save(quantity);
    }

    @Transactional
    public List<Quantity> selectAllForProduct(long productId) {
        return quantityRepostitory.selectAllForProduct(productId);
    }

    @Override
    public void changeOnlyProductQuantity(long productId, String szt, String rozmiar) {
        quantityRepostitory.changeOnlyProductQuantity(productId,szt,rozmiar);
    }

    @Transactional
    public String getActualQuantity(long productId, String rozmiar) {
        return quantityRepostitory.getActualQuantity(productId,rozmiar);
    }



}
