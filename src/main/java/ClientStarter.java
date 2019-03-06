import web.soap.server.Mail;
import web.soap.server.MailService;
import web.soap.server.MailServiceImplService;

import java.util.List;

public class ClientStarter {
    public static void main(String[] args) {
        MailService mailService = new MailServiceImplService().getMailServiceImplPort();
        Mail mail = new Mail();
        mail.setReceiver("evilzluj@mail.ru");
        mail.setTitle("Test");
        mailService.send(mail);
        List<Mail> mails = mailService.getAll();
        mailService.findByEmail("evilzluj@mail.ru");
        for (Mail m : mails) System.out.println(m.getReceiver());
    }
}
