package mgierasinski.service;

import mgierasinski.domain.Payment;

import java.util.List;

public interface PaymentService {

    Payment findById(long id);
    void addPayment(Payment payment);

    List<Payment> listPaymentForUser(long userId);
    void removePayment(long id);
}
