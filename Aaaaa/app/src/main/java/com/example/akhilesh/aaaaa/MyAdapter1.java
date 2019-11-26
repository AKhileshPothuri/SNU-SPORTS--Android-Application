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

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder>{
    List<Batsman_Model> listArray;




    public MyAdapter1(List<Batsman_Model> List){
        this.listArray = List;
        //this.onMyAdapterItemClickListener=onMyAdapterItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.batsman_model, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Batsman_Model data = listArray.get(position);
        holder.batsman_name.setText(String.valueOf(data.getBatsman_name()));
       // Log.d(TAG, "onBindViewHolder: done till here");
        holder.value_runs.setText(String.valueOf(data.getValue_runs()));
        holder.value_balls.setText(String.valueOf(data.getValue_balls()));
        holder.value_4s.setText(String.valueOf(data.getValue_4s()));
        holder.value_6s.setText(String.valueOf(data.getValue_6s()));
        holder.value_sr.setText(String.valueOf(data.getValue_sr()));

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //Ctrl + O
        TextView batsman_name,value_runs,value_balls,value_4s,value_6s,value_sr;


        public MyViewHolder(View itemView) {
            super(itemView);
             batsman_name = (TextView)itemView.findViewById(R.id.batsman_name);
            value_runs = (TextView) itemView.findViewById(R.id.value_runs);
            value_balls = (TextView) itemView.findViewById(R.id.value_balls);
            value_4s = (TextView) itemView.findViewById(R.id.value_4s);
            value_6s = (TextView) itemView.findViewById(R.id.value_6s);
            value_sr = (TextView) itemView.findViewById(R.id.value_sr);
        }
    }


    @Override
    public int getItemCount() {
        return listArray.size();
    }
}




























//package com.example.akhilesh.aaaaa;
//
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import android.app.Activity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//public class CustomList extends ArrayAdapter<String>{
//
//    private final Activity context;
//    private final String[] web;
//    public CustomList(Activity context,
//                      String[] web) {
//        super(context, R.layout.batsman_model, web);
//        this.context = context;
//        this.web = web;
//
//    }
//    @Override
//    public View getView(int position, View view, ViewGroup parent) {
//        LayoutInflater inflater = context.getLayoutInflater();
//        View itemView= inflater.inflate(R.layout.batsman_model, null, true);
//        TextView batsman_name = (TextView) itemView.findViewById(R.id.batsman_name);
//        TextView value_runs = (TextView) itemView.findViewById(R.id.value_runs);
//        TextView value_4s = (TextView) itemView.findViewById(R.id.value_4s);
//        TextView value_6s = (TextView) itemView.findViewById(R.id.value_6s);
//        TextView value_sr = (TextView) itemView.findViewById(R.id.value_sr);
//        batsman_name.setText(web[position]);
//        value_runs.setText(web[position]);
//        value_4s.setText(web[position]);
//        value_6s.setText(web[position]);
//        value_sr.setText(web[position]);
//
//
//        return itemView;
//    }
//}
