package in.devtechsolutions.android.androidtablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by aryamirshafii on 1/14/18.
 */

public class loginScreen1 extends Fragment {
    private TextView firstnameLabelLogin;
    private EditText firstnameLoginEntry;
    private dataController dataManager;
    private View view;

    //stuff for main view
    private  Button addItemButton;
    private  Button saveObjectiveButton;

    private View backgroundView;

    private  EditText objectiveEntry;


    @Nullable
    @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.firstnameloginscreen1 , container, false);
        view.requestFocus();
        firstnameLoginEntry = (EditText) view.findViewById(R.id.firstNameLoginEntry);
        firstnameLabelLogin = (TextView) view.findViewById(R.id.firstnameLoginLabel);

        dataManager = new dataController(getContext());

        if(dataManager.getLoginComplete()){
            view = inflater.inflate(R.layout.fragment_tab2, container, false);
            bypassLoginAndConfigure();
        }else {

            configureViews();
        }





        /**

         */

        return view;
    }
    private void configureViews(){
        Log.d("Verbose", "Moving TO Login 2");
        firstnameLoginEntry.requestFocus();
        firstnameLoginEntry.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER
                        || actionId == EditorInfo.IME_ACTION_DONE) {
                    // Do your action

                    dataManager.setFirstName(firstnameLoginEntry.getText().toString());
                    ((ViewGroup) firstnameLoginEntry.getParent()).removeView(firstnameLoginEntry);
                    ((ViewGroup) firstnameLabelLogin.getParent()).removeView(firstnameLabelLogin);
                    Log.d("Verbose", "Moving TO Login 2");
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    loginScreen2 login2 = new loginScreen2();
                    ft.replace(R.id.loginScreen1, login2);
                    //((ViewGroup) firstNameEntry.getParent()).removeView(firstNameEntry);

                    ft.commit();
                    return true;
                }
                return false;
            }
        });





    }



    private void bypassLoginAndConfigure(){
        objectiveEntry= (EditText) view.findViewById(R.id.objectiveEntry);

        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(getContext().INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(objectiveEntry.getWindowToken(), 0);
        backgroundView = view.findViewById(R.id.backgroundView);
        backgroundView.setFocusableInTouchMode(true);
        backgroundView.requestFocus();
        addItemButton = (Button)view.findViewById(R.id.addItemButton);
        saveObjectiveButton = (Button)view.findViewById(R.id.saveObjectiveButton);
        addItemButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                editScreen llf = new editScreen();
                ft.replace(R.id.screen2, llf);

                ((ViewGroup) addItemButton.getParent()).removeView(addItemButton);
                ((ViewGroup) saveObjectiveButton.getParent()).removeView(saveObjectiveButton);
                ft.commit();



            }
        });


        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        MyAdapter adapter = new MyAdapter(new String[]{"Internship & Job Experience", "Skills", "Courses", "Extracurriculars"});
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);


        objectiveEntry.setText(dataManager.getObjective());
        objectiveEntry.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    Log.d("Verbose", "IT IS WORKING");


                    return true;
                }
                return false;
            }
        });




        saveObjectiveButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                dataManager.setObjective(objectiveEntry.getText().toString());
                Log.d("Verbose", "Saved Objective!");
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(getContext().INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(objectiveEntry.getWindowToken(), 0);



            }
        });
    }
}
