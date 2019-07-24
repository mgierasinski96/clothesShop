package mgierasinski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mgierasinski.dao.VerificationTokenRepository;
import mgierasinski.domain.VerificationToken;

@Service
@Transactional
public class VerificationTokenServiceImpl implements VerificationTokenService {

    private final VerificationTokenRepository verificationTokenRepository;

    @Autowired
    public VerificationTokenServiceImpl(VerificationTokenRepository verificationTokenRepository) {
        this.verificationTokenRepository = verificationTokenRepository;
    }

    public VerificationToken findByConfirmationToken(String confirmationToken) {
        return verificationTokenRepository.findByConfirmationToken(confirmationToken);
    }

    @Override
    public void add(VerificationToken verificationToken) {
        verificationTokenRepository.save(verificationToken);
    }
}
