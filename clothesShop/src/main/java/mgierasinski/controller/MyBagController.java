package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.domain.Bag;
import mgierasinski.domain.Product;
import mgierasinski.service.AppUserService;
import mgierasinski.service.BagService;
import mgierasinski.service.ProductService;
import mgierasinski.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyBagController {

    @Autowired
    ProductService productService;

    @Autowired
    QuantityService quantityService;

    @Autowired
    BagService bagService;

    @Autowired
    AppUserService appUserService;

    @RequestMapping(value = "/addToBag")
    public String addProductToBag(@RequestParam("productId") long id, HttpServletRequest request, @RequestParam("size") String size) {

        String referer = request.getHeader("Referer");
        Bag bag=new Bag();
        Product product = productService.getProduct(id);
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        AppUser appUser = appUserService.findByLogin(username);

        bag.setAppUser(appUser);
        bag.setProduct(product);
        bag.setProductSize(size);



        int obecnieSztuk=Integer.parseInt(quantityService.getActualQuantity(product.getId(),size));
        quantityService.changeOnlyProductQuantity(product.getId(),Integer.toString(obecnieSztuk-1),size);
        bagService.addBag(bag);

        return "redirect:" + referer;

    }


    @RequestMapping(value="/showMyProducts")
    public String showMyProducts(Model model)
    {

        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        if (!(username.equals("anonymousUser") || username.equals("admin") || username.equals("employee") || username.equals("user"))) {
            AppUser appUser = appUserService.findByLogin(username);

            model.addAttribute("myProducts",bagService.listBagForUser(appUser.getUserId()));
            model.addAttribute("myProductsSize",bagService.listBagForUser(appUser.getUserId()).size());


        }

        return "showMyProductsInBag";
    }

    @RequestMapping(value = "/deleteProductFromBag/{bagId}")
    public String deleteProductFromBag(@RequestParam("bagId") long bagId,HttpServletRequest request) {
        String referer = request.getHeader("Referer");

        Bag bag=bagService.findById(bagId);

        int obecnieSztuk=Integer.parseInt(quantityService.getActualQuantity(bag.getProduct().getId(),bag.getProductSize()));
        System.out.println(obecnieSztuk);
        quantityService.changeOnlyProductQuantity(bag.getProduct().getId(),Integer.toString(obecnieSztuk+1),bag.getProductSize());
        bagService.removeBag(bagId);

        return "redirect:" + referer;
    }
}
