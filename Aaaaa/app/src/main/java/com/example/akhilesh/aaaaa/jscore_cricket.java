package com.example.akhilesh.aaaaa;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class jscore_cricket extends AppCompatActivity {
    RecyclerView myrecyclerview,myrecyclerview1;
    MyAdapter1 adapter,adapter1;
    List<Batsman_Model> listData;
    List<Bowler_Model> listData1;
    FirebaseDatabase FBD;
    DatabaseReference DBR,DBR1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scorecard_cricket);
        String team1,team2;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                team1= null;
                team2=null;
            } else {
                team1= extras.getString("team1");
                team2=extras.getString("team2");
            }
        } else {
            team1= (String) savedInstanceState.getSerializable("team1");
            team2=(String)savedInstanceState.getSerializable("team2");
        }
        TextView team1_txtview= findViewById(R.id.team1name_score);
        team1_txtview.setText(team1);
        TextView team2_txtview= findViewById(R.id.team2name_score);
        team2_txtview.setText(team2);
        ImageView img1 = findViewById(R.id.team1img_score);
        ImageView img2 = findViewById(R.id.team2img_score);
        if(team1.equals("Bulls")){
            img1.setImageResource(R.drawable.bulls);
        }
        if(team1.equals("Panthers")){
            img1.setImageResource(R.drawable.panthers);
        }
        if(team1.equals("Falcons")){
            img1.setImageResource(R.drawable.falcons);
        }
        if(team1.equals("Phoenix")){
            img1.setImageResource(R.drawable.phoenix);
        }
        if(team2.equals("Bulls")){
            img2.setImageResource(R.drawable.bulls);
        }
        if(team2.equals("Panthers")){
            img2.setImageResource(R.drawable.panthers);
        }
        if(team2.equals("Falcons")){
            img2.setImageResource(R.drawable.falcons);
        }
        if(team2.equals("Phoenix")){
            img2.setImageResource(R.drawable.phoenix);
        }


        myrecyclerview=(RecyclerView)findViewById(R.id.recycler_batting);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        myrecyclerview1=(RecyclerView)findViewById(R.id.recycler_bowling);
        myrecyclerview1.setLayoutManager(new LinearLayoutManager(this));
        FBD = FirebaseDatabase.getInstance();
        DBR= FBD.getReference("batting");

        DBR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listData = new ArrayList<Batsman_Model>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    Batsman_Model value = dataSnapshot1.getValue(Batsman_Model.class);
                    Batsman_Model fire = new Batsman_Model();
                    String batsman_name = value.getBatsman_name();
                    int value_runs = value.getValue_runs();
                    int value_balls = value.getValue_balls();
                    int value_4s = value.getValue_4s();
                    int value_6s = value.getValue_6s();
                    int value_sr = value.getValue_sr();
                    fire.setBatsman_name(batsman_name);
                    fire.setValue_4s(value_4s);
                    fire.setValue_runs(value_runs);
                    fire.setValue_balls(value_balls);
                    fire.setValue_6s(value_6s);
                    fire.setValue_sr(value_sr);
                    listData.add(fire);

                }
                MyAdapter1 recyclerAdapter = new MyAdapter1(listData);
                myrecyclerview.setAdapter(recyclerAdapter);
                myrecyclerview.setItemAnimator( new DefaultItemAnimator());
            }
            @Override
            public void onCancelled(DatabaseError error) {

                }


            });


        DBR1= FBD.getReference("bowling");

        DBR1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listData1 = new ArrayList<Bowler_Model>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    Bowler_Model value = dataSnapshot1.getValue(Bowler_Model.class);
                    Bowler_Model fire = new Bowler_Model();
                    String bowler_name = value.getBowler_name();
                    int bvalue_runs = value.getBvalue_runs();
                    int bvalue_balls = value.getBvalue_balls();
                    int bvalue_extra = value.getBvalue_extra();
                    int bvalue_wicket = value.getBvalue_wicket();
                    int bvalue_inning = value.getBvalue_inning();
                    fire.setBowler_name(bowler_name);
                    fire.setBvalue_extra(bvalue_extra);
                    fire.setBvalue_runs(bvalue_runs);
                    fire.setBvalue_balls(bvalue_balls);
                    fire.setBvalue_wicket(bvalue_wicket);
                    fire.setBvalue_inning(bvalue_inning);
                    listData1.add(fire);

                }
                MyAdapter2 recyclerAdapter1 = new MyAdapter2(listData1);
                myrecyclerview1.setAdapter(recyclerAdapter1);
                myrecyclerview1.setItemAnimator( new DefaultItemAnimator());
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }













        });





    }



}
