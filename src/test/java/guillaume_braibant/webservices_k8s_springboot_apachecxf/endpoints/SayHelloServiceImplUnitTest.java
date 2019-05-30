package guillaume_braibant.webservices_k8s_springboot_apachecxf.endpoints;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import guillaume_braibant.webservices_k8s_springboot_apachecxf.types.FullName;

/**
 * Unit tests for the SayHelloServiceImpl class.
 */
public class SayHelloServiceImplUnitTest
{
    private static final Logger LOG = LoggerFactory.getLogger(SayHelloServiceImplUnitTest.class);

    @Test
    public void testSayHello ()
    {
        LOG.info("Starting test : testSayHello");

        // Test parameters
        String firstName = "guillaume";
        String lastName = "braibant";
        LOG.debug("Test parameters : first name = " + firstName + ", last name = " + lastName);

        // Build the content of the request
        FullName username = new FullName();
        username.setFirstName(firstName);
        username.setLastName(lastName);

        // Build the service
        SayHelloServiceImpl service = new SayHelloServiceImpl();

        // Test the method
        String output = service.sayHello(username);
        LOG.debug("Response received from service : " + output);

        // Check the output
        assertTrue(output.contains(firstName));
        assertTrue(output.contains(lastName));

        LOG.info("Test testSayHello : Success");
    }
}