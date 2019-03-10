
package web.soap.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the web.soap.server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindByEmailResponse_QNAME = new QName("http://server.soap.web/", "findByEmailResponse");
    private final static QName _Remove_QNAME = new QName("http://server.soap.web/", "remove");
    private final static QName _FindByTitle_QNAME = new QName("http://server.soap.web/", "findByTitle");
    private final static QName _SendResponse_QNAME = new QName("http://server.soap.web/", "sendResponse");
    private final static QName _ClearMailsResponse_QNAME = new QName("http://server.soap.web/", "clearMailsResponse");
    private final static QName _RemoveResponse_QNAME = new QName("http://server.soap.web/", "removeResponse");
    private final static QName _GetAllResponse_QNAME = new QName("http://server.soap.web/", "getAllResponse");
    private final static QName _ClearMails_QNAME = new QName("http://server.soap.web/", "clearMails");
    private final static QName _GetAll_QNAME = new QName("http://server.soap.web/", "getAll");
    private final static QName _MailServiceFault_QNAME = new QName("http://server.soap.web/", "MailServiceFault");
    private final static QName _Send_QNAME = new QName("http://server.soap.web/", "send");
    private final static QName _FindByEmail_QNAME = new QName("http://server.soap.web/", "findByEmail");
    private final static QName _FindById_QNAME = new QName("http://server.soap.web/", "findById");
    private final static QName _FindByIdResponse_QNAME = new QName("http://server.soap.web/", "findByIdResponse");
    private final static QName _FindByTitleResponse_QNAME = new QName("http://server.soap.web/", "findByTitleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: web.soap.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAll }
     * 
     */
    public GetAll createGetAll() {
        return new GetAll();
    }

    /**
     * Create an instance of {@link ClearMails }
     * 
     */
    public ClearMails createClearMails() {
        return new ClearMails();
    }

    /**
     * Create an instance of {@link GetAllResponse }
     * 
     */
    public GetAllResponse createGetAllResponse() {
        return new GetAllResponse();
    }

    /**
     * Create an instance of {@link ClearMailsResponse }
     * 
     */
    public ClearMailsResponse createClearMailsResponse() {
        return new ClearMailsResponse();
    }

    /**
     * Create an instance of {@link RemoveResponse }
     * 
     */
    public RemoveResponse createRemoveResponse() {
        return new RemoveResponse();
    }

    /**
     * Create an instance of {@link FindByTitle }
     * 
     */
    public FindByTitle createFindByTitle() {
        return new FindByTitle();
    }

    /**
     * Create an instance of {@link SendResponse }
     * 
     */
    public SendResponse createSendResponse() {
        return new SendResponse();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public Remove createRemove() {
        return new Remove();
    }

    /**
     * Create an instance of {@link FindByEmailResponse }
     * 
     */
    public FindByEmailResponse createFindByEmailResponse() {
        return new FindByEmailResponse();
    }

    /**
     * Create an instance of {@link FindByTitleResponse }
     * 
     */
    public FindByTitleResponse createFindByTitleResponse() {
        return new FindByTitleResponse();
    }

    /**
     * Create an instance of {@link FindById }
     * 
     */
    public FindById createFindById() {
        return new FindById();
    }

    /**
     * Create an instance of {@link FindByIdResponse }
     * 
     */
    public FindByIdResponse createFindByIdResponse() {
        return new FindByIdResponse();
    }

    /**
     * Create an instance of {@link FindByEmail }
     * 
     */
    public FindByEmail createFindByEmail() {
        return new FindByEmail();
    }

    /**
     * Create an instance of {@link Send }
     * 
     */
    public Send createSend() {
        return new Send();
    }

    /**
     * Create an instance of {@link MailServiceFault }
     * 
     */
    public MailServiceFault createMailServiceFault() {
        return new MailServiceFault();
    }

    /**
     * Create an instance of {@link ServiceFaultInfo }
     * 
     */
    public ServiceFaultInfo createServiceFaultInfo() {
        return new ServiceFaultInfo();
    }

    /**
     * Create an instance of {@link Mail }
     * 
     */
    public Mail createMail() {
        return new Mail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "findByEmailResponse")
    public JAXBElement<FindByEmailResponse> createFindByEmailResponse(FindByEmailResponse value) {
        return new JAXBElement<FindByEmailResponse>(_FindByEmailResponse_QNAME, FindByEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Remove }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "remove")
    public JAXBElement<Remove> createRemove(Remove value) {
        return new JAXBElement<Remove>(_Remove_QNAME, Remove.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "findByTitle")
    public JAXBElement<FindByTitle> createFindByTitle(FindByTitle value) {
        return new JAXBElement<FindByTitle>(_FindByTitle_QNAME, FindByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "sendResponse")
    public JAXBElement<SendResponse> createSendResponse(SendResponse value) {
        return new JAXBElement<SendResponse>(_SendResponse_QNAME, SendResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearMailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "clearMailsResponse")
    public JAXBElement<ClearMailsResponse> createClearMailsResponse(ClearMailsResponse value) {
        return new JAXBElement<ClearMailsResponse>(_ClearMailsResponse_QNAME, ClearMailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "removeResponse")
    public JAXBElement<RemoveResponse> createRemoveResponse(RemoveResponse value) {
        return new JAXBElement<RemoveResponse>(_RemoveResponse_QNAME, RemoveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "getAllResponse")
    public JAXBElement<GetAllResponse> createGetAllResponse(GetAllResponse value) {
        return new JAXBElement<GetAllResponse>(_GetAllResponse_QNAME, GetAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearMails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "clearMails")
    public JAXBElement<ClearMails> createClearMails(ClearMails value) {
        return new JAXBElement<ClearMails>(_ClearMails_QNAME, ClearMails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "getAll")
    public JAXBElement<GetAll> createGetAll(GetAll value) {
        return new JAXBElement<GetAll>(_GetAll_QNAME, GetAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MailServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "MailServiceFault")
    public JAXBElement<MailServiceFault> createMailServiceFault(MailServiceFault value) {
        return new JAXBElement<MailServiceFault>(_MailServiceFault_QNAME, MailServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Send }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "send")
    public JAXBElement<Send> createSend(Send value) {
        return new JAXBElement<Send>(_Send_QNAME, Send.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "findByEmail")
    public JAXBElement<FindByEmail> createFindByEmail(FindByEmail value) {
        return new JAXBElement<FindByEmail>(_FindByEmail_QNAME, FindByEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "findById")
    public JAXBElement<FindById> createFindById(FindById value) {
        return new JAXBElement<FindById>(_FindById_QNAME, FindById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.web/", name = "findByTitleResponse")
    public JAXBElement<FindByTitleResponse> createFindByTitleResponse(FindByTitleResponse value) {
        return new JAXBElement<FindByTitleResponse>(_FindByTitleResponse_QNAME, FindByTitleResponse.class, null, value);
    }

}
