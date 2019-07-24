package mgierasinski.service;

import mgierasinski.dao.AppUserRepository;
import mgierasinski.dao.AppUserRoleRepository;
import mgierasinski.domain.AppUser;
import mgierasinski.domain.AppUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AppUserRoleRepository appUserRoleRepository;

    @Transactional
    public void addAppUser(AppUser appUser) {
        appUser.getAppUserRole().add(appUserRoleRepository.findByRole("ROLE_USER"));//przypisz role user
        appUser.setPassword(hashPassword(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

    @Transactional
    public void setRole(long id, Set<AppUserRole> roles) {
        appUserRepository.getOne(id).setAppUserRole(roles);
    }

    @Transactional
    public void editAppUser(AppUser appUser) {
        appUser.setPassword(hashPassword(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> listAppUser() {
        return appUserRepository.findAll();
    }

    @Transactional
    public void removeAppUser(long id) {
        appUserRepository.delete(id);
    }

    @Transactional
    public AppUser getAppUser(long id) {
        return appUserRepository.findByUserId(id);
    }

    @Transactional
    public AppUser findByLogin(String login) {
        return appUserRepository.findByLogin(login);
    }



    private String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public AppUser findByEmail(String email) { return appUserRepository.findByEmail(email); }

    @Transactional
    @Modifying
    public void activateAppUser(AppUser appUser) {
        appUser.setActivated(true);
        appUserRepository.save(appUser);
    }


}


