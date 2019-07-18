package mgierasinski.controller;

import mgierasinski.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @RequestMapping(value="/registerAppUser")
    public String registerAppUser()
    {
        return "registerAppUser";
    }
}

