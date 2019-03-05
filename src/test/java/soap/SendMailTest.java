package soap;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.soap.server.Mail;
import web.soap.server.MailService;
import web.soap.server.MailServiceImplService;

import java.util.Date;


public class SendMailTest {

    private MailService mailService;

    @BeforeTest
    public void before() {
        mailService = new MailServiceImplService().getMailServiceImplPort();
    }
    @Test(dataProvider="mailParameters")
    public void sendMail(String email, String title, String text){
        mailService.removeAll();
        Mail mail = new Mail();
        mail.setReceiver(email);
        mail.setTitle(title + " " + new Date());
        mail.setText(text);
        mailService.send(mail);
        Assert.assertEquals(mailService.findById(mail.get).size(), 10);
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
