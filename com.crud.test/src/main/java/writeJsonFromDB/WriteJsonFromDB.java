package writeJsonFromDB;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.PriceData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WriteJsonFromDB {
    private final static String baseFile = "../com.crud.test/src/main/resources/products.json";

    public static void toJSON(List<PriceData> priceDataList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), priceDataList);
        System.out.println("json created!");
    }
}
