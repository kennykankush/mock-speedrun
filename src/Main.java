import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        fileManagement fileManagement = new fileManagement();

        List<storeApp> playStore = fileManagement.csvReader("googleplaystore28");

        fileManagement.head(playStore, "head", 10);
    }
}