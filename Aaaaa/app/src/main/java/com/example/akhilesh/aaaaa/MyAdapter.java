package com.example.akhilesh.aaaaa;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    List<ScoreModel> listArray;
    ArrayList<Integer> images1,images2;
    Context context;

    //public OnMyAdapterItemClickListener onMyAdapterItemClickListener;


    public MyAdapter(ArrayList<Integer> images1,ArrayList<Integer> images2,List<ScoreModel> List,Context context){
        this.listArray = List;
        this.images1=images1;
        this.images2=images2;
        this.context=context;
        //this.onMyAdapterItemClickListener=onMyAdapterItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.score_model, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final ScoreModel data = listArray.get(position);
        int imageid1= images1.get(position);
        int imageid2 = images2.get(position);
        holder.team1.setText(data.getteam1());
        holder.team2.setText(data.getteam2());
        holder.team1_score.setText(String.valueOf(data.getteam1_score()));
        holder.team2_score.setText(String.valueOf(data.getteam2_score()));
        holder.leaguename.setText(data.getLeagueName());
        holder.sports.setText(data.getSports());
        holder.live_str.setText(String.valueOf(data.getLive_str()));
        holder.team1img.setImageResource(imageid1);
        holder.team2img.setImageResource(imageid2);
        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("jello",String.valueOf(data.getLive()));
                if(data.getSports().equals("Cricket")&&data.getLive_str().equals("Live")) {

                    Intent intent1 = new Intent(context, jscore_cricket.class);
                    Log.d("intentwala", "reached hereeeeeeeeeeeeeeeeeeee ");
                    intent1.putExtra("team1",data.getteam1());
                    intent1.putExtra("team2",data.getteam2());
                    context.startActivity(intent1);
                }
            }
        });
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //Ctrl + O
        TextView team1,team2,team1_score,team2_score,leaguename,sports,live_str;
        ImageView team1img,team2img;
        LinearLayout parentlayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            team1 = (TextView) itemView.findViewById(R.id.team1name);
            team2=(TextView) itemView.findViewById(R.id.team2name);
            team1_score= (TextView) itemView.findViewById(R.id.team1score);
            team2_score= (TextView) itemView.findViewById(R.id.team2score);
            leaguename = (TextView) itemView.findViewById(R.id.league_name);
            sports=(TextView) itemView.findViewById(R.id.sport_type);
            team1img=(ImageView) itemView.findViewById((R.id.team1img));
            team2img=(ImageView) itemView.findViewById((R.id.team2img));
            live_str=(TextView)itemView.findViewById((R.id.live_str));
            parentlayout=itemView.findViewById(R.id.clickable_outer);
        }
    }


    @Override
    public int getItemCount() {
        return listArray.size();
    }
}
