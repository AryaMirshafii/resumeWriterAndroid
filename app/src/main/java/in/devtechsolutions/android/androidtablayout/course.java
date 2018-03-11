package in.devtechsolutions.android.androidtablayout;

/**
 * Created by aryamirshafii on 3/9/18.
 */

public class course extends resumeItem {
    private String name;
    private String description;
    public course(String name,String description){
        this.name = name;
        this.description = description;
    }

    public  String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }
}
