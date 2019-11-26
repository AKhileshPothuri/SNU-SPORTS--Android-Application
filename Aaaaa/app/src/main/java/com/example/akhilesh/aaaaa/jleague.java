package com.example.akhilesh.aaaaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class jleague extends AppCompatActivity {
    String name;
    public static String pass;
    View myView;
    ListView listView;
    leaguelist league_list;
    FirebaseDatabase firebaseDatabase;
    //   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jnews.retrieve());
    DatabaseReference db;
    Boolean saved = null;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.league_layout);
        league_list = new leaguelist();
        listView = (ListView)findViewById(R.id.league_list);
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(jleague.this, android.R.layout.simple_list_item_1, list);


        firebaseDatabase = FirebaseDatabase.getInstance();
        db = firebaseDatabase.getReference("league");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //db.child("highlights").orderByChild("timestamp").limitToLast(10);
                list.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    league_list = ds.getValue(leaguelist.class);



                    list.add(league_list.getLeagueName());
                }

                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        pass= (String) listView.getItemAtPosition(position);
                     //   Toast.makeText( jleague.this, pass, Toast.LENGTH_SHORT ).show();
                        Intent intent=new Intent(jleague.this,pointstable.class);
                        startActivity(intent);

                    }
                });}


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
