package in.devtechsolutions.android.androidtablayout;

import android.content.Context;
import android.util.Log;
import android.widget.HorizontalScrollView;

public class myHorizontalScrollView extends HorizontalScrollView {

    public myHorizontalScrollView(Context context) {
        super(context);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        // TODO Auto-generated method stub
        Log.i("Verbose", "X from ["+oldl+"] to ["+l+"]");
        super.onScrollChanged(l, t, oldl, oldt);
    }

}