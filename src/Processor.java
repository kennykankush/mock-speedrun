import java.util.*;

public class Processor {

    public List<String[]> fetchAllRating(List<storeApp> list){

        List<String[]> compiledList = new ArrayList<>();

        for (int i = 1; i < list.size(); i++){
            storeApp iStoreApp = list.get(i);
            String iCategory = iStoreApp.getCategory();
            String iRating = iStoreApp.getRating();

            if (iRating.equals("NaN")){                
                iRating = "-1.0";
            } else {
                iRating = iStoreApp.getRating();
            }

            // System.out.println(iCategory + "," + iRating);

            String[] currentItem = new String[] {iCategory, iRating};
            compiledList.add(currentItem);
        } 
        return compiledList;
    }
    
    //! Are you serious right neow?
    public List<String[]> maxRatingByCategoryDEPRECATED(List<String[]> list){

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

    public Map<String,Double> maxRatingByCategory(List<String[]> list){

        Map<String,Double> map = new LinkedHashMap<>();
        
        for (int i = 0; i < list.size(); i++){
            map.merge(list.get(i)[0],Double.parseDouble(list.get(i)[1]), Double::max);
        }
        
        return map;
    }
    
    //! Are you serious right neow?
    public List<String[]> minRatingByCategoryDEPRECATED(List<String[]> list){

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
                    if (dCurrentRating < Double.parseDouble(compiledList.get(j)[1]) && (dCurrentRating > 0.0)){
                        //! System.out.println("Replacing");
                        compiledList.get(j)[1] = Double.toString(dCurrentRating);
                    }
                    break;
                }
            }
                
        }
        return compiledList;
    }
    
    public Map<String,Double> minRatingByCategory(List<String[]> list){

        Map<String,Double> map = new LinkedHashMap<>();
        
        for (int i = 0; i < list.size(); i++){
            if(Double.parseDouble(list.get(i)[1]) > 0){
            map.merge(list.get(i)[0],Double.parseDouble(list.get(i)[1]), Double::min);
            }
        
        }

        return map;
    }
    
    public Map<String,Integer> countAllByCategory(List<String[]> list){     //ABSOLUTETOTAL NULLS ALL INCLUDED

        Map<String,Integer> map = new LinkedHashMap<>();
        
        for (int i = 0; i < list.size(); i++){
            map.merge(list.get(i)[0],1, Integer::sum);
        }
        
        return map;
    }

    public Map<String,Integer> countSomeByCategory(List<String[]> list){     //VALID TOTAL NO NULLS

        Map<String,Integer> map = new LinkedHashMap<>();
        
        for (int i = 0; i < list.size(); i++){
            if (Double.parseDouble(list.get(i)[1]) > 0.0){
                map.merge(list.get(i)[0],1, Integer::sum);
            }
        }
        
        return map;
    }

    public Map<String,Double> avgRatingByCategory(List<String[]> list){

        Map<String,Double> sum = new LinkedHashMap<>();

        for (int i = 0; i < list.size();i++){
            String iCategory = list.get(i)[0];
            if(Double.parseDouble(list.get(i)[1]) > 0.0){
                sum.merge(iCategory, Double.parseDouble(list.get(i)[1]),Double::sum);

            }
        }

        Map<String,Integer> count = countSomeByCategory(list);

        Map<String,Double> average = new LinkedHashMap<>();

        for (int i = 0; i < list.size();i++){
            Double iSum = sum.get(list.get(i)[0]);
            Double iCount = (double) count.get(list.get(i)[0]);

            Double avgValue = iSum / iCount;

            if(Double.parseDouble(list.get(i)[1]) > 0.0){
                average.put(list.get(i)[0], avgValue);

            }
        }

        return average;
    }

    public Map<String,Integer> countNaNByCategory(List<String[]> list){
        Map<String,Integer> map = new LinkedHashMap<>();
        
        for (int i = 0; i < list.size(); i++){
            if (Double.parseDouble(list.get(i)[1]) < 0.0){
                map.merge(list.get(i)[0],1, Integer::sum);
            }
         }
        
        return map;
    }

    public List<String> getCategory(List<String[]> list){
        List<String> getCategory = new ArrayList<>();
        getCategory.add(list.get(0)[0]);
        for (int i = 0; i < list.size(); i++){
            // System.out.println("Accessing" + list.get(i)[0]);
            for (int j = 0; j < getCategory.size();){
                if (!getCategory.get(j).equals(list.get(i)[0])){
                    j++;
                    // System.out.println("Scanning");

                    if(j == getCategory.size()){
                        getCategory.add(list.get(i)[0]);
                        break;
                    }
                    
            } else {
                // System.out.println("Exist!");
                break;
            }

            }
            
        }
        return getCategory;
        
    }
    
    public void describe(List<storeApp> list){
        List<String[]> All = fetchAllRating(list);
        List<String> cat = getCategory(All);
        Map<String,Double> max = maxRatingByCategory(All);
        Map<String,Double> min = minRatingByCategory(All);
        Map<String,Double> avg = avgRatingByCategory(All);
        Map<String,Integer> countAll = countAllByCategory(All);
        Map<String,Integer> countNaN = countNaNByCategory(All);

        for (int i = 0; i < cat.size(); i++){

            String currentCategory = cat.get(i);

            System.out.println("CATEGORY: " + cat.get(i));
            System.out.println("    THE HIGHEST: " + String.format("%.2f", max.get(currentCategory)));
            System.out.println("    THE LOWEST: " + String.format("%.2f", min.get(currentCategory)));
            System.out.println("    THE AVERAGE: " + String.format("%.2f",avg.get(currentCategory)));
            System.out.println("    THE COUNT: " + countAll.get(currentCategory));
            System.out.println("    THE DISCARD: " + countNaN.get(currentCategory));


        }


        
        


        
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
