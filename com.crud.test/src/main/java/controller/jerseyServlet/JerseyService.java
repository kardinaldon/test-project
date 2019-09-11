package controller.jerseyServlet;



import model.PriceData;
import service.ServicePriceData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/check")
public class JerseyService {

    ServicePriceData servicePriceData=new ServicePriceData();
    List<PriceData> priceDataList = servicePriceData.findAllProducts();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PriceData> checkData () {


        System.out.println("RESTful Service running Test");
        return priceDataList;
    }


}
