package web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.rest.server.RestMailService;
import web.soap.server.Mail;
import web.soap.server.MailService;
import web.soap.server.MailServiceImplService;
import web.soap.server.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class SendMailsTest {

    private static Logger LOG = LogManager.getLogger(SendMailsTest.class);
    private MailService mailService;
    private RestMailService restMailService;
    private List<Mail> mailsToClearAfterTest;

    @Test(dataProvider = "mailParameters")
    public void sendMailSOAPTest(String email, String title, String text) {
        LOG.info("Test method sendMailSOAPTest() started");
        Mail mail = new Mail(email, title, text);
        mailsToClearAfterTest = new ArrayList<>();
        mailsToClearAfterTest.add(mail);
        mailService.send(mail);
        Assert.assertEquals(mailService.findByEmail(email).get(0).getReceiver(), email);
    }

    @Test(dataProvider = "mailParameters")
    public void sendMailRESTTest(String email, String title, String text) {
        LOG.info("Test method sendMailRESTTest() started");
        Mail mail = new Mail(email, title, text);
        mailsToClearAfterTest = new ArrayList<>();
        mailsToClearAfterTest.add(mail);
        try {
            restMailService.send(mail);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(mailService.findByEmail(email).get(0).getReceiver(), email);
    }

    @BeforeTest
    public void beforeTest() {
        LOG.info("@BeforeTest method started");

        mailService = new MailServiceImplService().getMailServiceImplPort();
        restMailService = new RestMailService();
    }

    @AfterMethod()
    public void deleteAddedMailsAfterTest() {
        LOG.info("@AfterMethod method started");

        mailService.remove(mailsToClearAfterTest);
    }
    @DataProvider(name = "mailParameters")
    public Object[][] params() {
        return new Object[][]{
                {"email01@test.com", "Title 1", "Some kind of text"},
                {"email02@test.com", "Title 2", "Some kind of text"},
                {"email03@test.com", "Title 3", "Some kind of text"},
                {"email04@test.com", "Title 4", "Some kind of text"},
                {"email05@test.com", "Title 5", "Some kind of text"},

        };
    }
}
