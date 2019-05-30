package guillaume_braibant.webservices_k8s_springboot_apachecxf.interfaces;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.7
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "sayHelloService",
                  wsdlLocation = "file:/C:/Users/BraibantGuillaume/Desktop/Dev/Projets/kubernetes-webservices-springboot-apachecxf/src/main/resources/services.wsdl",
                  targetNamespace = "http://webservices-k8s-springboot-apachecxf.guillaume-braibant/interfaces")
public class SayHelloService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://webservices-k8s-springboot-apachecxf.guillaume-braibant/interfaces", "sayHelloService");
    public final static QName SayHelloInterface = new QName("http://webservices-k8s-springboot-apachecxf.guillaume-braibant/interfaces", "sayHelloInterface");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/BraibantGuillaume/Desktop/Dev/Projets/kubernetes-webservices-springboot-apachecxf/src/main/resources/services.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(SayHelloService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/BraibantGuillaume/Desktop/Dev/Projets/kubernetes-webservices-springboot-apachecxf/src/main/resources/services.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public SayHelloService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SayHelloService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SayHelloService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public SayHelloService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public SayHelloService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public SayHelloService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns SayHelloInterface
     */
    @WebEndpoint(name = "sayHelloInterface")
    public SayHelloInterface getSayHelloInterface() {
        return super.getPort(SayHelloInterface, SayHelloInterface.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SayHelloInterface
     */
    @WebEndpoint(name = "sayHelloInterface")
    public SayHelloInterface getSayHelloInterface(WebServiceFeature... features) {
        return super.getPort(SayHelloInterface, SayHelloInterface.class, features);
    }

}
