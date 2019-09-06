package jerseyrestclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PostJsonString {

    public static void main(String[] args) {

        Client client = Client.create();

        WebResource webResource = client.resource("http://localhost:8080/RESTfulCRUD/rest/employees");

        // Data send to web service.
        String input = "{\"empNo\":\"E01\",\"empName\":\"New Emp1\",\"position\":\"Manager\"}";


        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

        if (response.getStatus() != 200) {
            System.out.println("Failed : HTTP error code : " + response.getStatus());

            String error= response.getEntity(String.class);
            System.out.println("Error: "+error);
            return;
        }

        System.out.println("Output from Server .... \n");

        String output = response.getEntity(String.class);

        System.out.println(output);

    }

}
