package com.example.akhilesh.aaaaa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class pointstable extends AppCompatActivity {


    String name;
    View myView;
    ListView listView,listView1;
    points points_table;
    FirebaseDatabase firebaseDatabase;
    //   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jnews.retrieve());
    DatabaseReference db;
    Boolean saved = null;
    ArrayList<String> list,list1;
    ArrayAdapter<String> adapter,adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pointstable);
        points_table=new points();
        listView = (ListView)findViewById(R.id.pointslist);
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(pointstable.this, android.R.layout.simple_list_item_1, list);
        listView1 = (ListView)findViewById(R.id.teams);
        list1 = new ArrayList<>();
        adapter1 = new ArrayAdapter<String>(pointstable.this, android.R.layout.simple_list_item_1, list1);


        firebaseDatabase = FirebaseDatabase.getInstance();
        db = firebaseDatabase.getReference("points");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //db.child("highlights").orderByChild("timestamp").limitToLast(10);
                list.clear();list1.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                points_table = ds.getValue(points.class);
String checker=points_table.getLeagueName();
if(checker.equalsIgnoreCase(jleague.pass)) {
    list.add(String.valueOf(points_table.getTeam_score()));
    list1.add(points_table.getTeam());
}               }

                listView.setAdapter(adapter);
 listView1.setAdapter(adapter1);           }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
