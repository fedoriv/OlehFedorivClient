
package web.soap.server;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MailService", targetNamespace = "http://server.soap.web/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MailService {


    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "remove", targetNamespace = "http://server.soap.web/", className = "web.soap.server.Remove")
    @ResponseWrapper(localName = "removeResponse", targetNamespace = "http://server.soap.web/", className = "web.soap.server.RemoveResponse")
    public boolean remove(
        @WebParam(name = "arg0", targetNamespace = "")
        List<Mail> arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "send", targetNamespace = "http://server.soap.web/", className = "web.soap.server.Send")
    @ResponseWrapper(localName = "sendResponse", targetNamespace = "http://server.soap.web/", className = "web.soap.server.SendResponse")
    public boolean send(
        @WebParam(name = "arg0", targetNamespace = "")
        Mail arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<web.soap.server.Mail>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findByEmail", targetNamespace = "http://server.soap.web/", className = "web.soap.server.FindByEmail")
    @ResponseWrapper(localName = "findByEmailResponse", targetNamespace = "http://server.soap.web/", className = "web.soap.server.FindByEmailResponse")
    public List<Mail> findByEmail(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<web.soap.server.Mail>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findByTitle", targetNamespace = "http://server.soap.web/", className = "web.soap.server.FindByTitle")
    @ResponseWrapper(localName = "findByTitleResponse", targetNamespace = "http://server.soap.web/", className = "web.soap.server.FindByTitleResponse")
    public List<Mail> findByTitle(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns web.soap.server.Mail
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findById", targetNamespace = "http://server.soap.web/", className = "web.soap.server.FindById")
    @ResponseWrapper(localName = "findByIdResponse", targetNamespace = "http://server.soap.web/", className = "web.soap.server.FindByIdResponse")
    public Mail findById(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws ServiceException
    ;

    /**
     * 
     * @return
     *     returns java.util.List<web.soap.server.Mail>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAll", targetNamespace = "http://server.soap.web/", className = "web.soap.server.GetAll")
    @ResponseWrapper(localName = "getAllResponse", targetNamespace = "http://server.soap.web/", className = "web.soap.server.GetAllResponse")
    public List<Mail> getAll();

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "removeAll", targetNamespace = "http://server.soap.web/", className = "web.soap.server.RemoveAll")
    @ResponseWrapper(localName = "removeAllResponse", targetNamespace = "http://server.soap.web/", className = "web.soap.server.RemoveAllResponse")
    public void removeAll();

}
