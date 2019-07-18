package mgierasinski.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mgierasinski.domain.AppUserRole;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AppUserRoleRepository extends JpaRepository<AppUserRole, Long> {
    AppUserRole findByRole(String role);

}

