package mgierasinski.service;

import mgierasinski.domain.Quantity;

import java.util.List;

public interface QuantityService {

    Quantity getQuantity(long id);
void removePrevious(long productId);

List<Quantity> selectAllForProduct(long productId);



}
