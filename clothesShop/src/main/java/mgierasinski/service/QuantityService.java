package mgierasinski.service;

import mgierasinski.domain.Quantity;

public interface QuantityService {

    Quantity getQuantity(long id);
void removePrevious(long productId);



}
