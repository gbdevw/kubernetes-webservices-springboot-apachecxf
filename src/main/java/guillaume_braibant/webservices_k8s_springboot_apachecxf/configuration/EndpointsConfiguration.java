package guillaume_braibant.webservices_k8s_springboot_apachecxf.configuration;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import guillaume_braibant.webservices_k8s_springboot_apachecxf.interfaces.SayHelloInterface;

/**
 * Configure and publish webservices endpoints.
 */
@Configuration
public class EndpointsConfiguration
{
    /**
     * Configure and publish the endpoint for the webservice SayHello.
     * 
     * @param implementor Webservice logic (SayHelloServiceImpl object received through context thanks to @Service)
     * @param bus Package of beans used by Spring to process requests (recevied through IoC)
     * @return Endpoint for the webservice SayHello
     */
    @Bean
    public Endpoint publishOrderTimeDockOrgService (SayHelloInterface implementor, Bus bus)
    {
        // Create the endpoint
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);

        // By default, the base URL used by the servlet that processes requests for the webservices is /services
        // Publish the endpoint : http://<IP:PORT | FQDN(:PORT)>/services/sayhello
        endpoint.publish("/sayhello");

        return endpoint;
    }
}