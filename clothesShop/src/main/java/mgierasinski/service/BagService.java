package mgierasinski.service;

import mgierasinski.domain.Bag;

public interface BagService {

    Bag findById(long id);
    void addBag(Bag bag);
}
