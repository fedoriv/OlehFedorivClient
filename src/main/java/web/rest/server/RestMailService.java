package web.rest.server;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import web.soap.server.Mail;
import web.soap.server.MailService;

import java.io.IOException;
import java.util.List;

public class RestMailService implements MailService {

    private static Logger LOG = LogManager.getLogger(RestMailService.class);

    public static final String BASE_ADDRESS = "http://localhost:8080/OlehFedorivService/RESTService";

    private ClientConfig clientConfig;
    private Client client;

    public RestMailService() {
        clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        clientConfig = new DefaultClientConfig();
        client = Client.create(clientConfig);
    }

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
        ObjectMapper mapper = new ObjectMapper();

        String uri = BASE_ADDRESS + "/mails";
        LOG.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        ClientResponse response = webResource.accept("application/json;encoding=UTF-8")
                .get(ClientResponse.class);

        String mailsJson = response.getEntity(String.class);
        List<Mail> list = null;

        try {
            list = mapper.readValue(mailsJson, new TypeReference<List<Mail>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }


    public boolean clearMails() {
        return false;
    }
}
