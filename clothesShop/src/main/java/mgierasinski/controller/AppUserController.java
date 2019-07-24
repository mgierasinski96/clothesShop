package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.domain.VerificationToken;
import mgierasinski.service.AppUserService;
import mgierasinski.service.EmailSenderService;
import mgierasinski.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    VerificationTokenService verificationTokenService;

    @RequestMapping(value = "/registerAppUser")
    public String registerAppUser(Model model) {
        model.addAttribute("appUser", new AppUser());
        return "registerAppUser";
    }

    @RequestMapping(value = "/addAppUser", method = RequestMethod.POST)
    public String addAppUser(@ModelAttribute("appUser") AppUser appUser, BindingResult result) {


        if (result.getErrorCount() == 0) {

            if (appUser.getUserId() == 0) {

                appUserService.addAppUser(appUser);

                VerificationToken verificationToken = new VerificationToken(appUser);
                verificationTokenService.add(verificationToken);
                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setTo("clothesshoparmani@gmail.com");//tu wysylam
                simpleMailMessage.setSubject("Weryfikacja konta");
                simpleMailMessage.setFrom("clothesshoparmani@gmail.com");
                simpleMailMessage.setText("Witaj "+appUser.getFirstName()+ "! Dziękujemy, że z nami jesteś. \n Aby dokończyć rejestrację, kliknij w poniższy link:"
                        +
                        "http://localhost:8080/confirmAccount?token=" + verificationToken.getConfirmationToken());
                emailSenderService.sendEmail(simpleMailMessage);
                return "successfulRegistration";

            }
        }

        return "registerAppUser";
    }

    @RequestMapping(value = "/confirmAccount")
    public String confirmAccount(@RequestParam("token") String verificationToken) {
        VerificationToken token = verificationTokenService.findByConfirmationToken(verificationToken);
        if (token != null) {
            AppUser appUser = appUserService.findByEmail(token.getAppUser().getEmail());
            appUserService.activateAppUser(appUser);
            return "accountActivated";
        } else {
            return "tokenExpired";
        }
    }


}

