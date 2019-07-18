package mgierasinski.service;

import mgierasinski.domain.AppUserRole;

import java.util.List;

public interface AppUserRoleService {

    void addAppUserRole(AppUserRole appUserRole);

    List<AppUserRole> listAppUserRole();

    AppUserRole getAppUserRole(long id);

}

