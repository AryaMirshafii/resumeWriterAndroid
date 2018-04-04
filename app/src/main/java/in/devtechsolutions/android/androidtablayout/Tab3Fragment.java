package in.devtechsolutions.android.androidtablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import pub.devrel.easypermissions.EasyPermissions;




public class Tab3Fragment extends Fragment {


    private EditText firstNameEntry;
    private EditText lastNameEntry;
    private EditText emailEntry;
    private EditText phoneNumberEntry;
    private EditText schoolEntry;
    private dataController dataManager;
    private TextView welcomeLabel;



    //google Drive stuff
    private Button mCallApiButton;

    @Nullable
    @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tab3 , container, false);
        firstNameEntry = (EditText) view.findViewById(R.id.firstNameEntry);
        lastNameEntry= (EditText) view.findViewById(R.id.lastnameEntry);
        emailEntry = (EditText) view.findViewById(R.id.emailEntry);
        phoneNumberEntry = (EditText) view.findViewById(R.id.phoneEntry);
        schoolEntry = (EditText) view.findViewById(R.id.schoolEntry);
        welcomeLabel = (TextView) view.findViewById(R.id.welcomceLabel);
        dataManager = new dataController(getContext());
        configureText();
        return view;


    }
    private void configureText(){
        welcomeLabel.setText("Welcome " + dataManager.getFirstname());
        firstNameEntry.setText(dataManager.getFirstname());
        lastNameEntry.setText(dataManager.getLastName());
        emailEntry.setText(dataManager.getEmail());
        phoneNumberEntry.setText(dataManager.getPhoneNumber());
        schoolEntry.setText(dataManager.getEducation());
    }
}
