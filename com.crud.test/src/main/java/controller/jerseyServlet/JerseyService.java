package controller.jerseyServlet;

import model.PriceData;
import service.ServicePriceData;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/check")
public class JerseyService {

    ServicePriceData servicePriceData = new ServicePriceData();
    List<PriceData> priceDataList = servicePriceData.findAllProducts();

    //получить все товары http://localhost:8080/com_crud_test_1_0_SNAPSHOT_war/rest/check/all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PriceData> checkData() {
        System.out.println("RESTful Service running Test");
        return priceDataList;
    }

    //создать новый товар http://localhost:8080/com_crud_test_1_0_SNAPSHOT_war/rest/check/newproduct
    @POST
    @Path("/newproduct")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PriceData createNewProduct (PriceData priceData) {
        servicePriceData.savePriceData(priceData);
        return priceData;
    }

}
