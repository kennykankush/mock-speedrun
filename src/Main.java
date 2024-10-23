import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        fileManagement fileManagement = new fileManagement();
        Processor processor = new Processor();

        List<storeApp> playStore = fileManagement.csvReader("googleplaystore.csv");
        // System.out.println(playStore);

        // fileManagement.head(playStore, "head", 200);

        // List<storeApp> trim = fileManagement.trim(playStore, 100);
        List<String[]> all = processor.fetchAllRating(playStore);
        List<String[]> max = processor.maxRatingByCategory(all);

        System.out.println(Arrays.deepToString(max.toArray()));

        // System.out.println(Arrays.deepToString(processor.fetcherHighestRatingEachCategory(trim).toArray()));

        // System.out.println(Arrays.deepToString(highest.toArray())); //https://stackoverflow.com/questions/49387653/simple-way-to-print-liststring-java


        

    }
}