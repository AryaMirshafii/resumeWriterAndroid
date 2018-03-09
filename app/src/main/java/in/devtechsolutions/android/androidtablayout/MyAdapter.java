package in.devtechsolutions.android.androidtablayout;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.devtechsolutions.android.androidtablayout.R;

import static in.devtechsolutions.android.androidtablayout.R.color.courseColor;
import static in.devtechsolutions.android.androidtablayout.R.color.extraCurricularColor;
import static in.devtechsolutions.android.androidtablayout.R.color.experienceColor;
import static in.devtechsolutions.android.androidtablayout.R.color.skillColor;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;
        public TextView mTextView;
        public MyViewHolder(View v) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.card_view);
            mTextView = (TextView) v.findViewById(R.id.tv_text);

        }
        public void setColor(int colorCounter){
            ViewGroup.LayoutParams p = this.mCardView.getLayoutParams();
            if(colorCounter == 0){

                mCardView.setBackground(ContextCompat.getDrawable(mCardView.getContext(), R.drawable.internshipbackgroundcolor));
                mCardView.setElevation(500);


            }else if(colorCounter == 1){
                mCardView.setBackground(ContextCompat.getDrawable(mCardView.getContext(), R.drawable.skillbackgroundcolor));
                mCardView.setElevation(2);
            }else if(colorCounter == 2){
                mCardView.setBackground(ContextCompat.getDrawable(mCardView.getContext(), R.drawable.coursebackgroundcolor));
                mCardView.setElevation(1);

            } else if(colorCounter == 3){
                mCardView.setBackground(ContextCompat.getDrawable(mCardView.getContext(), R.drawable.extracurricularbackgroundcolor));
                mCardView.setElevation(2);

            }
            p.height= (int) (Resources.getSystem().getDisplayMetrics().heightPixels /11.7 * Resources.getSystem().getDisplayMetrics().density);
            mCardView.setLayoutParams(p);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    int viewCounter = 0;

    @Override public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        Log.d("Verbose", "the counter is" + viewCounter);

        // set the view's size, margins, paddings and layout parameters
        MyViewHolder viewHolder = new MyViewHolder(v);
        viewHolder.setColor(viewCounter);
        viewCounter++;
        return viewHolder;
    }

    int clickCounter = 0;
    @Override public void onBindViewHolder( final MyViewHolder holder, final int position) {
        holder.mTextView.setText(mDataset[position]);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValue = mDataset[position];
                Log.d("CardView", "CardView Clicked: " + currentValue);
                //RelativeLayout rLGreen = ((RelativeLayout) holder.mCardView.getParent());
                ViewGroup.LayoutParams p = holder.mCardView.getLayoutParams();



                if(clickCounter %2 == 0){
                    p.height= (int) (Resources.getSystem().getDisplayMetrics().heightPixels /4.15 * Resources.getSystem().getDisplayMetrics().density);

                } else {
                    p.height= (int) (Resources.getSystem().getDisplayMetrics().heightPixels /11.7 * Resources.getSystem().getDisplayMetrics().density);
                    Log.d("Verbose", "the height is is" +  p.height);
                }
                holder.mCardView.setLayoutParams(p);
                clickCounter++;


            }
        });




    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}