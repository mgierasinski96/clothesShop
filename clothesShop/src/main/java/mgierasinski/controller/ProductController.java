package mgierasinski.controller;


import mgierasinski.domain.Product;
import mgierasinski.service.ProductService;
import mgierasinski.service.QuantityService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;


@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    QuantityService quantityService;


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

    @RequestMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {

        productService.removeProduct(productId);


        return "redirect:/showAllProducts.html";
    }

    @RequestMapping(value = "/getStudentPhoto/{id}")
    public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
        response.setContentType("image/jpeg");

        Blob ph = productService.getPhotoById(id);

        byte[] bytes = ph.getBytes(1, (int) ph.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }


}