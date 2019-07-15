package mgierasinski.utils;

import mgierasinski.domain.Quantity;
import mgierasinski.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class QuantityConverter implements Converter<String, Quantity> {

	@Autowired
	QuantityService quantityService;
	
	@Override
	public Quantity convert(String source) {
		return quantityService.getQuantity(Integer.parseInt(source));
	}
}


