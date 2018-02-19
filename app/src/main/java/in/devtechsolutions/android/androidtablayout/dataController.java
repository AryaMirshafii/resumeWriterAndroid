package in.devtechsolutions.android.androidtablayout;

import android.content.Context;

import java.io.File;
import java.io.*;

/**
 * Created by aryamirshafii on 1/14/18.
 */

public class dataController {
    private Context context;
    private String objectiveFileName = "objective.txt";
    private String loginFileName = "login.txt";
    private String firstNameFileName = "firstName.txt";
    private String lastNameFileName = "lastName.txt";
    private String phoneFileName = "phoneNumber.txt";
    private String educationFileName = "emailAdress.txt";

    private String emailFileName = "email.txt";
    public  dataController(Context context){
        this.context = context;


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

            return fileContent.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
