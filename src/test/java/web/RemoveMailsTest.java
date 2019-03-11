package web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
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

public class RemoveMailsTest {

    private static Logger LOG = LogManager.getLogger(RemoveMailsTest.class);

    private MailService mailService;
    private RestMailService restMailService;
    private List<Mail> mailsForRemove;
    private int count = 0;

    @BeforeTest
    public void beforeTest() {
        LOG.info("@BeforeTest method started");
        mailService = new MailServiceImplService().getMailServiceImplPort();
        restMailService = new RestMailService();
    }

    @Test
    public void removeMailsSOAPTest() {
        LOG.info("Test method removeMailsSOAPTest() started");
        List<Mail> allMails = mailService.getAll();
        if (allMails.containsAll(mailsForRemove)) {
            mailService.remove(mailsForRemove);
        } else {
            Assert.fail();
        }
        allMails = mailService.getAll();
        if (!allMails.containsAll(mailsForRemove) && allMails.size() != count) {
            Assert.fail();
        }

    }

    @Test
    public void removeMailsRESTTest() {
        LOG.info("Test method removeMailsRESTTest() started");
        try {
            List<Mail> allMails = restMailService.getAll();

            if (allMails.containsAll(mailsForRemove)) {
                restMailService.remove(mailsForRemove);
            } else {
                Assert.fail();
            }
            allMails = restMailService.getAll();
            if (!allMails.containsAll(mailsForRemove) && allMails.size() != count) {
                Assert.fail();
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void fill() {
        LOG.info("@BeforeMethod method started");

        count = mailService.getAll().size();
        mailsForRemove = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Mail mail = new Mail("forRemove0" + i + "@test.com", "Title to remove " + i, "Random text in mail " + i);
            mailService.send(mail);
            mailsForRemove.add(mail);
        }
        Assert.assertEquals(count + 5, mailService.getAll().size());
    }

}
