package com.example.akhilesh.aaaaa;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class jscore extends Fragment {
    View myView;
    RecyclerView myrecyclerview;
    MyAdapter adapter;
    List<ScoreModel> listData;
    ArrayList<Integer> array_img1;
    String live_status;
    ArrayList<Integer> array_img2;
    FirebaseDatabase FBD;
    DatabaseReference DBR;
    ImageView team1img,team2img;
    private ProgressDialog progressDialog;
    public int bulls_num=R.drawable.bulls;
    public int panthers_num= R.drawable.panthers;
    public int falcons_num=R.drawable.falcons;
    public int phoenix_num=R.drawable.phoenix;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.score_layout, container, false);
       // int imageresource_bulls = getResources().getIdentifier(bulls_path,null,getActivity().getPackageName());
        myrecyclerview=(RecyclerView)myView.findViewById(R.id.myRecycler);
      //  final Bitmap bitmap= BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.bulls);
       // team1img.setImageBitmap(bitmap);
       // final Drawable res = getResources().getDrawable(imageresource_bulls);
        team2img=myView.findViewById(R.id.team2img);
        progressDialog = new ProgressDialog(getActivity());
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        FBD = FirebaseDatabase.getInstance();
        DBR= FBD.getReference("winners");
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        DBR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                listData = new ArrayList<ScoreModel>();
                array_img1=new ArrayList<Integer>();
                array_img2=new ArrayList<Integer>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    ScoreModel value = dataSnapshot1.getValue(ScoreModel.class);
                    ScoreModel fire = new ScoreModel();
                    String team1 = value.getteam1();
                    String team2 = value.getteam2();
                    if(team1.equals("Bulls")){
                        array_img1.add(bulls_num);
                    }
                    if(team1.equals("Panthers")){
                        array_img1.add(panthers_num);
                    }
                    if(team1.equals("Falcons")){
                        array_img1.add(falcons_num);
                    }
                    if(team1.equals("Phoenix")){
                        array_img1.add(phoenix_num);
                    }
                    if(team2.equals("Bulls")){
                        array_img2.add(bulls_num);
                    }
                    if(team2.equals("Panthers")){
                        array_img2.add(panthers_num);
                    }
                    if(team2.equals("Falcons")){
                        array_img2.add(falcons_num);
                    }
                    if(team2.equals("Phoenix")){
                        array_img2.add(phoenix_num);
                    }
                    int live = value.getLive();
                    fire.setLive(live);
                    if(live==0){
                        live_status="Match over";
                    }
                    if(live==1){
                        live_status="Live";
                    }
                    String leaguename=value.getLeagueName();
                    String sports=value.getSports();
                    int team1_score = value.getteam1_score();
                    int team2_score = value.getteam2_score();
                    fire.setLive_str(live_status);
                    fire.setteam1(team1);
                    fire.setteam2(team2);
                    fire.setteam1_score(team1_score);
                    fire.setteam2_score(team2_score);
                    fire.setLeagueName(leaguename);
                    fire.setSports(sports);
                    listData.add(fire);

                }
                Collections.reverse(listData);
                MyAdapter recyclerAdapter = new MyAdapter(array_img1, array_img2, listData,getActivity());
                myrecyclerview.setAdapter(recyclerAdapter);
                myrecyclerview.setItemAnimator( new DefaultItemAnimator());
            }
            @Override
            public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w("Hello", "Failed to read value.", error.toException());
                }


            });
//
//                array_img1=new ArrayList<Integer>();
//                array_img2=new ArrayList<Integer>();
//                listData = new ArrayList<ScoreModel>();
//                    ScoreModel fire = new ScoreModel();
//                    String team1 = "Bulls";
//                    String team2 = "Panthers";
//                    int team1_score = 34;
//                    int team2_score = 54;
//                     if(team1.equals("Bulls")){
//                        array_img1.add(bulls_num);
//                    }
//                    if(team1.equals("Panthers")){
//                        array_img1.add(panthers_num);
//                    }
//                    if(team1.equals("Falcons")){
//                        array_img1.add(falcons_num);
//                    }
//                    if(team1.equals("Phoenix")){
//                        array_img1.add(phoenix_num);
//                    }
//                    if(team2.equals("Bulls")){
//                        array_img2.add(bulls_num);
//                    }
//                    if(team2.equals("Panthers")){
//                        array_img2.add(panthers_num);
//                    }
//                    if(team2.equals("Falcons")){
//                        array_img2.add(falcons_num);
//                    }
//                    if(team2.equals("Phoenix")){
//                        array_img2.add(phoenix_num);
//                    }
//                    fire.setteam1(team1);
//                    fire.setteam2(team2);
//                    fire.setteam1_score(team1_score);
//                    fire.setteam2_score(team2_score);
//                    listData.add(fire);
//                    fire.setteam1("Panthers");
//                    fire.setteam2("Falcons");
//        if(team1.equals("Bulls")){
//                        array_img1.add(bulls_num);
//                    }
//                    if(team1.equals("Panthers")){
//                        array_img1.add(panthers_num);
//                    }
//                    if(team1.equals("Falcons")){
//                        array_img1.add(falcons_num);
//                    }
//                    if(team1.equals("Phoenix")){
//                        array_img1.add(phoenix_num);
//                    }
//                    if(team2.equals("Bulls")){
//                        array_img2.add(bulls_num);
//                    }
//                    if(team2.equals("Panthers")){
//                        array_img2.add(panthers_num);
//                    }
//                    if(team2.equals("Falcons")){
//                        array_img2.add(falcons_num);
//                    }
//                    if(team2.equals("Phoenix")){
//                        array_img2.add(phoenix_num);
//                    }
//                    fire.setteam1_score(566);
//                    fire.setteam2_score(32);
//                    listData.add(fire);
//        MyAdapter recyclerAdapter = new MyAdapter(array_img1, array_img2, listData,getActivity());
//        myrecyclerview.setAdapter(recyclerAdapter);
//        myrecyclerview.setItemAnimator( new DefaultItemAnimator());










        return myView;
    }
}




//    RecyclerView.LayoutManager LM = new LinearLayoutManager(getActivity().getApplicationContext());
//        myrecyclerview.setLayoutManager(LM);
//        myrecyclerview.setItemAnimator(new DefaultItemAnimator());
//        myrecyclerview.addItemDecoration(new DividerItemDecoration(getActivity.getApplicationContext(),LinearLayoutManager.VERTICAL));
//
//        listData= new ArrayList<>();
//        adapter=new MyAdapter(listData);
//        FDB=FirebaseDatabase.getInstance();