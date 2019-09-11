package utils.readExcel;

import model.PriceData;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import service.ServicePriceData;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.*;

public class ReadExcel {

    private static final int CODE_OF_PRODUCT = 1; //код
    private static final int NAME_OF_PRODUCT = 2; //наименование
    private static final int PRICE_OF_PRODUCT = 3; //цена
    private ServicePriceData servicePriceData = new ServicePriceData();
    private PriceData priceData;

    public List<PriceData> getProducts() throws IOException {
        List<PriceData> productsList = new ArrayList(); //Создаём пустой список

        URL url = new URL("https://www.ideal-tools.ru/files/price.xls");
        InputStream inputStream = url.openStream();
        POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream); //Открываем документ
        HSSFWorkbook workBook = new HSSFWorkbook(fileSystem); // Получаем workbook
        HSSFSheet sheet = workBook.getSheetAt(0); // Проверяем только первую страницу

        Iterator<Row> rows = sheet.rowIterator(); // Перебираем все строки

        // Пропускаем "шапку" таблицы, первые 18 строк

        if (rows.hasNext()) {
            for (int i = 0; i < 18; i++) {
                rows.next();
            }
        }

        // Перебираем все строки начиная со второй до тех пор, пока документ не закончится
        while (rows.hasNext() == true) {
            HSSFRow row = (HSSFRow) rows.next();
            //Получаем ячейки из строки по номерам столбцов
            HSSFCell codeCell = row.getCell(CODE_OF_PRODUCT); //код
            HSSFCell nameCell = row.getCell(NAME_OF_PRODUCT, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK); //наименование
            HSSFCell priceCell = row.getCell(PRICE_OF_PRODUCT, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK); //цена

            // Если в первом столбце нет данных, то товар не создаём
            if (codeCell != null) {
                priceData = new PriceData();

                //код товара
                if (codeCell.getCellType() == NUMERIC) {
                    priceData.setCode(String.valueOf(codeCell.getNumericCellValue())); //Получаем числовое значение из ячейки
                }

                if (codeCell.getCellType() == STRING) {
                    priceData.setCode(codeCell.getStringCellValue());

                }

                //Наименование
                if (nameCell.getCellType() == NUMERIC) {
                    priceData.setName(String.valueOf(nameCell.getNumericCellValue()));
                } else if (nameCell.getCellType() == STRING) {
                    priceData.setName(nameCell.getStringCellValue());

                } else if (nameCell.getCellType() == BLANK) {
                    priceData.setName("BLANK");

                } else if (nameCell.getCellType() == ERROR) {
                    priceData.setName("ERROR");
                }

                //Цена
                if (priceCell.getCellType() == NUMERIC) {
                    priceData.setPrice(priceCell.getNumericCellValue());

                } else if (priceCell.getCellType() == STRING) {
                    priceData.setPrice(Double.parseDouble(priceCell.getStringCellValue()));
                } else if (priceCell.getCellType() == BLANK) {
                    priceData.setPrice(0);

                } else if (priceCell.getCellType() == ERROR) {
                    priceData.setPrice(0);
                }


                productsList.add(priceData); //Добавляем товар в список
                servicePriceData.savePriceData(priceData);
            }
        }
        return productsList;
    }
}
