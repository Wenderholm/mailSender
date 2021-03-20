package wsb.mail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class Mail {
    String recipient;
    String subject;
    String content;

    MultipartFile attachment;
}
