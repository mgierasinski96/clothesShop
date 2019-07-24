package mgierasinski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainPageController {

    @RequestMapping("/")
    public String mainPage()
    {
        return "mainBody";
    }


}
