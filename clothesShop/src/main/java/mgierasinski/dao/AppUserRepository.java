package mgierasinski.dao;

import mgierasinski.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByEmail(String email);
    AppUser findByUserId(long id);

    AppUser findByLogin(String login);



}


