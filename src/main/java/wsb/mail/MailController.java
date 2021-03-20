package wsb.mail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MailController {

    final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }


    @GetMapping("/")
    String getMailForm() {
        return "mailForm";
    }

    @PostMapping("send")
    String send(@ModelAttribute Mail mail) {
        mailService.send(mail);
        return "mailForm";
    }
}
