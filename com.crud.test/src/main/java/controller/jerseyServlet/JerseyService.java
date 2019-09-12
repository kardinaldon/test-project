package controller.jerseyServlet;

import model.PriceData;
import service.ServicePriceData;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/check")
public class JerseyService {

    private ServicePriceData servicePriceData = new ServicePriceData();
    private List<PriceData> priceDataList;
    private PriceData priceData;

    //получить все товары http://localhost:8080/com_crud_test_1_0_SNAPSHOT_war/rest/check/all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PriceData> getAllProducts() {
        priceDataList = servicePriceData.findAllProducts();
        System.out.println("RESTful Service running /all");
        return priceDataList;
    }

    //получить товар по id
    // http://localhost:8080/com_crud_test_1_0_SNAPSHOT_war/rest/check/getbyid?id=1   - получить товар с id 1
    @GET
    @Path("/getbyid")
    @Produces(MediaType.APPLICATION_JSON)
    public PriceData getProductById(@QueryParam("id") int id) {
        priceData = servicePriceData.findPriceDataFromId(id);
        System.out.println("RESTful Service running /getbyid: "+id);
        return priceData;
    }

    //создать новый товар http://localhost:8080/com_crud_test_1_0_SNAPSHOT_war/rest/check/newproduct
    @POST
    @Path("/newproduct")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PriceData createNewProduct (PriceData priceData) {
        servicePriceData.savePriceData(priceData);
        System.out.println("RESTful Service running /newproduct "+priceData.getId()+" "+priceData.getCode()+" "+priceData.getName()+" "+priceData.getPrice());
        return priceData;
    }

    //создать новые товары http://localhost:8080/com_crud_test_1_0_SNAPSHOT_war/rest/check/allnewproducts
    @POST
    @Path("/allnewproducts")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createNewProducts (List<PriceData> priceDataList) throws IOException {
        servicePriceData.addAllProductsInPriceFromRestJson(priceDataList);
        System.out.println("RESTful Service running /allnewproducts");
        return "all products created";
    }

}
