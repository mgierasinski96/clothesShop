package mgierasinski.controller;

import mgierasinski.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value="/bluzy")
    public String showBluzy(Model model)
    {
        model.addAttribute("bluzy",productService.listAccurateProduct("bluza"));
        model.addAttribute("bluzySize",productService.listAccurateProduct("bluza").size());


        return "bluzy";
    }

    @RequestMapping(value="/spodnie")
    public String showSpodnie(Model model)
    {
        model.addAttribute("spodnie",productService.listAccurateProduct("spodnie"));
        model.addAttribute("spodnieSize",productService.listAccurateProduct("spodnie").size());


        return "spodnie";
    }

}
