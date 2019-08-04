package mgierasinski.service;

import mgierasinski.dao.BagRepository;
import mgierasinski.domain.Bag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    @Override
    public List<Bag> listBagForUser(long userId) {
        return bagRepository.listBagForUser(userId);
    }

    @Override
    @Transactional
    public void removeBag(long bagId) {
bagRepository.delete(bagId);
    }


}
