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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


import com.loopeer.cardstack.CardStackView;

import java.util.Arrays;


/**
 * Created by suraj on 23/6/17.
 */

public class Tab2Fragment extends Fragment {
    private  dataController dataManager;
    private  Button addItemButton;
    private  Button saveObjectiveButton;

    private View backgroundView;
    private View view;
    private  EditText objectiveEntry;

    @Nullable
    @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        dataManager = new dataController(getContext());
        Log.d("Verbose", "zda value is " + dataManager.getLoginComplete());
        view = inflater.inflate(R.layout.fragment_tab2, container, false);

        view.requestFocus();
        configureSubViews();


        
        return view;
    }

    private void configureSubViews(){
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
