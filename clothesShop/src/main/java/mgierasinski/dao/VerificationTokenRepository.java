package mgierasinski.dao;

import mgierasinski.domain.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, String> {
    VerificationToken findByConfirmationToken(String verificationToken);
    @Query(value = "delete from verificationtoken v where v.token_id=:token_id", nativeQuery = true)
    void deleteToken(@Param("token_id") long token_id);
}
