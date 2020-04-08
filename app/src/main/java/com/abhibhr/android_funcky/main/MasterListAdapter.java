package com.abhibhr.android_funcky.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class MasterListAdapter extends BaseAdapter {


    private final Context mContext;
    private List<Integer> mImageIds;

    /**
     * Constructor method
     * @param imageIds The list of images to display
     */
    public MasterListAdapter(Context context, List<Integer> imageIds){
        mContext = context;
        mImageIds = imageIds;
    }



    /**
     *  Returns the number of items the adapter will display
     */
    @Override
    public int getCount() {
        return mImageIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // If the view is not recycled, this creates a new ImageView to hold an image
            imageView = new ImageView(mContext);

            // Define the layout parameters
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mImageIds.get(position));
        return imageView;
    }
}
