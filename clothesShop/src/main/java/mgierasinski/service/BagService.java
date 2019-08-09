package mgierasinski.service;

import mgierasinski.domain.Bag;

import java.util.List;

public interface BagService {

    Bag findById(long id);
    void addBag(Bag bag);

    List<Bag> listBagForUser(long userId);
    List<Bag> listBagWherePayment(long paymentId);
    void removeBag(long bagId);

    void payBagForUser(long userId);
    void payForBagPayment(long userId,long paymentId);
}
