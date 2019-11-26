package com.example.akhilesh.admincheck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class event_option extends AppCompatActivity {
    private Button event;
    private Button footbal;
    private Button basketbal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editevent_options);
        basketbal=(Button)findViewById(R.id.basketball);
        footbal =(Button)findViewById(R.id.football);
        footbal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity1();
            }
        });
        basketbal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity3();
            }
        });
    }         private void launchActivity1(){

        Intent intent=new Intent(this,football.class);
        startActivity(intent);        }

    private void launchActivity3(){

        Intent intent=new Intent(this,basketball.class);
        startActivity(intent);        }

}

