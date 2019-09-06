package jerseyrestclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PostXmlString {

    public static void main(String[] args) {

        Client client = Client.create();

        WebResource webResource = client.resource("http://localhost:8080/RESTfulCRUD/rest/employees");

        // Data send to web service.
        String input = "<employee>"//
                + "<empNo>E05</empNo>"//
                + "<empName>New Emp1</empName>"//
                + "<position>Manager</position>"
                + "</employee>";

        // Send XML and receive XML
        ClientResponse response = webResource.type("application/xml")//
                .accept("application/xml")//
                .post(ClientResponse.class, input);

        if (response.getStatus() != 200) {
            System.out.println("Failed : HTTP error code : " + response.getStatus());

            String error = response.getEntity(String.class);
            System.out.println("Error: " + error);
            return;
        }

        System.out.println("Output from Server .... \n");

        String output = response.getEntity(String.class);

        System.out.println(output);

    }

}
