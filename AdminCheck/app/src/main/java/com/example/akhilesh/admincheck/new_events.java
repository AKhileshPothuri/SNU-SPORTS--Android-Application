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

public class new_events extends AppCompatActivity {

    private Button but;
    private DatabaseReference db;
    private EditText name;
    private Spinner sp;
    private String selecteditem,leagueName;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);

        String[] arraySpinner = new String[]{
                "Cricket", "Basketball Boys", "Basketball Girls", "Football", "Tennis(Mix)", "VolleyBall", "Badminton Boys", "Badminton Girls", "Athletics", "Table Tennis boys", "Table Tennis Girls", "Chess", "Squash", "Power Lifting"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);


        but = (Button) findViewById(R.id.button8);
        name = (EditText) findViewById(R.id.textt);
        sp = (Spinner) findViewById(R.id.spinner);
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

//        sport=(EditText)findViewById(R.id.sports);
//        leagueID=(EditText)findViewById(R.id.leagueId);
        db = FirebaseDatabase.getInstance().getReference();
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check = name.getText().toString();

                leag leag = new leag();
                leag.setLeagueName(check);
                String check1 = name.getText().toString();
                sport sporty = new sport();
                sporty.setLeagueName(check1);
                sporty.setSports(selecteditem);

                db.child("sports").push().setValue(sporty);

                db.child("league").push().setValue(leag);


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
