package mgierasinski.controller;

import mgierasinski.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/szukam")
    public String szukajProduktu(@RequestParam(name = "search") String czegoSzukam, Model model) {

        model.addAttribute("searchSize",productService.searchForProducts(czegoSzukam).size());
        model.addAttribute("searchProducts",productService.searchForProducts(czegoSzukam));

        return "searchProducts";
    }


}
