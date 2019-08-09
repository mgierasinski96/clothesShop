package mgierasinski.controller;

import mgierasinski.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchSpecificProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value="/bluzy")
    public String showBluzy(Model model)
    {
        model.addAttribute("product",productService.listAccurateProduct("bluza"));
        model.addAttribute("productSize",productService.listAccurateProduct("bluza").size());


        return "specificProducts";
    }

    @RequestMapping(value="/spodnie")
    public String showSpodnie(Model model)
    {
        model.addAttribute("product",productService.listAccurateProduct("spodnie"));
        model.addAttribute("productSize",productService.listAccurateProduct("spodnie").size());


        return "specificProducts";
    }

    @RequestMapping("/szukam")
    public String szukajProduktu(@RequestParam(name = "search") String czegoSzukam, Model model) {

        model.addAttribute("searchSize",productService.searchForProducts(czegoSzukam).size());
        model.addAttribute("searchProducts",productService.searchForProducts(czegoSzukam));

        return "searchProducts";
    }


}
