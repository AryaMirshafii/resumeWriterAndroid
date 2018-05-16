package in.devtechsolutions.android.androidtablayout;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.os.Bundle;
import android.os.Environment;
import android.print.PdfPrint;
import android.print.PrintAttributes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by suraj on 23/6/17.
 */

public class Tab1Fragment extends Fragment {


    private WebView resumeWebview;
    private HorizontalScrollView resumeSelector;
    private pdfGenerator pdfManager;
    private dataController dataManager;
    @Nullable private View view;

    public View onCreateView (final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_tab1, container, false);
        resumeWebview = (WebView) view.findViewById(R.id.resumeWebView);
        resumeSelector = (HorizontalScrollView) view.findViewById(R.id.resumeSelector);
        pdfManager = new pdfGenerator(getContext());
        dataManager = new dataController(getContext());
        //dataManager.addObserver(this);
        this.loadResumes();
        this.loadIcons();
        resumeWebview.setInitialScale(140);
        resumeWebview.getSettings().setJavaScriptEnabled(true);
        //resumeWebview.loadUrl("file:///android_asset/resume1.html");
        resumeWebview.loadData(pdfManager.getResume1(), "text/html; charset=utf-8", "UTF-8");
        ((MainActivity)getActivity()).initializeCredentials();







        return view;
    }





    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {
            System.out.println("RESUMEVIEW IS VISIBLE!!!");
            if(dataManager.getResumeNumber() == "1") {
                resumeWebview.loadData(pdfManager.getResume1(), "text/html; charset=utf-8", "UTF-8");
            } else if(dataManager.getResumeNumber() == "2") {
                resumeWebview.loadData(pdfManager.getResume2(), "text/html; charset=utf-8", "UTF-8");
            } else if(dataManager.getResumeNumber() == "3") {
                resumeWebview.loadData(pdfManager.getResume3(), "text/html; charset=utf-8", "UTF-8");
            } else if(dataManager.getResumeNumber() == "4") {
                resumeWebview.loadData(pdfManager.getResume4(), "text/html; charset=utf-8", "UTF-8");
            }
        }

    }



    private void loadIcons(){

        ImageButton resume1 = (ImageButton)view.findViewById(R.id.resume1Icon);
        ImageButton resume2 = (ImageButton)view.findViewById(R.id.resume2Icon);
        ImageButton resume3 = (ImageButton)view.findViewById(R.id.resume3Icon);
        ImageButton resume4 = (ImageButton)view.findViewById(R.id.resume4Icon);





        resume1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dataManager.setResumeNumber(1);
                resumeWebview.loadData(pdfManager.getResume1(), "text/html; charset=utf-8", "UTF-8");

                //resumeWebview.loadUrl("file:///android_asset/resume1.html");



                createWebPrintJob(resumeWebview);

                ((MainActivity)getActivity()).uploadResumeToDrive();


            }
        });
        resume2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dataManager.setResumeNumber(2);
                resumeWebview.loadData(pdfManager.getResume2(), "text/html; charset=utf-8", "UTF-8");
                //resumeWebview.loadUrl("file:///android_asset/resume2.html");



                createWebPrintJob(resumeWebview);

            }
        });
        resume3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dataManager.setResumeNumber(3);
                resumeWebview.loadData(pdfManager.getResume3(), "text/html; charset=utf-8", "UTF-8");
                //resumeWebview.loadUrl("file:///android_asset/resume3.html");


                createWebPrintJob(resumeWebview);
                ((MainActivity)getActivity()).uploadResumeToDrive();


            }
        });

        resume4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dataManager.setResumeNumber(4);
                resumeWebview.loadData(pdfManager.getResume4(), "text/html; charset=utf-8", "UTF-8");
                //resumeWebview.loadUrl("file:///android_asset/resume4.html");
                createWebPrintJob(resumeWebview);
                ((MainActivity)getActivity()).uploadResumeToDrive();

            }
        });

        //resumeWebview.setInitialScale(1);

        //resumeWebview.getSettings().setUseWideViewPort(true);
        //resumeWebview.getSettings().setLoadWithOverviewMode(true);



        //resumeWebview.getSettings().setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
        //resumeWebview.getSettings().setLoadWithOverviewMode(true);
        //resumeWebview.getSettings().setUseWideViewPort(true);
        //resumeWebview.getSettings().setJavaScriptEnabled(true);

        WebSettings settings = resumeWebview.getSettings();
        settings.setBuiltInZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setLightTouchEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);








    }




    private void createWebPrintJob(WebView webView) {
        String jobName = getString(R.string.app_name) + " Document";
        PrintAttributes attributes = new PrintAttributes.Builder()
                .setMediaSize(PrintAttributes.MediaSize.ISO_A4)
                .setResolution(new PrintAttributes.Resolution("pdf", "pdf", 1200, 1200))
                .setMinMargins(PrintAttributes.Margins.NO_MARGINS).build();
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM + "/PDFTest/");
        PdfPrint pdfPrint = new PdfPrint(attributes);
        pdfPrint.print(webView.createPrintDocumentAdapter(jobName), path, "outputttttttt_" + System.currentTimeMillis() + ".pdf");
        dataManager.setFilePath(path.listFiles()[1].getPath());
        System.out.println("The file paaaaathh is " + path.listFiles()[1].getPath());
    }


    private void setUpScrollView(){

    }

    private void loadResumes(){







    }
}
