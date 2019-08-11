package mgierasinski.service;

import mgierasinski.domain.Quantity;

import java.util.List;

public interface QuantityService {

    Quantity getQuantity(long id);
void removePrevious(long productId);

void addQuantity(Quantity quantity);

List<Quantity> selectAllForProduct(long productId);
    void changeOnlyProductQuantity(long productId,String szt,String rozmiar);
String getActualQuantity(long productId,String rozmiar);




}
