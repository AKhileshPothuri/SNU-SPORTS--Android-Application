package com.example.akhilesh.aaaaa;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class slplayers extends AppCompatActivity {

    View myView;
    ListView listView2,listView1;
    Managers man;
    slplayerlist play;
    FirebaseDatabase firebaseDatabase;
    //   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jnews.retrieve());
    DatabaseReference db,db1;
    Boolean saved = null;
    ArrayList<String> list2,list1;
    ArrayAdapter<String> adapter2,adapter1;
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slplayers);
        //     lv.setAdapter(adapter);
        //return myView;
        man = new Managers();
        play=new slplayerlist();
        listView1 = (ListView) findViewById(R.id.player_name);
        list1 = new ArrayList<>();
        adapter1 = new ArrayAdapter<String>(slplayers.this, android.R.layout.simple_list_item_1, list1);
        listView2 = (ListView) findViewById(R.id.player_points);
        list2 = new ArrayList<>();
        adapter2 = new ArrayAdapter<String>(slplayers.this, android.R.layout.simple_list_item_1, list2);


        firebaseDatabase = FirebaseDatabase.getInstance();
        db = firebaseDatabase.getReference("Managers");
        db1=firebaseDatabase.getReference("members");
        db1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //db.child("highlights").orderByChild("timestamp").limitToLast(10);
                list1.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    play = ds.getValue(slplayerlist.class);
                    String check=jcatalogue.teamname;
                    String playname=play.getName();
                    String teamnames=play.getTeam();
                    String sporty=slsports.sport;
                    String sportname=play.getSport();
                    if(teamnames.equals(check)&&sportname.equals(sporty)){

                        list1.add(playname);
                        list2.add(String.valueOf(play.getPoints()));
                    }}

                listView1.setAdapter(adapter1);
listView2.setAdapter(adapter2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
