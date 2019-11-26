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

import static android.content.ContentValues.TAG;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder>{
    List<Bowler_Model> listArray;




    public MyAdapter2(List<Bowler_Model> List){
        this.listArray = List;
        //this.onMyAdapterItemClickListener=onMyAdapterItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bowler_model, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Bowler_Model data = listArray.get(position);
        holder.bowler_name.setText(String.valueOf(data.getBowler_name()));
        // Log.d(TAG, "onBindViewHolder: done till here");
        holder.bvalue_runs.setText(String.valueOf(data.getBvalue_runs()));
        holder.bvalue_balls.setText(String.valueOf(data.getBvalue_balls()));
        holder.bvalue_wicket.setText(String.valueOf(data.getBvalue_wicket()));
        holder.bvalue_extra.setText(String.valueOf(data.getBvalue_extra()));
        holder.bvalue_inning.setText(String.valueOf(data.getBvalue_inning()));

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //Ctrl + O
        TextView bowler_name,bvalue_runs,bvalue_balls,bvalue_wicket,bvalue_extra,bvalue_inning;


        public MyViewHolder(View itemView) {
            super(itemView);
            bowler_name = (TextView)itemView.findViewById(R.id.bowler_name);
            bvalue_runs = (TextView) itemView.findViewById(R.id.bvalue_runs);
            bvalue_balls = (TextView) itemView.findViewById(R.id.bvalue_balls);
            bvalue_wicket = (TextView) itemView.findViewById(R.id.bvalue_wicket);
            bvalue_extra = (TextView) itemView.findViewById(R.id.bvalue_extra);
            bvalue_inning = (TextView) itemView.findViewById(R.id.bvalue_inning);
        }
    }


    @Override
    public int getItemCount() {
        return listArray.size();
    }
}

























