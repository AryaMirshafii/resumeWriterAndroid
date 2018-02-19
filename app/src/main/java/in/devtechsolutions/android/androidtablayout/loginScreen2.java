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

public class loginScreen2 extends Fragment {
    private TextView lastNameLoginLabel;
    private EditText lastNameLoginEntry;
    private dataController dataManager;

    private View view;
    @Nullable
    @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.lastnameloginscreen2 , container, false);
        view.requestFocus();
        lastNameLoginEntry = (EditText) view.findViewById(R.id.lastNameLoginEntry);
        lastNameLoginLabel = (TextView) view.findViewById(R.id.lastnameLoginLabel);

        dataManager = new dataController(getContext());
        /**

         */
        configureViews();
        return view;
    }


    private void configureViews(){


        lastNameLoginEntry.requestFocus();
        lastNameLoginEntry.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    Log.d("Verbose", "Moving TO Login 3");

                    dataManager.setLastName(lastNameLoginEntry.getText().toString());

                    ((ViewGroup) lastNameLoginEntry.getParent()).removeView(lastNameLoginEntry);
                    ((ViewGroup) lastNameLoginLabel.getParent()).removeView(lastNameLoginLabel);

                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    loginScreen3 login3 = new loginScreen3();
                    ft.replace(R.id.loginScreen2, login3);


                    ft.commit();


                    return true;
                }
                return false;
            }
        });



    }
}
