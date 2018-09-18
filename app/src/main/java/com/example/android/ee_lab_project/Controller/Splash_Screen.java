package com.example.android.ee_lab_project.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.ee_lab_project.R;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        Thread timer=new Thread()
        {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                finally
                {
                    Intent i=new Intent(Splash_Screen.this,logIn_main_page_activity.class);
                    finish();
                    startActivity(i);
                }
            }
        };
        timer.start();
    }
}
