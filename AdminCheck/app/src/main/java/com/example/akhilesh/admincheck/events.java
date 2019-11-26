package com.example.akhilesh.admincheck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class events extends AppCompatActivity {
 private Button add_event;
 private Button edit_event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);
        edit_event=(Button)findViewById(R.id.edit_event) ;

        add_event = (Button) findViewById(R.id.new_event);
        add_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity();
            }
        });
        edit_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity1();
            }
        });
    }        private void launchActivity(){

        Intent intent=new Intent(this,new_events.class);
        startActivity(intent);        }
    private void launchActivity1(){

        Intent intent=new Intent(this,event_option.class);
        startActivity(intent);        }


    }

