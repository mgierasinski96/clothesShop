package mgierasinski.service;


import mgierasinski.domain.AppUser;
import mgierasinski.domain.AppUserRole;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Set;

public interface AppUserService {


    void addAppUser(AppUser user);


    void editAppUser(AppUser user);

    List<AppUser> listAppUser();

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void removeAppUser(long id);

    AppUser getAppUser(long id);

    void setRole(long id, Set<AppUserRole> roles);

    AppUser findByLogin(String login);

    AppUser findByEmail(String email);


    void activateAppUser(mgierasinski.domain.AppUser appUser);

}
