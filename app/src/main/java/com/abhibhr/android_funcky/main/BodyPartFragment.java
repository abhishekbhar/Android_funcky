package com.abhibhr.android_funcky.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.abhibhr.android_funcky.R;
import com.abhibhr.android_funcky.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    private static final String TAG = "BODYPARTFRAGMENT";
    private static final String IMAGE_ID_LIST    = "image_ids";
    private static final String LIST_INDEX       = "list_index";


    private List<Integer> mImageIds;
    private int mImageIndex;
    public BodyPartFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mImageIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part,container,false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        if (mImageIds != null) {
            imageView.setImageResource(mImageIds.get(mImageIndex));
        } else {
          Log.d(TAG, "Image list is not set");
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mImageIndex < mImageIds.size() -1){
                    mImageIndex++;
                } else {
                    mImageIndex = 0;
                }
                imageView.setImageResource(mImageIds.get(mImageIndex));
            }
        });

        return rootView;
    }


    public void setImageIds(List<Integer> imageIds) {
        mImageIds = imageIds;
    }


    public void setImageIndex(int imageIndex) {
        mImageIndex = imageIndex;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        outState.putInt(LIST_INDEX, mImageIndex);
    }
}
