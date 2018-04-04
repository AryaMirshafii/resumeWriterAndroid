package in.devtechsolutions.android.androidtablayout;

import android.content.Context;
import android.text.Editable;

import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


/**
 * Created by aryamirshafii on 1/14/18.
 */

public class dataController{
    private Context context;
    private String objectiveFileName = "objective.txt";
    private String loginFileName = "login.txt";
    private String firstNameFileName = "firstName.txt";
    private String lastNameFileName = "lastName.txt";
    private String phoneFileName = "phoneNumber.txt";
    private String educationFileName = "emailAdress.txt";
    private String skillFileName = "skill.txt";
    private String experienceFileName = "experience.txt";
    private String courseFileName = "courses.txt";
    private String extracurricularFilename = "extracurriculars";
    private String resumeNumberFileName = "extracurriculars";




    private String emailFileName = "email.txt";

    private String filePathFileName = "filepath.txt";






    public  dataController(Context context){
        this.context = context;



    }



    public void setResumeNumber(int resumeNumber){
        String theResumeNumber = Integer.toString(resumeNumber);
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(resumeNumberFileName , Context.MODE_PRIVATE);
            outputStream.write(theResumeNumber.toString().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getResumeNumber(){
        FileInputStream fis;
        int n;
        try {
            fis = context.openFileInput(resumeNumberFileName);
            StringBuffer fileContent = new StringBuffer("");

            byte[] buffer = new byte[1024];



            while ((n = fis.read(buffer)) != -1)
            {
                fileContent.append(new String(buffer, 0, n));
            }

            return fileContent.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "1";

    }




    public void setFilePath(String filePath){
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(filePathFileName , Context.MODE_PRIVATE);
            outputStream.write(filePath.toString().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getFilePath(){
        FileInputStream fis;
        int n;
        try {
            fis = context.openFileInput(filePathFileName);
            StringBuffer fileContent = new StringBuffer("");

            byte[] buffer = new byte[1024];



            while ((n = fis.read(buffer)) != -1)
            {
                fileContent.append(new String(buffer, 0, n));
            }

            return fileContent.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";

    }





    public void setFirstName(String firstName){
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(firstNameFileName , Context.MODE_PRIVATE);
            outputStream.write(firstName.toString().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public String getFirstname(){
        FileInputStream fis;
        int n;
        try {
            fis = context.openFileInput(firstNameFileName);
            StringBuffer fileContent = new StringBuffer("");

            byte[] buffer = new byte[1024];



            while ((n = fis.read(buffer)) != -1)
            {
                fileContent.append(new String(buffer, 0, n));
            }

            return fileContent.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";

    }


    public void setLastName(String lastName){
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(lastNameFileName , Context.MODE_PRIVATE);
            outputStream.write(lastName.toString().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public String getLastName(){
        FileInputStream fis;
        int n;
        try {
            fis = context.openFileInput(lastNameFileName);
            StringBuffer fileContent = new StringBuffer("");

            byte[] buffer = new byte[1024];



            while ((n = fis.read(buffer)) != -1)
            {
                fileContent.append(new String(buffer, 0, n));
            }

            return fileContent.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";

    }


    public void setEmail(String emailAdress){
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(emailFileName , Context.MODE_PRIVATE);
            outputStream.write(emailAdress.toString().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getEmail(){
        FileInputStream fis;
        int n;
        try {
            fis = context.openFileInput(emailFileName);
            StringBuffer fileContent = new StringBuffer("");

            byte[] buffer = new byte[1024];



            while ((n = fis.read(buffer)) != -1)
            {
                fileContent.append(new String(buffer, 0, n));
            }

            return fileContent.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";

    }


    public void setPhoneNumber(String phoneNumber){
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(phoneFileName , Context.MODE_PRIVATE);
            outputStream.write(phoneNumber.toString().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getPhoneNumber(){
        FileInputStream fis;
        int n;
        try {
            fis = context.openFileInput(phoneFileName);
            StringBuffer fileContent = new StringBuffer("");

            byte[] buffer = new byte[1024];



            while ((n = fis.read(buffer)) != -1)
            {
                fileContent.append(new String(buffer, 0, n));
            }

            return fileContent.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";

    }


    public void setEducation(String schoolName){
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(educationFileName , Context.MODE_PRIVATE);
            outputStream.write(schoolName.toString().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public String getEducation(){
        FileInputStream fis;
        int n;
        try {
            fis = context.openFileInput(educationFileName);
            StringBuffer fileContent = new StringBuffer("");

            byte[] buffer = new byte[1024];



            while ((n = fis.read(buffer)) != -1)
            {
                fileContent.append(new String(buffer, 0, n));
            }

            return fileContent.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";

    }






    public void setLoginComplete(Boolean shouldLogin){
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(loginFileName , Context.MODE_PRIVATE);
            outputStream.write(shouldLogin.toString().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public boolean getLoginComplete(){


        FileInputStream fis;
        int n;
        try {
            fis = context.openFileInput(loginFileName);
            StringBuffer fileContent = new StringBuffer("");

            byte[] buffer = new byte[1024];



            while ((n = fis.read(buffer)) != -1)
            {
                fileContent.append(new String(buffer, 0, n));
            }
            return Boolean.valueOf(fileContent.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }




    public void setObjective(String objective){




        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(objectiveFileName , Context.MODE_PRIVATE);
            outputStream.write(objective.getBytes());
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getObjective(){

        FileInputStream fis;
        int n;
        try {
            fis = context.openFileInput(objectiveFileName);
            StringBuffer fileContent = new StringBuffer("");

            byte[] buffer = new byte[1024];



            while ((n = fis.read(buffer)) != -1)

            {
                fileContent.append(new String(buffer, 0, n));
            }

            return  fileContent.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return  "";
    }

    /**
     * Allows the user to save entered skills
     * @param name the skill name
     * @param description the skill description
     */
    private Editable theName;
    private Editable theDescription;
    public void saveSkill(Editable name, Editable description) {

        if(name == null || description == null){
            return;
        }
        theName = name;
        theDescription = description;
        String skillToAdd = name +"_" + description + "\n";
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(skillFileName , Context.MODE_APPEND);
            outputStream.write(skillToAdd.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }




    }



    public  List getSkills(){
       ArrayList<skill> listToReturn = new ArrayList<skill>();

        try {
            InputStream inputStream = context.openFileInput(skillFileName);

            if (inputStream != null) {
                InputStreamReader streamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(streamReader);

                String l;
                skill toAdd;
                while ( (l = bufferedReader.readLine()) != null) {

                    System.out.println("MY line  is" + l);
                    String[] skillSeparated = l.split("_");
                    toAdd= new skill(skillSeparated[0], skillSeparated[1]);
                    listToReturn.add(toAdd);
                }

            }

            inputStream.close(); //close the file
        } catch (java.io.FileNotFoundException e) {
            //file doesnt exist
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listToReturn;
    }



    public void saveCourse(Editable name, Editable description){
        if(name == null || description == null ){
            return;
        }
        String experienceToAdd = name +"_" + description  + "\n";
        FileOutputStream outputStream;


        try {
            outputStream = context.openFileOutput(courseFileName , Context.MODE_APPEND);
            outputStream.write(experienceToAdd.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public List getCourses(){
        ArrayList<course> listToReturn = new ArrayList<course>();
        try {
            InputStream inputStream = context.openFileInput(courseFileName);

            if (inputStream != null) {
                InputStreamReader streamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(streamReader);

                String l;
                course toAdd;
                while (( l = bufferedReader.readLine()) != null) {
                    // do what you want with the line

                    System.out.println("MY line  is" + l);
                    String[] skillSeparated = l.split("_");
                    if(skillSeparated.length == 2){
                        toAdd= new course(skillSeparated[0], skillSeparated[1]);
                        listToReturn.add(toAdd);
                    }

                }

            }

            inputStream.close(); //close the file
        } catch (java.io.FileNotFoundException e) {
            //file doesnt exist
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listToReturn;
    }








    public void saveExperience(Editable title, Editable startYear, Editable endYear,Editable organizationName, Editable contact, Editable description){
        if(title == null || startYear == null || endYear == null || organizationName == null || contact == null || description == null){
            return;
        }

        String experienceToAdd = title +"_" + startYear +"_" + endYear +"_" + organizationName +"_" + contact +"_" + description + "\n";
        FileOutputStream outputStream;


        try {
            outputStream = context.openFileOutput(experienceFileName , Context.MODE_APPEND);
            outputStream.write(experienceToAdd.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public List getExperience(){
        ArrayList<experience> listToReturn = new ArrayList<experience>();
        try {
            InputStream inputStream = context.openFileInput(experienceFileName);

            if (inputStream != null) {
                InputStreamReader streamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(streamReader);

                String l;
                experience toAdd;
                while (( l = bufferedReader.readLine()) != null) {
                    // do what you want with the line
                    System.out.println("MY line  is" + l);
                    String[] skillSeparated = l.split("_");
                    if(skillSeparated.length == 6){
                        toAdd= new experience(skillSeparated[0], skillSeparated[1],skillSeparated[2],skillSeparated[3],skillSeparated[4],skillSeparated[5]);
                        listToReturn.add(toAdd);
                    }



                }

            }

            inputStream.close(); //close the file
        } catch (java.io.FileNotFoundException e) {
            //file doesnt exist
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listToReturn;
    }




    public void saveExtracurricular(Editable name,Editable year, Editable description) {
        if(name == null || year == null || description == null){
            return;
        }

        String skillToAdd = name +"_" + year + "_" +  description + "\n";
        FileOutputStream outputStream;


        try {
            outputStream = context.openFileOutput(extracurricularFilename , Context.MODE_APPEND);
            outputStream.write(skillToAdd.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //start with array but use hashmap once you know it works
    public List getExtracurricular(){
        ArrayList<extracurricular> listToReturn = new ArrayList<extracurricular>();
        try {
            InputStream inputStream = context.openFileInput(extracurricularFilename);

            if (inputStream != null) {
                InputStreamReader streamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(streamReader);

                String l;
                extracurricular toAdd;
                while ( bufferedReader.readLine().length() > 3 && (l = bufferedReader.readLine()) != null) {
                    // do what you want with the line
                    System.out.println("MY line  is" + l);
                    String[] skillSeparated = l.split("_");
                    toAdd= new extracurricular(skillSeparated[0], skillSeparated[1],skillSeparated[2]);
                    listToReturn.add(toAdd);
                }

            }

            inputStream.close(); //close the file
        } catch (java.io.FileNotFoundException e) {
            //file doesnt exist
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listToReturn;
    }

}
