package withBufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVWithBufferedReader {

    public static List<String[]> readFromCsvFile(String separator, String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            List<String[]> list = new ArrayList<>();
            String line = "";
            while((line = reader.readLine()) != null){
                String[] array = line.split(separator);
                list.add(array);
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i]+" ");
                }
                System.out.println();
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        readFromCsvFile(";","/home/cardinal/ext-test-project/project_for_csv_reading/src/main/resources/997.csv");
    }
}
