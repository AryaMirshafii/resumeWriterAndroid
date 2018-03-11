package in.devtechsolutions.android.androidtablayout;

import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aryamirshafii on 3/8/18.
 */

public class resumeItemAdapter extends RecyclerView.Adapter<resumeItemAdapter.theViewHolder> {

    private List<resumeItem> itemList;
    private List<experience> experienceList;
    private int cellColor;
    private String cellType;
    public TextView skillDescription;
    public TextView skillTitle;

    public TextView experienceRole;
    public TextView companyName;
    public TextView experienceStartyear;
    public TextView experienceEndYear;
    public TextView experienceDescription;


    public TextView courseTitle;
    public TextView courseDescription;


    public TextView extracurricularTitle;
    public TextView extracurricularDescription;
    public TextView extracurricularDate;


    public class theViewHolder extends RecyclerView.ViewHolder {




        public theViewHolder(View view) {
            super(view);



        }
    }

    public resumeItemAdapter(List<resumeItem> listOfItems, String type) {


        this.cellType = type;

        this.itemList = listOfItems;
    }


    @Override
    public theViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        if(cellType.equals("skill")){
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.skillcell, parent, false);
            itemView.setBackgroundColor(ContextCompat.getColor(parent.getContext(),R.color.skillColor));
            skillTitle = (TextView) itemView.findViewById(R.id.skillTitle);

            skillDescription = (TextView) itemView.findViewById(R.id.skillDescription);
        }
        else if(cellType.equals("experience")) {
             itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.experiencecell, parent, false);
            experienceRole = (TextView)itemView.findViewById(R.id.experienceRole);
            companyName = (TextView)itemView.findViewById(R.id.companyName);
            experienceStartyear = (TextView)itemView.findViewById(R.id.startYear);
            experienceEndYear = (TextView)itemView.findViewById(R.id.endYear);
            experienceDescription = (TextView)itemView.findViewById(R.id.experienceDescription);
        } else  if(cellType.equals("course")){
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.coursecell, parent, false);
            itemView.setBackgroundColor(ContextCompat.getColor(parent.getContext(),R.color.courseColor));
            courseTitle = (TextView) itemView.findViewById(R.id.courseTitle);

            courseDescription = (TextView) itemView.findViewById(R.id.courseDescription);
        } else if(cellType.equals("extracurricular")){
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.extracurricularcell, parent, false);
            itemView.setBackgroundColor(ContextCompat.getColor(parent.getContext(),R.color.extraCurricularColor));
            extracurricularTitle = (TextView) itemView.findViewById(R.id.extracurricularTitle);

            extracurricularDescription = (TextView) itemView.findViewById(R.id.extracurricularDescription);
            extracurricularDate = (TextView) itemView.findViewById(R.id.extracurricularDate);
        } else {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cell, parent, false);
        }
        return new theViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(theViewHolder holder, int position) {

        if(cellType.equals("skill")){
            //skill aSkill = skillList.get(position).
            skill aSkill = (skill) itemList.get(position);
            //holder.skillTitle.setText(aSkill.getName());
            skillTitle.setText(aSkill.getName());
            skillDescription.setText(aSkill.getDescription());
        } else if(cellType.equals("experience")) {
            //skill aSkill = skillList.get(position).
            experience anExperiencee = (experience)itemList.get(position);
            //holder.skillTitle.setText(aSkill.getName());
            experienceRole.setText(anExperiencee.getTitle());
            companyName.setText(anExperiencee.getOrganizationName());
            experienceStartyear.setText(anExperiencee.getStartYear());
            experienceEndYear.setText(anExperiencee.getEndyear());
            experienceDescription.setText(anExperiencee.getDescription());
        } else if(cellType.equals("course")){

            course aCourse = (course)itemList.get(position);
            //holder.skillTitle.setText(aSkill.getName());
            courseTitle.setText(aCourse.getName());
            courseDescription.setText(aCourse.getDescription());


        }else if(cellType.equals("extracurricular")){

            extracurricular anExtraCurricular = (extracurricular) itemList.get(position);
            //holder.skillTitle.setText(aSkill.getName());
            extracurricularTitle.setText(anExtraCurricular.getName());
            extracurricularDescription.setText(anExtraCurricular.getDescription());
            extracurricularDate.setText(anExtraCurricular.getYear());


        } else {
            //skill aSkill = skillList.get(position).
            skill aSkill = (skill)itemList.get(position);
            //holder.skillTitle.setText(aSkill.getName());
            skillTitle.setText(aSkill.getName());
            skillDescription.setText(aSkill.getDescription());
        }




    }



    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
