package in.devtechsolutions.android.androidtablayout;

/**
 * Created by aryamirshafii on 3/9/18.
 */

public class experience extends  resumeItem{

    private String title;
    private String startYear;
    private String endyear;
    private String organizationName;
    private String contact;
    private String description;
    public experience(String title,String startYear,String endyear,String organizationName,String contact,String description){
        this.title = title;
        this.startYear = startYear;
        this.endyear = endyear;
        this.organizationName = organizationName;
        this.contact = contact;
        this.description = description;

    }
    public String getTitle(){
        return title;
    }

    public String getStartYear(){
        return startYear;
    }


    public String getEndyear(){
        return endyear;
    }


    public String getOrganizationName(){
        return organizationName;
    }

    public String getContact(){
        return contact;
    }

    public String getDescription(){
        return description;
    }
}
