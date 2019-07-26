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
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import java.util.List;


@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    QuantityService quantityService;

    @Autowired
    BagService bagService;

    @Autowired
    AppUserService appUserService;



    @RequestMapping(value = "/newProduct")
    public String newProduct(Model model, HttpServletRequest request) {

        int productId = ServletRequestUtils.getIntParameter(request, "productId", -1);
        if (productId > 0) {

            Product product = productService.getProduct(productId);
            quantityService.removePrevious(productId);
            model.addAttribute("product", product);

        } else
            model.addAttribute("product", new Product());


        return "addProduct";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/addNewProduct")
    public String addNewProduct(@ModelAttribute("product") Product product, @RequestParam CommonsMultipartFile[] fileUpload, @RequestParam("quantity") String quantity,
                                @RequestParam("size") List<String> sizes) {

        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload) {

                System.out.println("Saving file: " + aFile.getOriginalFilename());
                product.setData(aFile.getBytes());
                productService.addProduct(product);

                for (String size : sizes) {
                    productService.insertQS(quantity, size, product.getId());
                }
            }
        }

        return "redirect:newProduct.html";
    }

    @RequestMapping(value = "/showAllProducts")
    public String showAllProducts(Model model) {
        model.addAttribute("allProducts", productService.listProducts());


        return "showAllProducts";
    }

    @RequestMapping(value = "/showAllProductsOrderByName")
    public String showAllProductsOrderByName(Model model) {
        model.addAttribute("allProducts", productService.listProductsOrderName());


        return "showAllProducts";
    }

    @RequestMapping(value = "/showAllProductsOrderByNameDesc")
    public String showAllProductsOrderByNameDesc(Model model) {
        model.addAttribute("allProducts", productService.listProductsOrderNameDesc());


        return "showAllProducts";
    }

    @RequestMapping(value = "/showAllProductsOrderByPrice")
    public String showAllProductsOrderByPrice(Model model) {
        model.addAttribute("allProducts", productService.listProductsOrderPrice());

        return "showAllProducts";
    }

    @RequestMapping(value = "/showAllProductsOrderByPriceDesc")
    public String showAllProductsOrderByPriceDesc(Model model) {
        model.addAttribute("allProducts", productService.listProductsOrderPriceDesc());

        return "showAllProducts";
    }


    @RequestMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {

        productService.removeProduct(productId);


        return "redirect:/showAllProducts.html";
    }

    @RequestMapping(value = "/showSpecificProduct/{productId}")
    public String showProduct(@RequestParam("productId") long id, Model model) {


        System.out.println("1asdsadsadasd");
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("quantity", quantityService.selectAllForProduct(id));

        return "showSpecificProduct";


    }

    @RequestMapping(value = "/changeProductQuantity")
    public String changeProductQuantity(@RequestParam("productId") long id, @RequestParam("zmienSzt") String szt,
                                        @RequestParam("zmienRozmiar") String rozmiar, HttpServletRequest request) {
        String referer = request.getHeader("Referer");

        quantityService.changeOnlyProductQuantity(id, szt, rozmiar);

        return "redirect:" + referer;
    }

    @RequestMapping(value = "/addToBag")
    public String addProductToBag(@RequestParam("productId") long id,HttpServletRequest request,@RequestParam("size") String size) {

        System.out.println("ADD TO BAG");
        System.out.println("szajz "+size);
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

        System.out.println("adresssssssssssssssssssssssssssssssssssss " +appUser.getAddress());
        System.out.println(product.getName());
        bag.setAppUser(appUser);
        bag.setProduct(product);
        bag.setProductSize(size);


        bagService.addBag(bag);


        return "redirect:" + referer;


    }



}
