package in.devtechsolutions.android.androidtablayout;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.zip.Inflater;

/**
 * Created by aryamirshafii on 1/7/18.
 */

public class editScreen extends Fragment{
    private String resumeSections[] = {"Skills","Experience", "Courses","Extracurriculars"};
    private int resumeSectionIndex = 0;
    @Nullable private View view;
    private TextView sectionText;






    //UI ITEMS


    //SKills

    private TextView skillNameLabel;
    private EditText skillNameEntry;
    private EditText skillDescritpionEntry;
    private NumberPicker skillPicker;
    private  String [] skillNames;
    private String[] skillDescriptions;


    //Experience

    private TextView startYearLabel;
    private TextView endYearLabel;
    private EditText startYearEntry;
    private EditText endYearEntry;
    private TextView organizationNameLabel;
    private EditText organizationNameEntry;

    private TextView contactLabel;
    private EditText contactEntry;

    private View experienceYearEntryView;
    private View yearView;
    private View organizationView;
    private View contactView;


    //Extracurriculars
    private TextView yearLabel;
    private EditText yearEntry;
    private dataController dataManager;


    private  String [] courseName;
    private String[] courseDescriptions;

    private View pdfVidew;


    public View onCreateView (final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataManager = new dataController(getContext());
        view =inflater.inflate(R.layout.edit_view1, container, false);



        sectionText = (TextView) view.findViewById(R.id.resumeSectionName);
        sectionText.setText(resumeSections[resumeSectionIndex]);


        skillNameLabel = (TextView) view.findViewById(R.id.skillNameLabel);
        skillNameEntry = (EditText) view.findViewById(R.id.skilNameEntry);
        skillDescritpionEntry = (EditText) view.findViewById(R.id.skillEntry);
        skillPicker = (NumberPicker)  view.findViewById(R.id.skillPicker);

        experienceYearEntryView = view.findViewById(R.id.yearEntryViewExperience);
        startYearLabel = (TextView)view.findViewById(R.id.startYearLabel);
        endYearLabel = (TextView)view.findViewById(R.id.endYearLabel);
        startYearEntry =  (EditText)view.findViewById(R.id.startYearEntry);
        endYearEntry =  (EditText)view.findViewById(R.id.endYearEntry);

        organizationNameLabel = (TextView)view.findViewById(R.id.organizationNameLabel);
        organizationNameEntry = (EditText) view.findViewById(R.id.organizationNameEntry);

        contactLabel = (TextView)view.findViewById(R.id.contactNameLabel);
        contactEntry = (EditText) view.findViewById(R.id.contactEntry);


        yearLabel = (TextView)view.findViewById(R.id.yearNameLabel);
        yearEntry = (EditText) view.findViewById(R.id.yearEntry);

        yearView = view.findViewById(R.id.yearView);;
        organizationView = view.findViewById(R.id.organizationView);;
        contactView = view.findViewById(R.id.contactView);;


        this.configureButtons();
        this.configureUI(0);
        return view;
    }

