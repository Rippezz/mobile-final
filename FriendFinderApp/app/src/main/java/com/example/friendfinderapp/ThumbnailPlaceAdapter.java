package com.example.friendfinderapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.friendfinderapp.Constants.ConfigurationAll;

import java.util.ArrayList;
import java.util.List;

public class ThumbnailPlaceAdapter extends RecyclerView.Adapter<ThumbnailPlaceAdapter.ThumbnailPlaceViewHolder> {
    private List<ThumbnailPlace> thumbnailPlaces;

    public ThumbnailPlaceAdapter(List<ThumbnailPlace> thumbnailPlaces) {
        this.thumbnailPlaces = thumbnailPlaces;
    }

    @NonNull
    @Override
    public ThumbnailPlaceAdapter.ThumbnailPlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.place_thumbnail_item, parent, false);
        return new ThumbnailPlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThumbnailPlaceAdapter.ThumbnailPlaceViewHolder holder, int position) {
        holder.txt_thumbnail_place_name.setText(thumbnailPlaces.get(position).getThumbnail_place_name());
        holder.txt_thumbnail_place_price.setText("IDR " + String.valueOf(thumbnailPlaces.get(position).getThumbnail_place_price()) + "/Jam");
        holder.txt_thumbnail_place_road.setText(thumbnailPlaces.get(position).getThumbnail_place_road());
        Glide.with(holder.itemView)
                .load(ConfigurationAll.ImageURL + thumbnailPlaces.get(position).getThumbnail_place_image())
                .into(holder.img_thumbnail_place_image);
//        holder.img_thumbnail_place_image.setImageResource(thumbnailPlaces.get(position).getThumbnail_place_image());
    }

    @Override
    public int getItemCount() {
        return (thumbnailPlaces != null) ? thumbnailPlaces.size() : 0;
    }

    public static class ThumbnailPlaceViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_thumbnail_place_name, txt_thumbnail_place_road, txt_thumbnail_place_price;
        private ImageView img_thumbnail_place_image;

        public ThumbnailPlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_thumbnail_place_name = itemView.findViewById(R.id.txt_thumbnail_place_name);
            txt_thumbnail_place_price = itemView.findViewById(R.id.txt_thumbnail_place_price);
            txt_thumbnail_place_road = itemView.findViewById(R.id.txt_thumbnail_place_road);
            img_thumbnail_place_image = itemView.findViewById(R.id.img_thumbnail_place_image);
        }
    }
}
