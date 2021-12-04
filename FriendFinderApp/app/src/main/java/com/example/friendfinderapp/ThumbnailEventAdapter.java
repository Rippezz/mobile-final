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

import java.util.List;

public class ThumbnailEventAdapter extends RecyclerView.Adapter<ThumbnailEventAdapter.ThumbnailEventViewHolder> {
    private List<ThumbnailEvent> thumbnailEvents;

    public ThumbnailEventAdapter(List<ThumbnailEvent> thumbnailEvents) {
        this.thumbnailEvents = thumbnailEvents;
    }

    @NonNull
    @Override
    public ThumbnailEventAdapter.ThumbnailEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.event_thumbnail_item, parent, false);
        return new ThumbnailEventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThumbnailEventAdapter.ThumbnailEventViewHolder holder, int position) {
        holder.txt_thumbnail_event_name.setText(thumbnailEvents.get(position).getThumbnail_event_name());
        holder.txt_thumbnail_event_date.setText(thumbnailEvents.get(position).getThumbnail_event_data());
        holder.txt_category.setText(thumbnailEvents.get(position).getCategory());
        Glide.with(holder.itemView).load(ConfigurationAll.ImageURL + thumbnailEvents.get(position).getThumbnail_image()).into(holder.img_thumbnail_image);
//        holder.img_thumbnail_image.setImageResource(thumbnailEvents.get(position).getThumbnail_image());
    }

    @Override
    public int getItemCount() {
        return (thumbnailEvents != null) ? thumbnailEvents.size() : 0;
    }

    public static class ThumbnailEventViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_thumbnail_event_name, txt_thumbnail_event_date, txt_category;
        private ImageView img_thumbnail_image;

        public ThumbnailEventViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_thumbnail_event_name = itemView.findViewById(R.id.txt_thumbnail_event_name);
            txt_thumbnail_event_date = itemView.findViewById(R.id.txt_thumbnail_event_date);
            txt_category = itemView.findViewById(R.id.txt_category);
            img_thumbnail_image = itemView.findViewById(R.id.img_thumbnail_image);
        }
    }
}
