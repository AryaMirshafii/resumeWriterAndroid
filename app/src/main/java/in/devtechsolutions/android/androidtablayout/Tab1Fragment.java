package in.devtechsolutions.android.androidtablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by suraj on 23/6/17.
 */

public class Tab1Fragment extends Fragment {


    private WebView resumeWebview;
    private HorizontalScrollView resumeSelector;
    private pdfGenerator pdfManager;
    @Nullable private View view;

    public View onCreateView (final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_tab1, container, false);
        resumeWebview = (WebView) view.findViewById(R.id.resumeWebView);
        resumeSelector = (HorizontalScrollView) view.findViewById(R.id.resumeSelector);
        pdfManager = new pdfGenerator(getContext());
        this.loadResumes();
        this.loadIcons();
        resumeWebview.setInitialScale(140);
        resumeWebview.getSettings().setJavaScriptEnabled(true);
        //resumeWebview.loadUrl("file:///android_asset/resume1.html");
        resumeWebview.loadData(pdfManager.getResume1(), "text/html; charset=utf-8", "UTF-8");
        return view;
    }
    private void loadIcons(){

        ImageButton resume1 = (ImageButton)view.findViewById(R.id.resume1Icon);
        ImageButton resume2 = (ImageButton)view.findViewById(R.id.resume2Icon);
        ImageButton resume3 = (ImageButton)view.findViewById(R.id.resume3Icon);
        ImageButton resume4 = (ImageButton)view.findViewById(R.id.resume4Icon);
        resume1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                resumeWebview.loadData(pdfManager.getResume1(), "text/html; charset=utf-8", "UTF-8");

                //resumeWebview.loadUrl("file:///android_asset/resume1.html");


            }
        });
        resume2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                resumeWebview.loadData(pdfManager.getResume2(), "text/html; charset=utf-8", "UTF-8");
                //resumeWebview.loadUrl("file:///android_asset/resume2.html");

            }
        });
        resume3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                resumeWebview.loadData(pdfManager.getResume3(), "text/html; charset=utf-8", "UTF-8");
                //resumeWebview.loadUrl("file:///android_asset/resume3.html");

            }
        });

        resume4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                resumeWebview.loadData(pdfManager.getResume4(), "text/html; charset=utf-8", "UTF-8");
                resumeWebview.loadUrl("file:///android_asset/resume4.html");

            }
        });




    }

    private void setUpScrollView(){

    }

    private void loadResumes(){







    }
}
