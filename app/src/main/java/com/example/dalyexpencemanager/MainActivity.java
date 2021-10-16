package com.example.dalyexpencemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        progressBar = findViewById(R.id.prograsbarID);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();

                startApps();
            }
        });

        thread.start();
    }
    public void doWork(){
        for (progress=20; progress<=100; progress=progress+20){
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void startApps(){
        Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(intent);
        finish();
    }
}