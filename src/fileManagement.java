import java.io.*;
import java.util.*;


public class fileManagement {

    public void head(List<storeApp> list, String configuration, Integer row){

        int size = list.size();

        // for (int i = 1; i < row + 1; i++){
        // System.out.println(Arrays.toString(list.get(i).toArray()));
        // }
        switch(configuration){
            case "head":
                for (int i = 1; i < row + 1; i++){
                System.out.print(i + " | ");
                System.out.println(Arrays.toString(list.get(i).toArray()));
                }
                break;

            case "tail":
                int START_AT = size - row;
            
                for (int i = START_AT; i < size; i++){
                    System.out.print(i + " | ");
                    System.out.println(Arrays.toString(list.get(i).toArray()));
                }
                break;

            default:
                for (int i = 1; i < 11; i++){
                    System.out.println(Arrays.toString(list.get(i).toArray()));
                }
                break;

        }
    }

    public List<storeApp> trim(List<storeApp> list, Integer row){

        List<storeApp> trimmedList = new ArrayList<>();

        for (int i = 0; i <= row; i++){
            trimmedList.add(list.get(i));
        }

        return trimmedList;

    }

    public List<storeApp> csvReader(String fileName) throws FileNotFoundException, IOException{

            // Directory Handling

            String directory = ".\\data\\";
            String extension = ".csv";

            //Check to see if the extension is embedded.

            if (!fileName.contains(".csv")){
                // System.out.println("Argument does not have an extension");
                String[] disintegrator = fileName.split("\\.");             //https://coderanch.com/t/771194/java/string-split-method-work
                fileName = disintegrator[0] + extension;
            } else {
                // System.out.println("Argument has a .csv extension");
            }

            // File instance have to be declared for anything file related. ***

            File file = new File(directory + fileName);

            
            // A good check to see if file exist in the folder

            if (file.exists()){
                System.out.println(file.toString() + " found!");
            } else {
                System.out.println(file.toString() + " does not exist");
            }

            //Setup a catcher and a container
            String line = "";
            List<storeApp> database = new ArrayList<>();
            

            //Hire a File Reader and set him to slow mode
            // try { 
            BufferedReader br = new BufferedReader(new FileReader(file));
    
            //Catcher machine, process and put in container

            while ((line = br.readLine()) != null){
                // System.out.println(line);
                String[] lineData = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); //!https://stackoverflow.com/questions/15738918/splitting-a-csv-file-with-quotes-as-text-delimiter-using-string-split

                storeApp create = new storeApp(lineData[0], lineData[1], lineData[2]);
                database.add(create);

            }
 
            // } catch (FileNotFoundException e){
            //     e.printStackTrace();
            //     // System.out.println("File not found!");
            // } catch (IOException e){
            //     e.printStackTrace();
            //     // System.out.println("Something's wrong!");

            // }

            return database;
        
    }

    public void csvWriter(){

    }
}
