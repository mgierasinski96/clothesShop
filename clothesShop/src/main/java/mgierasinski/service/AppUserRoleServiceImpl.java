package mgierasinski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mgierasinski.dao.AppUserRoleRepository;
import mgierasinski.domain.AppUserRole;

import java.util.List;

@Service
public class AppUserRoleServiceImpl implements mgierasinski.service.AppUserRoleService {

    @Autowired
    AppUserRoleRepository appUserRoleRepository;

    @Transactional
    public void addAppUserRole(AppUserRole appUserRole) {
        appUserRoleRepository.save(appUserRole);
    }

    @Transactional
    public List<AppUserRole> listAppUserRole() {
        return appUserRoleRepository.findAll();
    }

    @Transactional
    public AppUserRole getAppUserRole(long id) {
        return appUserRoleRepository.getOne(id);
    }
}

