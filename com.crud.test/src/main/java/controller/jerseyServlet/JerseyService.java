package controller.jerseyServlet;



import model.PriceData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/check")
public class JerseyService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String checkData (List<PriceData> priceDataList) {
        System.out.println("RESTful Service running Test");
        return "Test";
    }
}
