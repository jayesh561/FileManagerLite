package com.epizy.ankurdhuriya.filemanager.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.epizy.ankurdhuriya.filemanager.R;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/*
 * Created by ankur on 23/06/18.
 */


public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        simulateDayNight(/* DAY */ 0);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .addItem(new Element().setTitle("Version 1.0"))
                .setDescription("Hi! It's me Ankur Dhuriya.")
                .addGroup("Connect with us")
                .addEmail("mail.ankurdhuriya@gmail.com")
                .addWebsite("http://ankurdhuriya.epizy.com/")
                .addTwitter("Kachua26")
                .addInstagram("haanjiankur")
                .addGitHub("haanjiankur")
                .create();

        setContentView(aboutPage);
    }





    void simulateDayNight(int currentSetting) {
        final int DAY = 0;
        final int NIGHT = 1;
        final int FOLLOW_SYSTEM = 3;

        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        if (currentSetting == DAY && currentNightMode != Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        } else if (currentSetting == NIGHT && currentNightMode != Configuration.UI_MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else if (currentSetting == FOLLOW_SYSTEM) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }


}
