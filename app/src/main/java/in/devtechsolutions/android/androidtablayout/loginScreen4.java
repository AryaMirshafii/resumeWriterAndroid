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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by aryamirshafii on 1/14/18.
 */

public class loginScreen4 extends Fragment {
    private TextView phoneLoginLabel;
    private EditText phoneLoginEntry;

    private dataController dataManager;

    private View view;
    @Nullable
    @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.phoneloginscreen4 , container, false);
        phoneLoginEntry = (EditText) view.findViewById(R.id.phoneLoginEntry);
        phoneLoginLabel = (TextView) view.findViewById(R.id.phoneLoginLabel);
        dataManager = new dataController(getContext());
        configureViews();
        return view;
    }


    private void configureViews(){

        phoneLoginEntry.requestFocus();


        phoneLoginEntry.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    Log.d("Verbose", "Moving TO Login 5");



                    dataManager.setPhoneNumber(phoneLoginEntry.getText().toString());
                    ((ViewGroup) phoneLoginEntry.getParent()).removeView(phoneLoginEntry);
                    ((ViewGroup) phoneLoginLabel.getParent()).removeView(phoneLoginLabel);

                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    loginScreen5 login5 = new loginScreen5();
                    ft.replace(R.id.loginScreen4, login5);


                    ft.commit();


                    return true;
                }
                return false;
            }
        });



    }
}
