package com.example.akhilesh.admincheck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class teamdata extends AppCompatActivity {

    private Button but;
    private DatabaseReference db;
    private EditText name,teamy,pointsy;
    private Spinner sp;
    private String selecteditem,selecteditem1,leagueName;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teamdata);

        String[] arraySpinner = new String[]{
                "Cricket", "Basketball Boys", "Basketball Girls", "Football", "Tennis(Mix)", "VolleyBall", "Badminton Boys", "Badminton Girls", "Athletics", "Table Tennis boys", "Table Tennis Girls", "Chess", "Squash", "Power Lifting"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        String[] arraySpinner1 = new String[]{"Panthers","Bulls" ,"Phoenix","Falcons"       };
        Spinner s1 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter adapter1 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, arraySpinner1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter1);


        but = (Button) findViewById(R.id.save);
        name = (EditText) findViewById(R.id.playername);
        Spinner sp2=(Spinner)findViewById(R.id.spinner2);
        pointsy = (EditText) findViewById(R.id.points);
        sp = (Spinner) findViewById(R.id.spinner1);
//        String selecteditem;
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selecteditem = (String) parent.getItemAtPosition(position);
                // Notify the selected item text
//                Toast.makeText
//                        (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
//                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selecteditem1 = (String) parent.getItemAtPosition(position);
                // Notify the selected item text
//                Toast.makeText
//                        (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
//                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        sport=(EditText)findViewById(R.id.sports);
//        leagueID=(EditText)findViewById(R.id.leagueId);
        db = FirebaseDatabase.getInstance().getReference();
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String check = name.getText().toString();

String pointy=pointsy.getText().toString();
int pointies=Integer.valueOf(pointy);
                String check1 = name.getText().toString();

                member mem = new member();
                mem.setName(check1);
                mem.setSport(selecteditem);
mem.setPoints(pointies);
mem.setTeam(selecteditem1);
//                db.child("sports").push().setValue(mem);

                db.child("members").push().setValue(mem);


                finish();

            }
        });

//        but.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String check = name.getText().toString();
//                sport high = new sport();
//                high.setLeagueName(check);
//                high.setSports(selecteditem);
//
//                db.child("sports").push().setValue(high);
//
//
//                finish();
//
//            }
//        });

//        but.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                launchActivity();
//            }
//        });
//    }
//
//    private void launchActivity(){
//
//        Intent intent=new Intent(this,events.class);
//        startActivity(intent);        }
//
//


    }}
