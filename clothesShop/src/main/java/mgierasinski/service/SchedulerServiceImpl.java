package mgierasinski.service;

import mgierasinski.dao.BagRepository;
import mgierasinski.dao.QuantityRepostitory;
import mgierasinski.domain.Bag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    @Autowired
    BagRepository bagRepository;

    @Autowired
    QuantityRepostitory quantityRepostitory;

    @Scheduled(cron="0 0/1 * * * ?")//every minute
    public void demoServiceMethod()
    {
        System.out.println("Sprawdzam koszyki o: " + new Date());
        //dac liste usunietych bagow
       List<Bag> bagi=bagRepository.selectMoreEq2mins();

       for(Bag bag:bagi) {
           System.out.println(bag.toString());
           //pobrac ilosc sztuk
           int obecnieSztuk = Integer.parseInt(quantityRepostitory.getActualQuantity(bag.getProduct().getId(), bag.getProductSize()));
           //zwiekszyc liczbe o 1
           quantityRepostitory.changeOnlyProductQuantity(bag.getProduct().getId(), Integer.toString(obecnieSztuk + 1), bag.getProductSize());

       }
        bagRepository.deleteMoreEq2mins();

    }
}
