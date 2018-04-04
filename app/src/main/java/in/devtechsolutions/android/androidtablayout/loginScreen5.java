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
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by aryamirshafii on 1/14/18.
 */

public class loginScreen5 extends Fragment {

    private TextView educationLoginLabel;
    private EditText educationLoginEntry;
    private dataController dataManager;
    private View view;


    @Nullable
    @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.educationloginscreen5 , container, false);
        educationLoginEntry = (EditText) view.findViewById(R.id.schoolLoginEntry);
        educationLoginLabel = (TextView) view.findViewById(R.id.schoolLoginLabel);
        educationLoginEntry.setText("Georgia Tech");
        configureViews();

        dataManager = new dataController(getContext());
        return view;
    }


    private void configureViews(){

        educationLoginEntry.requestFocus();


        educationLoginEntry.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    Log.d("Verbose", "Moving TO tab");
                    educationLoginLabel.requestFocus();

                    dataManager.setEducation(educationLoginEntry.getText().toString());
                    dataManager.setLoginComplete(true);


                    ((ViewGroup) educationLoginEntry.getParent()).removeView(educationLoginEntry);
                    ((ViewGroup) educationLoginLabel.getParent()).removeView(educationLoginLabel);

                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    Tab2Fragment tab2 = new Tab2Fragment();
                    ft.replace(R.id.loginScreen5, tab2);


                    ft.commit();


                    return true;
                }
                return false;
            }
        });



    }
}
