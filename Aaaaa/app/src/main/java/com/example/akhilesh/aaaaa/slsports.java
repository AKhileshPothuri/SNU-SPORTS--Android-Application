package com.example.akhilesh.aaaaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ListView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.*;
public class slsports extends AppCompatActivity {
    String[] values = {"Basketball Boys", "Basketball Girls", "Tennis(Mix)", "VolleyBall", "Badminton Boys", "Badminton Girls", "Athletics", "Cricket", "Table Tennis boys", "Table Tennis Girls", "Chess", "Squash", "Power Lifting"};
    public static   String sport;
    ListView listView,listView1;
    Managers man;
    slplayerlist play;
    FirebaseDatabase firebaseDatabase;
    //   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jnews.retrieve());
    DatabaseReference db,db1;
    Boolean saved = null;
    ArrayList<String> list,list1;
    ArrayAdapter<String> adapter,adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slsports);
        listView = (ListView) findViewById(R.id.manager_list);
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(slsports.this, android.R.layout.simple_list_item_1, list);
        firebaseDatabase = FirebaseDatabase.getInstance();
        db = firebaseDatabase.getReference("Managers");



        final ListView listview = (ListView) findViewById(R.id.slsport_list);

        final ArrayList<String> listy = new ArrayList<String>();
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //db.child("highlights").orderByChild("timestamp").limitToLast(10);
                list.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    man = ds.getValue(Managers.class);
                    String check=jcatalogue.teamname;
                    String manname=man.getName();
                    String teamnames=man.getTeam();
                    if(teamnames.equals(check)){

                        list.add(manname);
                    }}

                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        for (int i = 0; i < values.length; ++i) {
            listy.add(values[i]);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, listy);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                Toast.makeText(jcatalogue.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                 sport=values[position];
//                if(sport.equals("Basketball Boys")){
//
                   Intent intent=new Intent(slsports.this,slplayers.class);
                    startActivity(intent);
//                }
//                else
//                {
//                    Intent intent=new Intent(slsports.this,snusports.class);
//                    startActivity(intent);
//
//                }
            }
        });

    }

    }
