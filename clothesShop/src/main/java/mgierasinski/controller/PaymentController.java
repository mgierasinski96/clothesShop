package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.domain.Payment;
import mgierasinski.service.AppUserService;
import mgierasinski.service.BagService;
import mgierasinski.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    AppUserService appUserService;

    @Autowired
    BagService bagService;

    @RequestMapping(value="/payPayment")
    public String payPayment(HttpServletRequest request,@RequestParam("total") String total)
    {

        String referer = request.getHeader("Referer");
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        if (!(username.equals("anonymousUser") || username.equals("admin") || username.equals("employee") || username.equals("user"))) {
            AppUser appUser = appUserService.findByLogin(username);


            Payment payment = new Payment();
            System.out.println("pejment id" + payment.getPaymentId());
            payment.setAppUser(appUser);
            payment.setCharge(total);
            paymentService.addPayment(payment);
            bagService.payForBagPayment(appUser.getUserId(), payment.getPaymentId());
            bagService.payBagForUser(appUser.getUserId());

        }//tu zamknalem


        return "redirect:" + referer;
    }


}
