package com.example.akhilesh.aaaaa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Belal on 2/23/2017.
 */

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.ViewHolder> {

    private Context context;
    private List<highlights> highlights_arr ;

    public MyAdapter3(Context context, List<highlights> uploads) {
        this.highlights_arr = uploads;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_model, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        highlights highlight = highlights_arr.get(position);

        holder.textViewhigh.setText(highlight.getHighlight());
      //  holder.sports.setText(highlight.getSport());
       // holder.leaguename.setText(highlight.getLeagueId());

        Glide.with(context).load(highlight.getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return highlights_arr.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewhigh,sports,leaguename;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewhigh = (TextView) itemView.findViewById(R.id.highlight);
            //sports = (TextView) itemView.findViewById(R.id.news_sport1);
          //  leaguename = (TextView) itemView.findViewById(R.id.news_league1);
            imageView = (ImageView) itemView.findViewById(R.id.new_img);
        }
    }
}
