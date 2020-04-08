package com.abhibhr.android_funcky.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.abhibhr.android_funcky.R;
import com.abhibhr.android_funcky.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (savedInstanceState == null){
            BodyPartFragment head = new BodyPartFragment();
            head.setImageIds(AndroidImageAssets.getHeads());
            head.setImageIndex(bundle.getInt("headIndex"));
            BodyPartFragment body = new BodyPartFragment();
            body.setImageIds(AndroidImageAssets.getBodies());
            body.setImageIndex(bundle.getInt("bodyIndex"));
            BodyPartFragment leg  = new BodyPartFragment();
            leg.setImageIds(AndroidImageAssets.getLegs());
            leg.setImageIndex(bundle.getInt("legIndex"));
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,head)
                    .replace(R.id.fragment_container2,body)
                    .replace(R.id.fragment_container3,leg)
                    .commit();
        }

    }
}