    private void configureButtons(){
        final Button backButton = (Button) view.findViewById(R.id.backButton);
        final Button saveButton = (Button)view.findViewById(R.id.saveButton);
        backButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Tab2Fragment fragmentToGoTo = new Tab2Fragment();
                ft.replace(R.id.editScreen, fragmentToGoTo);



                ((ViewGroup) backButton.getParent()).removeView(backButton);
                ((ViewGroup) saveButton.getParent()).removeView(saveButton);
                ft.commit();


            }
        });


        saveButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(resumeSectionIndex == 0){

                    dataManager.saveSkill(skillNameEntry.getText(),skillDescritpionEntry.getText());
                    dataManager.getSkills();
                } else if(resumeSectionIndex == 1){
                    dataManager.saveExperience(skillNameEntry.getText(),startYearEntry.getText(),
                            endYearEntry.getText(),organizationNameEntry.getText(),
                            contactEntry.getText(),skillDescritpionEntry.getText());
                    dataManager.getExperience();
                } else if(resumeSectionIndex == 2){
                    dataManager.saveCourse(skillNameEntry.getText(),skillDescritpionEntry.getText());
                } else if(resumeSectionIndex == 3){
                    dataManager.saveExtracurricular(skillNameEntry.getText(),yearEntry.getText(),skillDescritpionEntry.getText());
                }


                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Tab2Fragment fragmentToGoTo = new Tab2Fragment();
                ft.replace(R.id.editScreen, fragmentToGoTo);



                ((ViewGroup) backButton.getParent()).removeView(backButton);
                ((ViewGroup) saveButton.getParent()).removeView(saveButton);
                ft.commit();
            }
        });









        final ImageButton prevResumeSectionButton = (ImageButton)view.findViewById(R.id.previousResumeSection);
        prevResumeSectionButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(resumeSectionIndex == 0){
                    resumeSectionIndex = 3;

                } else {
                    resumeSectionIndex--;
                }
                configureUI(resumeSectionIndex);
                sectionText.setText(resumeSections[resumeSectionIndex]);



            }
        });




        final ImageButton nextResumeSectionButton = (ImageButton)view.findViewById(R.id.nextResumeSection);
        nextResumeSectionButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(resumeSectionIndex == 3){
                    resumeSectionIndex = 0;

                } else {
                    resumeSectionIndex++;
                }
                configureUI(resumeSectionIndex);
                sectionText.setText(resumeSections[resumeSectionIndex]);



            }
        });

    }
    private void configureUI(int index){


        if(resumeSections[index] == "Skills"){
            skillNameLabel.setText("Skill Name:");

            experienceYearEntryView.setVisibility(View.GONE);
            startYearLabel.setVisibility(View.GONE);
            endYearLabel.setVisibility(View.GONE);
            startYearEntry.setVisibility(View.GONE);
            endYearEntry.setVisibility(View.GONE);


            organizationNameLabel.setVisibility(View.GONE);
            organizationNameEntry.setVisibility(View.GONE);

            contactLabel.setVisibility(View.GONE);
            contactEntry.setVisibility(View.GONE);


            skillNameLabel.setVisibility (View.VISIBLE);
            skillNameEntry.setVisibility (View.VISIBLE);
            skillDescritpionEntry.setVisibility(View.VISIBLE);
            skillPicker.setVisibility(View.VISIBLE);
            configureSkillPicker();


            yearView.setVisibility(View.INVISIBLE);
            organizationView.setVisibility(View.INVISIBLE);
            contactView.setVisibility(View.INVISIBLE);



            yearLabel.setVisibility(View.GONE);
            yearEntry.setVisibility(View.GONE);


        } else if(resumeSections[index] == "Experience"){




            skillNameLabel.setText("Job Title:");

            skillNameLabel.setVisibility (View.VISIBLE);
            skillNameEntry.setVisibility (View.VISIBLE);
            skillDescritpionEntry.setVisibility(View.VISIBLE);
            skillPicker.setVisibility(View.GONE);

            experienceYearEntryView.setVisibility(View.VISIBLE);
            startYearLabel.setVisibility(View.VISIBLE);
            endYearLabel.setVisibility(View.VISIBLE);
            startYearEntry.setVisibility(View.VISIBLE);
            endYearEntry.setVisibility(View.VISIBLE);

            organizationNameLabel.setVisibility(View.VISIBLE);
            organizationNameEntry.setVisibility(View.VISIBLE);

            contactLabel.setVisibility(View.VISIBLE);
            contactEntry.setVisibility(View.VISIBLE);



            yearView.setVisibility(View.VISIBLE);
            organizationView.setVisibility(View.VISIBLE);
            contactView.setVisibility(View.VISIBLE);

            yearLabel.setVisibility(View.GONE);
            yearEntry.setVisibility(View.GONE);




        }else if(resumeSections[index] == "Extracurriculars"){
            skillNameLabel.setText("Activity:");


            skillNameLabel.setVisibility (View.VISIBLE);
            skillNameEntry.setVisibility (View.VISIBLE);
            skillDescritpionEntry.setVisibility(View.VISIBLE);
            skillPicker.setVisibility(View.GONE);



            experienceYearEntryView.setVisibility(View.GONE);
            startYearLabel.setVisibility(View.GONE);
            endYearLabel.setVisibility(View.GONE);
            startYearEntry.setVisibility(View.GONE);
            endYearEntry.setVisibility(View.GONE);


            organizationNameLabel.setVisibility(View.GONE);
            organizationNameEntry.setVisibility(View.GONE);

            contactLabel.setVisibility(View.GONE);
            contactEntry.setVisibility(View.GONE);



            yearLabel.setVisibility (View.VISIBLE);
            yearEntry.setVisibility (View.VISIBLE);

            skillNameLabel.setVisibility (View.VISIBLE);
            skillNameEntry.setVisibility (View.VISIBLE);
            skillDescritpionEntry.setVisibility(View.VISIBLE);

            yearView.setVisibility(View.INVISIBLE);
            organizationView.setVisibility(View.INVISIBLE);
            contactView.setVisibility(View.INVISIBLE);

        } else if(resumeSections[index] == "Courses"){


            skillNameLabel.setText("Course:     ");


            skillNameLabel.setVisibility (View.VISIBLE);
            skillNameEntry.setVisibility (View.VISIBLE);
            skillNameEntry.setText("");
            skillDescritpionEntry.setVisibility(View.VISIBLE);
            skillPicker.setVisibility(View.VISIBLE);
            configureCoursePicker();



            yearLabel.setVisibility(View.GONE);
            yearEntry.setVisibility(View.GONE);













            experienceYearEntryView.setVisibility(View.GONE);
            startYearLabel.setVisibility(View.GONE);
            endYearLabel.setVisibility(View.GONE);
            startYearEntry.setVisibility(View.GONE);
            endYearEntry.setVisibility(View.GONE);

            organizationNameLabel.setVisibility(View.GONE);
            organizationNameEntry.setVisibility(View.GONE);

            contactLabel.setVisibility(View.GONE);
            contactEntry.setVisibility(View.GONE);



            yearView.setVisibility(View.GONE);
            organizationView.setVisibility(View.GONE);
            contactView.setVisibility(View.GONE);


        }

        skillNameEntry.setText("");
        skillDescritpionEntry.setText("");




    }

    private void configureSkillPicker(){

        skillNames = new String[]{"Active Learning","Active Listening","Critical Thinking",
                "Learning Strategies","Mathematics","Monitoring","Reading Comprehension","Science",
                "Speaking","Writing","Complex Problem Solving","Time Management","Coordination",
                "Instructing","Negotiation","Persuasion","Service Orientation",
                "Social Perceptiveness","Judgment and Decision Making","Equipment Maintenance",
                "Equipment Selection","Installation",
                "Operation and Control","Programming","Quality Control Analysis",
                "Repairing","Technology Design","Troubleshooting"};


        skillDescriptions = new String[]{"Understanding the implications of new information for both current and future problem solving and decision making.","Giving full attention to what other people are saying, taking time to understand the points being made, asking questions as appropriate, and not interrupting at inappropriate times.",
                "Using logic and reasoning to identify the strengths and weaknesses of alternative solutions, conclusions or approaches to problems.","Selecting and using training/instructional methods and procedures appropriate for the situation when learning or teaching new things.",
                "Using mathematics to solve problems.","Monitoring/Assessing performance of yourself, other individuals, or organizations to make improvements or take corrective action.",
                "Understanding written sentences and paragraphs in work related documents.",  "Using scientific rules and methods to solve problems.", "Talking to others to convey information effectively.",
                "Communicating effectively in writing as appropriate for the needs of the audience.", "Identifying complex problems and reviewing related information to develop and evaluate options and implement solutions.",
                "Managing one's own time and the time of others. ","Adjusting actions in relation to others' actions. ", "Teaching others how to do something.", " Bringing others together and trying to reconcile differences. ",
                "Persuading others to change their minds or behavior. ","Actively looking for ways to help people. ", "Being aware of others' reactions and understanding why they react as they do. ",
                "Considering the relative costs and benefits of potential actions to choose the most appropriate one. ", "Performing routine maintenance on equipment and determining when and what kind of maintenance is needed. ",
                "Determining the kind of tools and equipment needed to do a job. ",  "Installing equipment, machines, wiring, or programs to meet specifications. ", "Controlling operations of equipment or systems. ",
                "Writing computer programs for various purposes. ",  "Conducting tests and inspections of products, services, or processes to evaluate quality or performance. ", "Repairing machines or systems using the needed tools. ",
                "Generating or adapting equipment and technology to serve user needs. ",  "Determining causes of operating errors and deciding what to do about it."

        };
        skillPicker.setDisplayedValues(null);
        skillPicker.setMinValue(0);
        skillPicker.setMaxValue(skillNames.length - 1);
        skillPicker.setDisplayedValues(skillNames);
        skillPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                skillNameEntry.setText(skillNames[skillPicker.getValue()]);
                skillDescritpionEntry.setText(skillDescriptions[skillPicker.getValue()]);


            }
        });



    }

    private void configureCoursePicker() {
        courseName = new String[]{"PSYCH 2103","MUSI 1202","LMC 2500","SPAN 3823","MGT 4192","MGT 4193",
                "APPH 1050","PSYC 1101","LMC 2500","APPH 1040","SPAN 2001","HTS 2015","MGT2200",
                "HIST 2112","MUSI 1202","PSYC 1101","MGT 4193","MUSI 3251","HIST 2112","LMC 3252",
                "JAP 1001","PSYC 1101","LMC 2600","SPAN 2001","LMC 2500","MGT 2200"};


        courseDescriptions = new String[]{"Behavioral Psychology" + "\n","Chorale" + "\n",
                "Introduction to Film" + "\n","Latin American Music" + "\n","IMPACT Forum" + "\n",
                "Servant Leadership" + "\n","Applied Physiology with workout" + "\n","General Psychology" + "\n",
                "Introduction to Film" + "\n", "Introduction to Film" + "\n","Applied Physiology" + "\n",
                "Intermediate Spanish" + "\n","History of Sports" + "\n","Information Technology" + "\n",
                "American History  1877 to present" + "\n","Chorale" + "\n","General Psychology" + "\n",
                "Servant Leadership" + "\n","Glee Club" + "\n","American History  1877 to present" + "\n",
                "Film and Television" + "\n", "Beginners Japaneese" + "\n","General Psychology" + "\n",
                "Intro to Performance Studies" + "\n","Intermediate Spanish" + "\n","Introduction to Film" + "\n",
                "Information Technology" + "\n"
        };


        skillPicker.setDisplayedValues(null);
        skillPicker.setMinValue(0);
        skillPicker.setMaxValue(courseName.length - 1);
        skillPicker.setDisplayedValues(courseName);
        skillPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                skillNameEntry.setText(courseName[skillPicker.getValue()]);
                skillDescritpionEntry.setText(courseDescriptions[skillPicker.getValue()]);


            }
        });




    }


}
