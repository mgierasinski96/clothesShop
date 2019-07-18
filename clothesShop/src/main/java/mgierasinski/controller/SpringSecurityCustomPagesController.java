package mgierasinski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringSecurityCustomPagesController {

    @RequestMapping(value = "/login")
    public String customLogin(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,
                              Model model) {
        if (error != null) {
            model.addAttribute("error", "Niepoprawna nazwa użytkownika lub hasło");
        }

        if (logout != null) {
            model.addAttribute("msg", "");
        }

        return "mainBody";
    }

    @RequestMapping(value = "/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }

}


