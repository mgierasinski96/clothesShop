package mgierasinski.service;

import mgierasinski.domain.VerificationToken;


public interface VerificationTokenService {
    VerificationToken findByConfirmationToken(String confirmationToken);
    void add(VerificationToken verificationToken);

}
