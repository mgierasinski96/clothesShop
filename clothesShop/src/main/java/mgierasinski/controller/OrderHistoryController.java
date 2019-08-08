package mgierasinski.controller;

import mgierasinski.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderHistoryController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value="/orderHistory")
    public String showOrderHistoryForUser(@RequestParam("userId") long userId, Model model,
    @RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName)
    {
       model.addAttribute("firstName",firstName);
       model.addAttribute("lastName",lastName);
        model.addAttribute("orderHistoryForUser",paymentService.listPaymentForUser(userId));
        model.addAttribute("orderHistoryForUserSize",paymentService.listPaymentForUser(userId).size());
        return "showOrderHistory";
    }
}
