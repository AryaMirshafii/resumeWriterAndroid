package in.devtechsolutions.android.androidtablayout;

import android.arch.lifecycle.ViewModelProviders;
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
    private dataController dataManager;
    public pdfGenerator(Context aContext){

        this.context = aContext;
        dataManager = new dataController(context);




    }

    public String getResume1(){
        //String resumeContents = getHTMLAsString(1);
        String resumeContents = inputUserData( getHTMLAsString(1),1);
        return  resumeContents;

    }
    public String getResume2(){
        String resumeContents = inputUserData( getHTMLAsString(2),2);

        return  resumeContents;

    }

    public String getResume3(){
        String resumeContents = inputUserData( getHTMLAsString(3),3);

        return  resumeContents;

    }

    public String getResume4(){


        String resumeContents = inputUserData( getHTMLAsString(4),4);


        return  resumeContents;

    }
    private String inputUserData(String htmlString,int resumeNumber){
        String beingLookedAt = htmlString;


        beingLookedAt = beingLookedAt.replace("YourNameHere",dataManager.getFirstname() + " " + dataManager.getLastName());
        beingLookedAt = beingLookedAt.replace("YourPhoneNumberHere","Phone Number: " + dataManager.getPhoneNumber());
        beingLookedAt = beingLookedAt.replace("YourEmailHere","Email:  " + dataManager.getEmail());

        if(resumeNumber ==1){

            if(dataManager.getObjective() != null){
                beingLookedAt = beingLookedAt.replace("ObjectiveGoHere",dataManager.getObjective());

            } else {
                beingLookedAt = beingLookedAt.replace("<p class=\"head\">Objective</p><dl>ObjectiveGoHere</dl>","");
            }




            if(!dataManager.getSkills().isEmpty()){
                String skillHTML = "";
                List<skill> skills = dataManager.getSkills();
                for(int i = 0; i < skills.size(); i++){

                    skillHTML += String.format("<h3>%s</h3><ul><li>%s</li></ul>",skills.get(i).getName(),skills.get(i).getDescription());

                }
                beingLookedAt = beingLookedAt.replace("SkillsGoHere",skillHTML);
            } else {
                beingLookedAt = beingLookedAt.replace("<p class=\"head\">Skills</p><dl>SkillsGoHere</dl>","");
            }


            if(!dataManager.getExperience().isEmpty()){

                String experienceHTML = "";
                List<experience> experiences = dataManager.getExperience();

                for(int i = 0; i < experiences.size(); i++){
                    experienceHTML += String.format("<h3>%s</h3><h4>%s</h4><ul><li>%s</li></ul>",experiences.get(i).getTitle(),
                            experiences.get(i).getOrganizationName() + " - " + experiences.get(i).getStartYear() +
                                    "-" + experiences.get(i).getEndyear() ,experiences.get(i).getDescription());
                }

                beingLookedAt = beingLookedAt.replace("ExperienceGoHere",experienceHTML);
            } else {
                beingLookedAt = beingLookedAt.replace("<p class=\"head\">Internship and Job Experience</p><dl>ExperienceGoHere</dl>","");
            }


            if(!dataManager.getExtracurricular().isEmpty()){
                String extracurricularHTML = "";
                List <extracurricular> extracurriculars = dataManager.getExtracurricular();

                for(int i = 0; i < extracurriculars.size(); i++){
                    extracurricularHTML += String.format("<h3>%s</h3><ul><li>%s</li></ul>",extracurriculars.get(i).getName(),
                            extracurriculars.get(i).getDescription());
                }


                beingLookedAt = beingLookedAt.replace("extracurricularsGoHere",extracurricularHTML);
            }else {
                beingLookedAt = beingLookedAt.replace( "<p class=\"head\">Extracurricular Activities</p><dl>extracurricularsGoHere</dl>",  "");
            }



            if(!dataManager.getCourses().isEmpty()){
                String courseHTML = "";
                List<course> courses = dataManager.getCourses();
                for(int i = 0; i < courses.size(); i++){
                    courseHTML += String.format("<h3>%s</h3><ul><li>%s</li></ul>",
                            courses.get(i).getName(),courses.get(i).getDescription());
                }


                beingLookedAt = beingLookedAt.replace("CoursesGoHere",courseHTML);
            }else {
                beingLookedAt = beingLookedAt.replace( "<p class=\"head\">Courses Taken</p><dl>CoursesGoHere</dl>", "");
            }



        } else if(resumeNumber == 2){



            if(dataManager.getObjective() != null){
                String objectiveHTML = "";
                objectiveHTML += String.format("<h2>%s</h2><p>%s</p>","Objectives" ,dataManager.getObjective());
                beingLookedAt = beingLookedAt.replace("ObjectiveGoHere",objectiveHTML);
            } else {
                beingLookedAt = beingLookedAt.replace("</div><div id=\"objective\"><p>ObjectiveGoHere</p></div>","");
            }




            if(!dataManager.getSkills().isEmpty()){
                String skillHTML = "";
                List<skill> skills = dataManager.getSkills();
                for(int i = 0; i < skills.size(); i++){

                    skillHTML += String.format("<h2>%s</h2><p>%s</p>",skills.get(i).getName(),skills.get(i).getDescription());

                }
                beingLookedAt = beingLookedAt.replace("SkillsGoHere",skillHTML);
            } else {
                beingLookedAt = beingLookedAt.replace("<dd class=\"clear\"></dd><dt>Skills</dt><dd>SkillsGoHere</dd>","");
            }


            if(!dataManager.getExperience().isEmpty()){

                String experienceHTML = "";
                List<experience> experiences = dataManager.getExperience();

                for(int i = 0; i < experiences.size(); i++){
                    experienceHTML += String.format("<h2>%s<span>%s</span></h2><ul><li>%s</li></ul>",experiences.get(i).getTitle(),
                            experiences.get(i).getOrganizationName() + " - " + experiences.get(i).getStartYear() +
                                    "-" + experiences.get(i).getEndyear() ,experiences.get(i).getDescription());
                }

                beingLookedAt = beingLookedAt.replace("ExperienceGoHere",experienceHTML);
            } else {
                beingLookedAt = beingLookedAt.replace("<dd class=\"clear\"></dd><dt>Internship and Job Experience</dt><dd>ExperienceGoHere</dd>",
                        "");
            }


            if(!dataManager.getExtracurricular().isEmpty()){
                String extracurricularHTML = "";
                List <extracurricular> extracurriculars = dataManager.getExtracurricular();

                for(int i = 0; i < extracurriculars.size(); i++){
                    extracurricularHTML += String.format("<h2>%s</h2><p>%s</p>",extracurriculars.get(i).getName(),
                            extracurriculars.get(i).getDescription());
                }


                beingLookedAt = beingLookedAt.replace("extracurricularsGoHere",extracurricularHTML);
            }else {
                beingLookedAt = beingLookedAt.replace( "<dd class=\"clear\"></dd><dt>Extracurricular Activities</dt><dd>extracurricularsGoHere</dd>",  "");
            }



            if(!dataManager.getCourses().isEmpty()){
                String courseHTML = "";
                List<course> courses = dataManager.getCourses();
                for(int i = 0; i < courses.size(); i++){
                    courseHTML += String.format("<h2>%s</h2><p>%s</p>",
                            courses.get(i).getName(),courses.get(i).getDescription());
                }


                beingLookedAt = beingLookedAt.replace("CoursesGoHere",courseHTML);
            }else {
                beingLookedAt = beingLookedAt.replace( "<dd class=\"clear\"></dd><dt>Courses Taken</dt><dd>CoursesGoHere</dd>", "");
            }



        } else if(resumeNumber == 3){

















            if(dataManager.getObjective() != null){
                beingLookedAt = beingLookedAt.replace("ObjectiveGoHere",dataManager.getObjective());

            } else {
                beingLookedAt = beingLookedAt.replace("<div class=\"yui-gf\"><div class=\"yui-u first\"><h2>Objective</h2></div><div class=\"yui-u\"><p class=\"enlarge\">ObjectiveGoHere</p></div></div>","");
            }




            if(!dataManager.getSkills().isEmpty()){
                String skillHTML = "";
                List<skill> skills = dataManager.getSkills();
                for(int i = 0; i < skills.size(); i++){

                    skillHTML += String.format("<div class=talent><h2>%s</h2><p>%s</p></div>",skills.get(i).getName(),skills.get(i).getDescription());

                }
                beingLookedAt = beingLookedAt.replace("SkillsGoHere",skillHTML);
            } else {
                beingLookedAt = beingLookedAt.replace("<div class=\"yui-gf\"><div class=\"yui-u first\"><h2>Skills</h2></div><div class=\"yui-u\">SkillsGoHere</div>","");
            }


            if(!dataManager.getExperience().isEmpty()){

                String experienceHTML = "";
                List<experience> experiences = dataManager.getExperience();

                for(int i = 0; i < experiences.size(); i++){
                    experienceHTML += String.format("<div class=job><h2>%s</h2><h3>%s</h3><h4>%s/h4><p>%s</p></div>",experiences.get(i).getTitle(),
                            experiences.get(i).getOrganizationName(), experiences.get(i).getStartYear() +
                                    "-" + experiences.get(i).getEndyear() ,experiences.get(i).getDescription());
                }

                beingLookedAt = beingLookedAt.replace("ExperienceGoHere",experienceHTML);
            } else {
                beingLookedAt = beingLookedAt.replace("<div class=\"yui-gf\"><div class=\"yui-u first\"><h2>Experience</h2></div><div class=\"yui-u\">ExperienceGoHere</div>","");
            }


            if(!dataManager.getExtracurricular().isEmpty()){
                String extracurricularHTML = "";
                List <extracurricular> extracurriculars = dataManager.getExtracurricular();

                for(int i = 0; i < extracurriculars.size(); i++){
                    extracurricularHTML += String.format("<div class=talent><h2>%s</h2><p>%s</p></div>",extracurriculars.get(i).getName(),
                            extracurriculars.get(i).getDescription());
                }


                beingLookedAt = beingLookedAt.replace("extracurricularsGoHere",extracurricularHTML);
            }else {
                beingLookedAt = beingLookedAt.replace("<div class=\"yui-gf\"><div class=\"yui-u first\"><h2>ExtraCurriculars</h2></div><div class=\"yui-u\">extracurricularsGoHere</div>",  "");
            }



            if(!dataManager.getCourses().isEmpty()){
                String courseHTML = "";
                List<course> courses = dataManager.getCourses();
                for(int i = 0; i < courses.size(); i++){
                    courseHTML += String.format("<div class=talent><h2>%s</h2><p>%s</p></div>",
                            courses.get(i).getName(),courses.get(i).getDescription());
                }


                beingLookedAt = beingLookedAt.replace("CoursesGoHere",courseHTML);
            }else {
                beingLookedAt = beingLookedAt.replace( "<div class=\"yui-gf\"><div class=\"yui-u first\"><h2>Courses</h2></div><div class=\"yui-u\">CoursesGoHere</div>", "");
            }





        } else if( resumeNumber == 4){

















            if(dataManager.getObjective() != null){
                beingLookedAt = beingLookedAt.replace("ObjectiveGoHere",dataManager.getObjective());

            } else {
                beingLookedAt = beingLookedAt.replace("<section><article><div class=\"sectionTitle\"><h1>Objective</h1></div><div class=\"sectionContent\"><p>ObjectiveGoHere</p></div></article><div class=\"clear\"></div></section>","");
            }




            if(!dataManager.getSkills().isEmpty()){
                String skillHTML = "";
                List<skill> skills = dataManager.getSkills();
                for(int i = 0; i < skills.size(); i++){

                    skillHTML += String.format("<article><h2>%s</h2><p>%s</p></article>",skills.get(i).getName(),skills.get(i).getDescription());

                }
                beingLookedAt = beingLookedAt.replace("SkillsGoHere",skillHTML);
            } else {
                beingLookedAt = beingLookedAt.replace("<section><div class=\"sectionTitle\"><h1>Skills</h1></div><div class=\"sectionContent\"><ul class=\"keySkills\"><ul style=\"list-style-type:none\">SkillsGoHere</ul></ul></div><div class=\"clear\"></div></section>","");
            }


            if(!dataManager.getExperience().isEmpty()){

                String experienceHTML = "";
                List<experience> experiences = dataManager.getExperience();

                for(int i = 0; i < experiences.size(); i++){
                    experienceHTML += String.format("<article><h2>%s</h2><pclass=subDetails>%s</p><p>%s</p></article>",experiences.get(i).getTitle(),
                            experiences.get(i).getOrganizationName() + " - " + experiences.get(i).getStartYear() +
                                    "-" + experiences.get(i).getEndyear() ,experiences.get(i).getDescription());
                }

                beingLookedAt = beingLookedAt.replace("ExperienceGoHere",experienceHTML);
            } else {
                beingLookedAt = beingLookedAt.replace("<section><div class=\"sectionTitle\"><h1>Internship and Job Experience</h1></div><div class=\"sectionContent\">ExperienceGoHere</div><div class=\"clear\"></div></section>","");
            }


            if(!dataManager.getExtracurricular().isEmpty()){
                String extracurricularHTML = "";
                List <extracurricular> extracurriculars = dataManager.getExtracurricular();

                for(int i = 0; i < extracurriculars.size(); i++){
                    extracurricularHTML += String.format("<article><h2>%s</h2><p>%s</p></article>",extracurriculars.get(i).getName(),
                            extracurriculars.get(i).getDescription());
                }


                beingLookedAt = beingLookedAt.replace("extracurricularsGoHere",extracurricularHTML);
            }else {
                beingLookedAt = beingLookedAt.replace( "<section><div class=\"sectionTitle\"><h1>Extracurriculars</h1></div><div class=\"sectionContent\"><ul class=\"keySkills\"><ul style=\"list-style-type:none\">extracurricularsGoHere</ul></ul></div><div class=\"clear\"></div></section>",  "");
            }



            if(!dataManager.getCourses().isEmpty()){
                String courseHTML = "";
                List<course> courses = dataManager.getCourses();
                for(int i = 0; i < courses.size(); i++){
                    courseHTML += String.format("<article><h2>%s</h2><p>%s</p></article>",
                            courses.get(i).getName(),courses.get(i).getDescription());
                }


                beingLookedAt = beingLookedAt.replace("CoursesGoHere",courseHTML);
            }else {
                beingLookedAt = beingLookedAt.replace( "<section><div class=\"sectionTitle\"><h1>Courses</h1></div><div class=\"sectionContent\"><ul class=\"keySkills\"><ul style=\"list-style-type:none\">CoursesGoHere</ul></ul></div><div class=\"clear\"></div></section>", "");
            }



        }


        return beingLookedAt;

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
