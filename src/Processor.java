import java.util.*;

public class Processor {

    public List<String[]> fetchAllRating(List<storeApp> list){

        List<String[]> compiledList = new ArrayList<>();

        for (int i = 1; i < list.size(); i++){
            storeApp iStoreApp = list.get(i);
            String iCategory = iStoreApp.getCategory();
            String iRating = iStoreApp.getRating();

            if (iRating.equals("NaN")){
                iRating = "0.0";
            } else {
                iRating = iStoreApp.getRating();
            }

            // System.out.println(iCategory + "," + iRating);

            String[] currentItem = new String[] {iCategory, iRating};
            compiledList.add(currentItem);
        } 
        return compiledList;
    }

    public List<String[]> maxRatingByCategory(List<String[]> list){

        List<String[]> compiledList = new ArrayList<>();
        
        String currentCategory = list.get(0)[0];
        String currentRating = list.get(0)[1];
        String[] currentItem = new String[] {currentCategory, currentRating};
        compiledList.add(currentItem);

        for (int i = 0; i < list.size(); i++){            //Absolute List
            
            String iCategory = list.get(i)[0];
            String iCurrentRating = list.get(i)[1];
            Double dCurrentRating = Double.parseDouble(iCurrentRating);

            //! System.out.println("Iterating: " + iCategory + ", " + iCurrentRating);
            

            for (int j = 0; j < compiledList.size();){ //Compiled List
                // System.out.println("Iterating: " + compiledList.get(j)[0] + ", " + compiledList.get(j)[1]);
                if (!iCategory.equals(compiledList.get(j)[0])){
                    //! System.out.println(iCategory + " and " + compiledList.get(j)[0]);
                    j++;
                    //! System.out.println("Scanning for category");

                    if ( j == compiledList.size()){
                    //! System.out.println("No such category");
                    String[] add = new String[] {iCategory, iCurrentRating};
                    compiledList.add(add);
                    break;
                    }


                } else {
                    //! System.out.println("Found a commonality");
                    if (dCurrentRating > Double.parseDouble(compiledList.get(j)[1])){
                        //! System.out.println("Replacing");
                        compiledList.get(j)[1] = Double.toString(dCurrentRating);
                    }
                    break;
                }
            }
                
        }
        return compiledList;
    }

       



        

    }





        

    //     String CATEGORY = "";
    //     List<List<Double>> SORT_RATING_BY_CATEGORY = new ArrayList<>();
    //     List<Double> RATING_STORAGE = new ArrayList<>();
    //     List<String> CATEGORY_STORAGE = new ArrayList<>();
        
    //     for (int i = 1; i < list.size(); i++){
    //         if (!CATEGORY.equals(list.get(i).getCategory())){
    //             RATING_STORAGE = new ArrayList<>();
    //             SORT_RATING_BY_CATEGORY.add(RATING_STORAGE);
    //             CATEGORY = list.get(i).getCategory();
    //             CATEGORY_STORAGE.add(CATEGORY);

    //             System.out.println("Created new CATEGORY " + CATEGORY);

    //             if (list.get(i).getRating().equals("NaN")){
    //                 RATING_STORAGE.add(0.0);
    //                 System.out.println("Added NaN entry for " + i + ": " + list.get(i).getRating());
    //                 System.out.println("| Check against: " + list.get(i).toString());
    //             } else {
    //                 RATING_STORAGE.add(Double.parseDouble(list.get(i).getRating()));
    //                 System.out.println("Added entry for " + i + ": " + list.get(i).getRating());
    //                 System.out.println("| Check against: " + list.get(i).toString());
    //             }

    //         } else {
    //             if (list.get(i).getRating().equals("NaN")){
    //                 RATING_STORAGE.add(0.0);
    //                 System.out.println("I'm " + CATEGORY + " adding NaN entry for " + i + ": " + list.get(i).getRating());
    //                 System.out.println("| Check against: " + list.get(i).toString());
    //             } else {
    //                 RATING_STORAGE.add(Double.parseDouble(list.get(i).getRating()));
    //                 System.out.println("I'm " + CATEGORY + " adding entry for " + i + ": " + list.get(i).getRating());
    //                 System.out.println("| Check against: " + list.get(i).toString());
    //             }
    //         }
    //     } 
        
    //     return SORT_RATING_BY_CATEGORY;
        
    // }
