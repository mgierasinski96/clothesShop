package mgierasinski.service;

import mgierasinski.dao.PaymentRepository;
import mgierasinski.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment findById(long id) {
        return paymentRepository.findByPaymentId(id);
    }

    @Override
    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public List<Payment> listPaymentForUser(long userId) {
        return paymentRepository.listPaymentForUser(userId);
    }

    @Override
    public void removePayment(long id) {
        paymentRepository.delete(id);
    }
}
