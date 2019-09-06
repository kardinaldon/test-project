package jerseyrestclient;

import javax.ws.rs.core.MediaType;

import model.Employee;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class GetJsonAsObject {

    public static void main(String[] args) {

        ClientConfig clientConfig = new DefaultClientConfig();

        // Create Client based on Config
        Client client = Client.create(clientConfig);

        WebResource webResource = client.resource("http://localhost:8080/RESTfulCRUD/rest/employees/E01");

        Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
                .header("content-type", MediaType.APPLICATION_JSON);

        ClientResponse response = builder.get(ClientResponse.class);

        // Status 200 is successful.
        if (response.getStatus() != 200) {
            System.out.println("Failed with HTTP Error code: " + response.getStatus());
            String error= response.getEntity(String.class);
            System.out.println("Error: "+error);
            return;
        }

        System.out.println("Output from Server .... \n");

        Employee employee = (Employee) response.getEntity(Employee.class);

        System.out.println("Emp No .... " + employee.getEmpNo());
        System.out.println("Emp Name .... " + employee.getEmpName());
        System.out.println("Position .... " + employee.getPosition());

    }

}
