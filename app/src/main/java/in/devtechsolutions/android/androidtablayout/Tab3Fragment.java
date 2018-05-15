package in.devtechsolutions.android.androidtablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.widget.*;
import com.google.api.client.*;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.drive.DriveScopes;

import java.util.Arrays;

import pub.devrel.easypermissions.EasyPermissions;


import com.google.api.services.drive.DriveScopes;

public class Tab3Fragment extends Fragment{


    private EditText firstNameEntry;
    private EditText lastNameEntry;
    private EditText emailEntry;
    private EditText phoneNumberEntry;
    private EditText schoolEntry;
    private dataController dataManager;
    private TextView welcomeLabel;
    private View view;


    //google Drive stuff
    private Button mCallApiButton;
    private Boolean editTextsConfigured = false;
    private Button googleSignInButton;



    @Nullable
    @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_tab3 , container, false);
        firstNameEntry = (EditText) view.findViewById(R.id.firstNameEntry);
        lastNameEntry= (EditText) view.findViewById(R.id.lastnameEntry);
        emailEntry = (EditText) view.findViewById(R.id.emailEntry);
        phoneNumberEntry = (EditText) view.findViewById(R.id.phoneEntry);
        schoolEntry = (EditText) view.findViewById(R.id.schoolEntry);
        welcomeLabel = (TextView) view.findViewById(R.id.welcomceLabel);
        dataManager = new dataController(getContext());
        configureText();




        googleSignInButton = (Button)view.findViewById(R.id.signInButton);

        if(dataManager.getLoginComplete()){
            ((MainActivity)getActivity()).initializeCredentials();
        }

        if(((MainActivity)getActivity()).getSignInState()){
            googleSignInButton.setVisibility(view.GONE);
        } else {
            googleSignInButton.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    ((MainActivity)getActivity()).getResultsFromApi();

                    if(((MainActivity)getActivity()).getSignInState()){
                        googleSignInButton.setVisibility(view.GONE);
                    }

                }
            });
        }






        return view;


    }











    private void configureText(){
        welcomeLabel.setText("Welcome " + dataManager.getFirstname());
        firstNameEntry.setText(dataManager.getFirstname());
        lastNameEntry.setText(dataManager.getLastName());
        emailEntry.setText(dataManager.getEmail());
        phoneNumberEntry.setText(dataManager.getPhoneNumber());
        schoolEntry.setText(dataManager.getEducation());





        firstNameEntry.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER
                        || actionId == EditorInfo.IME_ACTION_DONE) {
                    //Save the text
                    dataManager.setFirstName(firstNameEntry.getText().toString());
                    return true;
                }
                return false;
            }
        });


        lastNameEntry.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER
                        || actionId == EditorInfo.IME_ACTION_DONE) {
                    //Save the text
                    dataManager.setLastName(lastNameEntry.getText().toString());
                    return true;
                }
                return false;
            }
        });






        emailEntry.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER
                        || actionId == EditorInfo.IME_ACTION_DONE) {
                    //Save the text
                    dataManager.setEmail(emailEntry.getText().toString());
                    return true;
                }
                return false;
            }
        });


        phoneNumberEntry.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER
                        || actionId == EditorInfo.IME_ACTION_DONE) {
                    //Save the text
                    dataManager.setPhoneNumber(phoneNumberEntry.getText().toString());
                    return true;
                }
                return false;
            }
        });








        schoolEntry.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER
                        || actionId == EditorInfo.IME_ACTION_DONE) {
                    //Save the text
                    dataManager.setEducation(schoolEntry.getText().toString());
                    return true;
                }
                return false;
            }
        });


        view.setOnKeyListener( new View.OnKeyListener() {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event ) {

                if( keyCode == KeyEvent.KEYCODE_BACK ) {
                    System.out.println("YOU WENT BACK!?!?!?!");

                    return true;
                }
                return false;
            }
        });


        editTextsConfigured = true;

    }






    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {
            welcomeLabel.setText("Welcome " + dataManager.getFirstname());
            firstNameEntry.setText(dataManager.getFirstname());
            lastNameEntry.setText(dataManager.getLastName());
            emailEntry.setText(dataManager.getEmail());
            phoneNumberEntry.setText(dataManager.getPhoneNumber());
            schoolEntry.setText(dataManager.getEducation());
        } else {
            if(editTextsConfigured) {
                dataManager.setFirstName(firstNameEntry.getText().toString());
                dataManager.setLastName(lastNameEntry.getText().toString());
                dataManager.setEmail(emailEntry.getText().toString());
                dataManager.setPhoneNumber(phoneNumberEntry.getText().toString());
                dataManager.setEducation(schoolEntry.getText().toString());
            }

        }

    }
}
