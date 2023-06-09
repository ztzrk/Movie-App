package com.ztzrk.h071211021_finalmobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ztzrk.h071211021_finalmobile.R;
import com.ztzrk.h071211021_finalmobile.model.MovieResponse;
import com.ztzrk.h071211021_finalmobile.model.TvResponse;

import java.util.ArrayList;


public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ViewHolder> {

    private ArrayList<TvResponse> tvs;
    public TvAdapter(ArrayList<TvResponse> tvs) {
        this.tvs = tvs;
    }

    @NonNull
    @Override
    public TvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new TvAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.ViewHolder holder, int position) {
        TvResponse movie = tvs.get(position);
        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w500"+movie.getPosterPath())
                .into(holder.ivPostImg);
        holder.tvTitle.setText(movie.getName());
    }

    @Override
    public int getItemCount() {
        return tvs.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private ImageView ivPostImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            ivPostImg = itemView.findViewById(R.id.iv_item_image);
        }
    }
}