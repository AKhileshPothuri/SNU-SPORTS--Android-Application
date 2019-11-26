package com.example.akhilesh.admincheck;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class football extends AppCompatActivity {
    int scoreTemA = 0;
    int scoreTemB = 0,a=1;
    winners high;
    private Button b1,b2,b3,b4,b5,b6,b7;
    private DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.football);

        b1=(Button)findViewById(R.id.team_a_one_score_f);
        b4=(Button)findViewById(R.id.team_b_one_score_f);
        b7=(Button)findViewById(R.id.resetButton_f);
 TextView teamA=findViewById(R.id.team1name_f);
        TextView teamB=findViewById(R.id.team2name_f);
        teamA.setText("Bulls");
        teamB.setText("Falcons");db= FirebaseDatabase.getInstance().getReference();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAOneScore();
                high = new winners();
                db = FirebaseDatabase.getInstance().getReference("winners");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {

                            high = ds.getValue(winners.class);
                            if(high.getLive()==1 && high.getSports().equals("football") && high.getTeam1().equals("Bulls") && high.getTeam2().equals("Falcons") && a==1){
                                high.setTeam1_score(scoreTemA);
                                high.setTeam2_score(scoreTemB);
                                high.setLive(1);

                                high.setLeagueName("SNUSL_2018");
                                high.setSports("football");
                                high.setTeam1("Bulls");
                                high.setTeam2("Falcons");
                                a--;
                                db.child(ds.getKey()).setValue(null);

                                db = FirebaseDatabase.getInstance().getReference();
                                db.child("winners").push().setValue(high);
                            }

                        }
                        a++;

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

//                high.setHighlight(highlight);
//                high.setLeagueId(leagueId);
//                high.setSports(sports);
//                if(a==1) {
//                    db = FirebaseDatabase.getInstance().getReference();
//                    db.child("winners").push().setValue(high);
//                }
//                a=1;


            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBOneScore();
                high = new winners();
                db = FirebaseDatabase.getInstance().getReference("winners");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {

                            high = ds.getValue(winners.class);
                            if(high.getLive()==1 && high.getSports().equals("football") && high.getTeam1().equals("Bulls") && high.getTeam2().equals("Falcons") && a==1){
                                high.setTeam1_score(scoreTemA);
                                high.setTeam2_score(scoreTemB);
                                high.setLive(1);

                                high.setLeagueName("SNUSL_2018");
                                high.setSports("football");
                                high.setTeam1("Bulls");
                                high.setTeam2("Falcons");
                                a--;
                                db.child(ds.getKey()).setValue(null);

                                db = FirebaseDatabase.getInstance().getReference();
                                db.child("winners").push().setValue(high);
                            }

                        }
                        a++;

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

//                high.setHighlight(highlight);
//                high.setLeagueId(leagueId);
//                high.setSports(sports);
//                if(a==1) {
//                    db = FirebaseDatabase.getInstance().getReference();
//                    db.child("winners").push().setValue(high);
//                }
//                a=1;


            }
        });


        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // teamAOneScore();
                high = new winners();
                a=1;
                db = FirebaseDatabase.getInstance().getReference("winners");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {

                            high = ds.getValue(winners.class);
                            if(high.getLive()==1 && high.getSports().equals("football") && high.getTeam1().equals("Bulls") && high.getTeam2().equals("Falcons")&& a==1){
                                high.setTeam1_score(scoreTemA);high.setTeam1_score(scoreTemA);
                                high.setTeam2_score(scoreTemB);
                                high.setLive(0);
                                high.setLeagueName("SNUSL_2018");
                                high.setSports("football");
                                high.setTeam1("Bulls");
                                high.setTeam2("Falcons");
                                a--;
                                db.child(ds.getKey()).setValue(null);
                                scoreTemA=0;
                                scoreTemB=0;
                                db = FirebaseDatabase.getInstance().getReference();
                                db.child("winners").push().setValue(high);
                                finish();                  }
                        }
//                        a++;

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

//                high.setHighlight(highlight);
//                high.setLeagueId(leagueId);
//                high.setSports(sports);
//                if(a==1) {
//                    db = FirebaseDatabase.getInstance().getReference();
//                    db.child("winners").push().setValue(high);
//                }
//                a=0;

            }

        });
    }

    public void teamAOneScore() {

        scoreTemA = scoreTemA + 1;
        a=1;
        displayForTeamA(scoreTemA);
    }

    public void teamATwoScore() {
        scoreTemA = scoreTemA + 2;
        a=1;
        displayForTeamA(scoreTemA);
    }

    public void teamAThreeScore() {
        scoreTemA = scoreTemA + 3;
        a=1;
        displayForTeamA(scoreTemA);
    }

    private void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText("" + score);
    }
    /*
     * Team A Code finish
     * */

    /*
     * Team B Code Started
     * */
    public void teamBOneScore() {
        scoreTemB = scoreTemB + 1;
        a=1;
        displayForTeamB(scoreTemB);
    }

    public void teamBTwoScore() {
        scoreTemB = scoreTemB + 2;
        a=1;
        displayForTeamB(scoreTemB);
    }

    public void teamBThreeScore() {
        scoreTemB = scoreTemB + 3;
        a=1;
        displayForTeamB(scoreTemB);
    }

    private void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}