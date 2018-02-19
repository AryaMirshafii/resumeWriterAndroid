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

public class loginScreen3 extends Fragment {
    private TextView emailLoginLabel;
    private EditText emailLoginEntry;
    private dataController dataManager;
    private View view;
    @Nullable
    @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.emailloginscreen3 , container, false);
        view.requestFocus();

        emailLoginEntry = (EditText) view.findViewById(R.id.emailLoginEntry);
        emailLoginLabel = (TextView) view.findViewById(R.id.emailLoginLabel);


        dataManager = new dataController(getContext());

        configureViews();

        return view;
    }


    private void configureViews(){


        emailLoginEntry.requestFocus();


        emailLoginEntry.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    Log.d("Verbose", "Moving TO Login 4");



                    dataManager.setEmail(emailLoginEntry.getText().toString());
                    ((ViewGroup) emailLoginEntry.getParent()).removeView(emailLoginEntry);
                    ((ViewGroup) emailLoginLabel.getParent()).removeView(emailLoginLabel);


                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    loginScreen4 login4 = new loginScreen4();
                    ft.replace(R.id.loginScreen3, login4);


                    ft.commit();


                    return true;
                }
                return false;
            }
        });



    }
}
