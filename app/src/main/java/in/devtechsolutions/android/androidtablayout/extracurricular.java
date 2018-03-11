package in.devtechsolutions.android.androidtablayout;

/**
 * Created by aryamirshafii on 3/9/18.
 */

public class extracurricular extends resumeItem {
    private String name;
    private String year;
    private String description;

    public extracurricular(String name, String year,String description){
        this.name = name;
        this.year = year;
        this.description = description;
    }


    public  String getName() {
        return name;
    }
    public  String getYear() {
        return year;
    }
    public String getDescription(){
        return description;
    }
}
