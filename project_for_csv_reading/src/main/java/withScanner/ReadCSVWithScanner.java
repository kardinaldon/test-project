package withScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadCSVWithScanner {

    public static void main(String[] args) {

        File file = new File("/home/cardinal/ext-test-project/project_for_csv_reading/src/main/resources/997.csv");
        List<String> strings = new ArrayList<String>();
        Scanner sc;

        try {

            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                strings.add(line);

                //вывести всё
                //System.out.println(line);

                //вывести строку содержащую что то определенное
                if (line.contains("836990")) {
                    System.out.println(line);
                } else {
                    System.out.println("not found");
                }
            }

            sc.close();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}