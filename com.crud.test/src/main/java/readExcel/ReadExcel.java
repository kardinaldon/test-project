package readExcel;

import model.PriceData;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
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

    public static final int CODE_OF_PRODUCT = 1; //код
    public static final int NAME_OF_PRODUCT = 2; //наименование
    public static final int PRICE_OF_PRODUCT = 3; //цена
    public List<PriceData> getProducts() throws IOException {
        List<PriceData> productsList = new ArrayList<PriceData>(); //Создаём пустой список

        URL url = new URL("https://www.ideal-tools.ru/files/price.xls");
        InputStream inputStream = url.openStream();
        POIFSFileSystem fileSystem =   new POIFSFileSystem(inputStream); //Открываем документ
        HSSFWorkbook workBook = new HSSFWorkbook(fileSystem); // Получаем workbook
        HSSFSheet sheet = workBook.getSheetAt(0); // Проверяем только первую страницу

        Iterator<Row> rows = sheet.rowIterator(); // Перебираем все строки

        // Пропускаем "шапку" таблицы

            if (rows.hasNext()) {
                for (int i = 0; i < 18; i++) {
                    rows.next();
                }
            }



        // Перебираем все строки начиная со второй до тех пор, пока документ не закончится
        while (rows.hasNext()==true) {
            HSSFRow row = (HSSFRow) rows.next();
            //Получаем ячейки из строки по номерам столбцов
            HSSFCell codeCell = row.getCell(CODE_OF_PRODUCT); //код
            HSSFCell nameCell = row.getCell(NAME_OF_PRODUCT); //наименование
            HSSFCell priceCell = row.getCell(PRICE_OF_PRODUCT,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK); //цена
            // Если в первом столбце нет данных, то контакт не создаём

            if (codeCell != null) {
                PriceData priceData = new PriceData();

                if (codeCell.getCellType()==NUMERIC) {

                    priceData.setCode(String.valueOf(codeCell.getNumericCellValue())); //Получаем числовое значение из ячейки
                    //priceData.setCode(""); //Адрес может не быть задан

                }

                if (codeCell.getCellType()==STRING) {

                    priceData.setCode(codeCell.getStringCellValue()); //Получаем строковое значение из ячейки
                    priceData.setCode(""); //Адрес может не быть задан

                }

                if (nameCell.getCellType()== NUMERIC) {

                    if (nameCell != null && !"".equals(nameCell.getNumericCellValue())) {
                        priceData.setName(String.valueOf(nameCell.getNumericCellValue())); //Адрес - строка
                        priceData.setName("");
                    }

                }

                if (nameCell.getCellType()==STRING) {

                    if (nameCell != null && !"".equals(nameCell.getStringCellValue())) {
                        priceData.setName(nameCell.getStringCellValue()); //Адрес - строка
                        //priceData.setName("");
                    }

                    //priceData.setName(""); //Телефон тоже может не быть задан

                }


                if ((priceCell.getCellType()==NUMERIC)&& priceCell.equals(null)) {
                        priceData.setPrice(0);

                }

                if (priceCell.getCellType()==NUMERIC && priceCell != null) {

                    if (priceCell != null && !"".equals(priceCell.getNumericCellValue())) {
                        priceData.setPrice(priceCell.getNumericCellValue()); // Телефон - тоже строка
                        //priceData.setPrice(0);
                    }

                }

                if (priceCell.getCellType()==NUMERIC && priceCell == null) {
                    priceData.setPrice(0);
                }

                if (priceCell.getCellType()==BLANK) {

                    priceData.setPrice(0);

                }

                if (priceCell.getCellType()==ERROR) {

                    priceData.setPrice(0);

                }

                if (priceCell.getCellType()==STRING) {

                    if (priceCell != null && !"".equals(priceCell.getNumericCellValue())) {
                        priceData.setPrice(Double.parseDouble(priceCell.getStringCellValue())); // Телефон - тоже строка
                        //priceData.setPrice(0);
                    }

                    //priceData.setName(""); //Телефон тоже может не быть задан

                }

                productsList.add(priceData); //Добавляем товар в список
                ServicePriceData servicePriceData = new ServicePriceData();
                servicePriceData.savePriceData(priceData);

            }
        }
        return productsList;

}}
