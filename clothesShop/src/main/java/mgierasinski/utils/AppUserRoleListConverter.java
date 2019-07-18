package mgierasinski.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import mgierasinski.domain.AppUserRole;
import mgierasinski.service.AppUserRoleService;

import java.util.HashSet;
import java.util.Set;

public class AppUserRoleListConverter implements Converter<String[], Set<AppUserRole>> {

	@Autowired
	AppUserRoleService appUserRoleService;
	
	@Override
	public Set<AppUserRole> convert(String[] source) {
		
		Set<AppUserRole> userRoleList = new HashSet<AppUserRole>(0);
		
		for (int i=0; i < source.length; i++)
		{
			//System.out.println("role id: " + source[i]);
			userRoleList.add(appUserRoleService.getAppUserRole(Integer.parseInt(source[i])));
		}
		
		return userRoleList;
	}
}


