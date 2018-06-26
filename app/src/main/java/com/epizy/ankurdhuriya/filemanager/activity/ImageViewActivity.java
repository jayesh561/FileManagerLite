package com.epizy.ankurdhuriya.filemanager.activity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epizy.ankurdhuriya.filemanager.adapter.FullScreenImageAdapter;
import com.epizy.ankurdhuriya.filemanager.app.AppController;
import com.epizy.ankurdhuriya.filemanager.model.MediaFileListModel;
import com.epizy.ankurdhuriya.filemanager.R;

import java.io.File;
import java.util.ArrayList;

/*
 * Created by ankur on 23/06/18.
 */
public class ImageViewActivity extends AppCompatActivity {
    private ImageView imgBackArrow;
    int imagePosition;
    private FullScreenImageAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
        imgBackArrow= (ImageView) findViewById(R.id.id_back_arrow);
        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new FullScreenImageAdapter(ImageViewActivity.this, AppController.getInstance().getMediaFileListModeLArray());
        Intent intent = getIntent();
        imagePosition=intent.getIntExtra("imagePosition",0);
        viewPager.setAdapter(adapter);
        // displaying selected image first
        viewPager.setCurrentItem(imagePosition);
        imgBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
