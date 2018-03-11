package in.devtechsolutions.android.androidtablayout;

/**
 * Created by aryamirshafii on 3/8/18.
 */

public class skill extends resumeItem{
    private  String name;
    private String description;

    public skill(String skillName, String skillDescription){
        this.name = skillName;
        this.description = skillDescription;
    }

    public  String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }
}
