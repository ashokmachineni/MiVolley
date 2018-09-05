package com.example.ashokmachineni.mivolley;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = "GalleryAct";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        String name = getIntent().getExtras().getString("rowname");


    }
}
