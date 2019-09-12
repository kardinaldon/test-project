import model.PriceData;
import service.ServicePriceData;
import utils.writeJsonFromDB.WriteJsonFromDB;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        ServicePriceData servicePriceData;

        //перезаписать из прайса в базу всё Apache POI
//        servicePriceData = new ServicePriceData();
//        servicePriceData.deleteAllPriceData();
//        servicePriceData.addAllProductsInPriceFromExcel();

        //создать Json из БД
//        servicePriceData = new ServicePriceData();
//        List<PriceData> priceDataList = servicePriceData.findAllProducts();
//        WriteJsonFromDB.toJSON(priceDataList);

    }
}
