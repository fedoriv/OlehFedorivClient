package soap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.soap.server.Mail;
import web.soap.server.MailService;
import web.soap.server.MailServiceImplService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SendMailTest {

    private static Logger LOG = LogManager.getLogger(SendMailTest.class);
    private MailService mailService;

    @BeforeTest
    public void beforeTest() {
        mailService = new MailServiceImplService().getMailServiceImplPort();
    }

    @BeforeMethod
    public void beforeMethod() {
        mailService.removeAll();
    }

    @Test(dataProvider="mailParameters")
    public void sendMailTest(String email, String title, String text){
        Mail mail = new Mail();
        mail.setReceiver(email);
        mail.setTitle(title + " " + new Date());
        mail.setText(text);
        mailService.send(mail);
        Assert.assertEquals(mailService.findByEmail(email).get(0), email);
    }
    @Test
    public void getMailByTitleTest() {
        LOG.info("Test getMailByTitle() started.");
        Mail mail = new Mail();
        mail.setReceiver("evilzli@ukr.rrrr");
        mail.setTitle("SomeTitle");
        mail.setText("And some text");
//        mailService.send(mail);
        List<Mail> mailsByTitle = mailService.findByTitle("SomeTitl5e");
        for (Mail m : mailsByTitle) {
            Assert.assertEquals(m.getTitle(), "SomeTitle");
        }
    }
    @Test
    public void removeTest() {
        Mail mail = new Mail();
        mail.setReceiver("evilzli@ukr.rrrr");
        mail.setTitle("SomeTitle");
        mail.setText("And some text");
//        mailService.send(mail);
        List<Mail> mails = new ArrayList<Mail>();
        mails.add(mail);
        mailService.remove(mails);
    }
    @DataProvider(parallel=true, name="mailParameters")
    public Object[][] params() {
        return new Object[][]{
                { "email01@test.com", "Title 1", "Some kind of text"},
                { "email02@test.com", "Title 2", "Some kind of text"},
                { "email03@test.com", "Title 3", "Some kind of text"},
                { "email04@test.com", "Title 4", "Some kind of text"},
                { "email05@test.com", "Title 5", "Some kind of text"},
                { "email06@test.com", "Title 6", "Some kind of text"},
                { "email07@test.com", "Title 7", "Some kind of text"},
                { "email08@test.com", "Title 8", "Some kind of text"},
                { "email09@test.com", "Title 9", "Some kind of text"},
                { "email010@test.com", "Title 10", "Some kind of text"},
        };
    }
}
