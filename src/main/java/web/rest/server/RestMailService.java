package web.rest.server;

import web.soap.server.Mail;
import web.soap.server.MailService;

import java.util.List;

public class RestMailService implements MailService {

    public boolean remove(List<Mail> arg0) {
        return false;
    }


    public boolean send(Mail arg0) {
        return false;
    }


    public List<Mail> findByEmail(String arg0) {
        return null;
    }


    public List<Mail> findByTitle(String arg0) {
        return null;
    }


    public Mail findById(String arg0) {
        return null;
    }


    public List<Mail> getAll() {
        return null;
    }


    public void removeAll() {

    }
}
