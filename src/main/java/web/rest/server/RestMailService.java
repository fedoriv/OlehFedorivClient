package web.rest.server;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import web.soap.server.Mail;
import web.soap.server.MailServiceFault;
import web.soap.server.ServiceException;

import java.io.IOException;
import java.util.List;

public class RestMailService{

    public static final String BASE_ADDRESS = "http://localhost:8080/OlehFedorivService/RESTService";
    private static Logger LOG = LogManager.getLogger(RestMailService.class);
    private ClientConfig clientConfig;
    private Client client;
    private ClientResponse response;

    public RestMailService() {
        clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        clientConfig = new DefaultClientConfig();
        client = Client.create(clientConfig);
    }

    public boolean send(Mail mail) throws ServiceException {
        LOG.info("RESTS request. Send mail\n" + mail.toString());

        ObjectMapper mapper = new ObjectMapper();
        String uri = BASE_ADDRESS + "/mail";
        LOG.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        try {
            response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                    .post(ClientResponse.class, mapper.writeValueAsString(mail));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response.getStatus() != 200) {
            throw buildException(response, mapper);
        }
        return true;

    }


    public List<Mail> findByEmail(String email) throws ServiceException {
        LOG.info("RESTS request. Find mails by email");

        ObjectMapper mapper = new ObjectMapper();
        String uri = BASE_ADDRESS + "/mails/byEmail/" + email.replace(" ", "%20");
        LOG.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                .get(ClientResponse.class);

        List<Mail> list = null;
        if (response.getStatus() != 200) {
            throw buildException(response, mapper);
        } else {
            String jsonBooks = response.getEntity(String.class);

            try {
                list = mapper.readValue(jsonBooks, new TypeReference<List<Mail>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return list;
    }


    public List<Mail> findByTitle(String title) throws ServiceException {
        LOG.info("RESTS request. Find mails by title");

        ObjectMapper mapper = new ObjectMapper();
        String uri = BASE_ADDRESS + "/mails/byTitle/" + title.replace(" ", "%20");
        LOG.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                .get(ClientResponse.class);

        List<Mail> list = null;
        if (response.getStatus() != 200) {
            throw buildException(response, mapper);
        } else {
            String jsonBooks = response.getEntity(String.class);

            try {
                list = mapper.readValue(jsonBooks, new TypeReference<List<Mail>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return list;
    }


    public Mail findById(String id) throws ServiceException {
        LOG.info("RESTS request. Find mails by id");

        ObjectMapper mapper = new ObjectMapper();
        String uri = BASE_ADDRESS + "/mails/byId/" + id.replace(" ", "%20");
        LOG.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                .get(ClientResponse.class);

        Mail mail = null;
        if (response.getStatus() != 200) {
            throw buildException(response, mapper);
        } else {
            String jsonBooks = response.getEntity(String.class);

            try {
                mail = mapper.readValue(jsonBooks, Mail.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return mail;
    }


    public List<Mail> getAll() throws ServiceException {
        LOG.info("RESTS request. Get all mails from server");
        ObjectMapper mapper = new ObjectMapper();

        String uri = BASE_ADDRESS + "/mails";
        LOG.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        response = webResource.accept("application/json;encoding=UTF-8")
                .get(ClientResponse.class);

        String mailsJson = response.getEntity(String.class);
        List<Mail> list = null;

        if (response.getStatus() != 200) {
            throw buildException(response, mapper);
        }
        try {
            list = mapper.readValue(mailsJson, new TypeReference<List<Mail>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }


    public boolean remove(List<Mail> mails) throws ServiceException {
        LOG.info("RESTS request. Remove given mail(s) from server");

        ObjectMapper mapper = new ObjectMapper();

        String uri = BASE_ADDRESS + "/mails/remove";
        LOG.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        try {
            response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                    .delete(ClientResponse.class, mapper.writeValueAsString(mails));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response.getStatus() != 200) {
            throw buildException(response, mapper);
        }
        return true;
    }

    public boolean clearMails() throws ServiceException {
        LOG.info("RESTS request. Remove all mails from server");

        ObjectMapper mapper = new ObjectMapper();

        String uri = BASE_ADDRESS + "/mails/removeAll";
        LOG.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                .delete(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw buildException(response, mapper);
        }
        return true;
    }

    private ServiceException buildException(ClientResponse response, ObjectMapper mapper) throws ServiceException {

        String jsonFaultInfo = response.getEntity(String.class);

        MailServiceFault faultInfo = null;
        try {
            faultInfo = mapper.readValue(jsonFaultInfo, MailServiceFault.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ServiceException(faultInfo);

    }
}
