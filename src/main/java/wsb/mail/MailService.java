package wsb.mail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    final private JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    void send(Mail mail) {
        try {

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo(mail.recipient);
            helper.setSubject(mail.subject);
            helper.setText(mail.content);

            helper.addAttachment(mail.attachment.getOriginalFilename(), mail.attachment);

            javaMailSender.send(mimeMessage);

        } catch (Exception e) {
            System.out.println("cos nie tak ");
            e.printStackTrace();
        }

    }
}
