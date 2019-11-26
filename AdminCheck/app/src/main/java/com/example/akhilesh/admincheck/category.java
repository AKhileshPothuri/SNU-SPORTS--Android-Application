package com.example.akhilesh.admincheck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class category extends AppCompatActivity {
    private Button event;
    private Button catalogue;
    private Button highlight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        highlight=(Button)findViewById(R.id.highlightbutton);
        event =(Button)findViewById(R.id.event_button);
        catalogue = (Button) findViewById(R.id.catalogue_button);
        catalogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity();
            }
        });
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity1();
            }
        });
        highlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity3();
            }
        });
    }        private void launchActivity(){

            Intent intent=new Intent(this, com.example.akhilesh.admincheck.catalogue.class);
            startActivity(intent);        }
    private void launchActivity1(){

        Intent intent=new Intent(this,events.class);
        startActivity(intent);        }

    private void launchActivity3(){

        Intent intent=new Intent(this,add_high.class);
        startActivity(intent);        }

    }

