package web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import web.rest.server.RestMailService;
import web.soap.server.Mail;
import web.soap.server.MailService;
import web.soap.server.MailServiceImplService;
import web.soap.server.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class FindByReceiverTest {

    private static Logger LOG = LogManager.getLogger(FindByReceiverTest.class);

    private MailService mailService;
    private RestMailService restMailService;
    private List<Mail> mailsForRemove;
    private static final String TEST_EMAIL = "randomeReceiver@test.com";



    @BeforeTest
    public void beforeTest() {
        LOG.info("@BeforeTest method started");
        mailService = new MailServiceImplService().getMailServiceImplPort();
        restMailService = new RestMailService();
        mailService.clearMails();
    }
    @BeforeMethod
    public void fill() {
        LOG.info("@BeforeMethod method started");

        mailsForRemove = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            Mail mail = new Mail(TEST_EMAIL, "Title to remove " + i, "Find by receiver test " + i);
            mailService.send(mail);
            mailsForRemove.add(mail);
        }
    }
    @Test
    public void findMailByReceiverSOAPTest() {
        LOG.info("Test method findMailByReceiverSOAPTest() started");
        List<Mail> tmp = mailService.findByEmail(TEST_EMAIL);
        Assert.assertEquals(tmp.size(), 3);
        for (Mail m : tmp) {
            Assert.assertEquals(m.getReceiver(), TEST_EMAIL);
        }
    }

    @Test
    public void findMailByReceiverRESTTest() {
        LOG.info("Test method findMailByReceiverSOAPTest() started");

        try {
            List<Mail> tmp = restMailService.findByEmail(TEST_EMAIL);
            Assert.assertEquals(tmp.size(), 3);
            for (Mail m : tmp) {
                Assert.assertEquals(m.getReceiver(), TEST_EMAIL);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }

    @AfterMethod()
    public void deleteAddedMailsAfterTest() {
        LOG.info("@AfterMethod method started");

        mailService.remove(mailsForRemove);
    }
}
