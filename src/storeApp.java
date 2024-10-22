public class storeApp {

    private String appName;
    private String category;
    private String rating;

    public storeApp(String appName, String category, String rating){
        this.appName = appName;
        this.category = category;
        this.rating = rating;
    }
    
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString(){
        return appName + ", " + category + ", " + rating;
    }

    public String[] toArray(){
        
        return new String[]{appName, category, rating};
    }

}


