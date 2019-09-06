import model.PriceData;
import readExcel.ReadExcel;
import service.ServicePriceData;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        ServicePriceData servicePriceData = new ServicePriceData();
//        PriceData priceData = new PriceData();
//        priceData.
//        servicePriceData.savePriceData(priceData);





        ReadExcel readExel = new ReadExcel();
        readExel.getProducts();
//        for (PriceData str:readExel.getProducts()) {
//            System.out.print(str.getCode()+" "+str.getName()+" "+str.getPrice());
//            System.out.println();
//        }
    }
}
