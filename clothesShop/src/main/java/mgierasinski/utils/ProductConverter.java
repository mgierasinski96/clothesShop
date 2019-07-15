package mgierasinski.utils;

import mgierasinski.domain.Product;
import mgierasinski.domain.Quantity;
import mgierasinski.service.ProductService;
import mgierasinski.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class ProductConverter implements Converter<String, Product> {

    @Autowired
    ProductService productService;

    @Override
    public Product convert(String source) {
        return productService.getProduct(Integer.parseInt(source));
    }
}


