package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.service.AppUserService;
import mgierasinski.service.BagService;
import mgierasinski.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderHistoryController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    BagService bagService;

    @Autowired
    AppUserService appUserService;

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

    @RequestMapping(value="/myOrderHistory")
    public String showMyOrderHistory(Model model)
    {  String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        if (!(username.equals("anonymousUser") || username.equals("admin") || username.equals("employee") || username.equals("user"))) {
            AppUser appUser = appUserService.findByLogin(username);

        model.addAttribute("firstName",appUser.getFirstName());
        model.addAttribute("lastName",appUser.getLastName());
        model.addAttribute("orderHistoryForUser",paymentService.listPaymentForUser(appUser.getUserId()));
        model.addAttribute("orderHistoryForUserSize",paymentService.listPaymentForUser(appUser.getUserId()).size());
        }//tu zamknalem

        return "showOrderHistory";
    }


    @RequestMapping(value="/paymentDetails")
    public String showPaymentDetails(@RequestParam("paymentId") long paymentId,Model model)
    {
        model.addAttribute("myProducts",bagService.listBagWherePayment(paymentId));
        model.addAttribute("myProductsSize",bagService.listBagWherePayment(paymentId).size());
        System.out.println(bagService.listBagWherePayment(paymentId).size());

        return "showPaymentHistorical";
    }
}
