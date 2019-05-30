package guillaume_braibant.webservices_k8s_springboot_apachecxf.endpoints;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import guillaume_braibant.webservices_k8s_springboot_apachecxf.interfaces.SayHelloInterface;
import guillaume_braibant.webservices_k8s_springboot_apachecxf.types.FullName;

/**
 * Integration tests for the sayHello webservice
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SayHelloServiceImplIntegrationTest
{
    private static final Logger LOG = LoggerFactory.getLogger(SayHelloServiceImplIntegrationTest.class);

    @Test
    public void testSayHelloService ()
    {
        try
        {
            LOG.info("Starting test testSayHelloService");

            // Create a JAX-WS proxy to interact with the webservice
            URL url = new URL("http://localhost:8080/services/sayhello?wsdl");
            QName qname = new QName("http://webservices-k8s-springboot-apachecxf.guillaume-braibant/interfaces", "sayHelloService");
            Service service = Service.create(url, qname);
            SayHelloInterface sayHelloService = service.getPort(SayHelloInterface.class);

            // Manually set the adress
            ((BindingProvider) sayHelloService).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/services/sayhello");

            // Test parameters
            String firstName = "guillaume";
            String lastName = "braibant";
            LOG.debug("Test parameters : first name = " + firstName + ", last name = " + lastName);

            // Build the content of the request
            FullName username = new FullName();
            username.setFirstName(firstName);
            username.setLastName(lastName);

            // Test the service
            String output = sayHelloService.sayHello(username);
            LOG.debug("Response received from service : " + output);

            // Check the output
            assertTrue(output.contains(firstName));
            assertTrue(output.contains(lastName));

            LOG.info("Test testSayHelloService : Success");
        }
        catch(Exception e)
        {
            LOG.error("Test testSayHelloService has encountered an unexpected exception.", e);
            fail("Test testSayHelloService has encountered an unexpected exception.");
        }
    }
}