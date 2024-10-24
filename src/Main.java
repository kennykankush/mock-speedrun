import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        String fileName = args[0];

        fileManagement fileManagement = new fileManagement();
        Processor processor = new Processor();
        List<storeApp> playStore = fileManagement.csvReader(fileName);

        processor.describe(playStore);

    }
}