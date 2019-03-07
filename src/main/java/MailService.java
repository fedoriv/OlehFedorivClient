import web.soap.server.Mail;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface MailService {

    boolean send(Mail mail);

    boolean remove(List<Mail> mail);

    void removeAll();

    List<Mail> getAll();

    List<Mail> findByEmail(String email);

    List<Mail> findByTitle(String title);

    Mail findById(String id);

}
