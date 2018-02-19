package in.devtechsolutions.android.androidtablayout;

import android.content.Context;
import android.content.res.AssetManager;
import android.provider.MediaStore;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.nio.*;

/**
 * Created by aryamirshafii on 1/18/18.
 */

public class pdfGenerator {
    private  Context context;
    public pdfGenerator(Context aContext){

        this.context = aContext;

    }

    public String getResume1(){
        String resumeContents = getHTMLAsString(1);

        return  resumeContents;

    }
    public String getResume2(){
        String resumeContents = getHTMLAsString(2);

        return  resumeContents;

    }

    public String getResume3(){
        String resumeContents = getHTMLAsString(3);

        return  resumeContents;

    }

    public String getResume4(){
        String resumeContents = getHTMLAsString(4);

        return  resumeContents;

    }

    private String getHTMLAsString(int resumeNumber){
        String fileName;
        if(resumeNumber == 1){
            fileName = "resume1.html";


        }else if(resumeNumber == 2){
            fileName =  "resume2.html";

        }else if(resumeNumber == 3){
            fileName =  "resume3.html";

        }else {
            fileName = "resume4.html";
        }



        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(fileName), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            String stringToReturn = "";
            while ((mLine = reader.readLine()) != null) {
                //process line
                stringToReturn += mLine;
            }
            return stringToReturn;
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return  "";
    }


    
}
