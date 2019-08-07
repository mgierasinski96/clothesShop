package mgierasinski.service;

import mgierasinski.domain.Bag;

import java.util.List;

public interface BagService {

    Bag findById(long id);
    void addBag(Bag bag);

    List<Bag> listBagForUser(long userId);
    void removeBag(long bagId);
    void deleteBagForUser(long userId);
}
