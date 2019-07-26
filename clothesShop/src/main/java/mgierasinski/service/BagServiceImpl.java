package mgierasinski.service;

import mgierasinski.dao.BagRepository;
import mgierasinski.domain.Bag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BagServiceImpl implements  BagService{
    @Autowired
    BagRepository bagRepository;


    @Override
    public Bag findById(long id) {
        return bagRepository.findByBagId(id);
    }

    @Override
    public void addBag(Bag bag) {
        bagRepository.save(bag);
    }


}
