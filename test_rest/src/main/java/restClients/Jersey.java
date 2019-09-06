package restClients;

import java.io.IOException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.apache.http.client.ClientProtocolException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Jersey {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("https://api.hh.ru/widgets/vacancies/search?count=3&locale=RU&links_color=1560b2&border_color=1560b2&text=java&area=113&show_region=true").build());
        // getting XML data
        System.out.println(service. path("restPath").path("resourcePath").accept(MediaType.APPLICATION_JSON).get(String.class));
        // getting JSON data
        System.out.println(service. path("restPath").path("resourcePath").accept(MediaType.APPLICATION_XML).get(String.class));
    }
}