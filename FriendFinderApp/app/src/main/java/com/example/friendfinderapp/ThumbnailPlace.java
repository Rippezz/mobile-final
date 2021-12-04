package com.example.friendfinderapp;

public class ThumbnailPlace {
    private String thumbnail_place_name, thumbnail_place_road, thumbnail_place_image;
    private int id, thumbnail_place_price;

    public ThumbnailPlace(String thumbnail_place_name, String thumbnail_place_road, String thumbnail_place_image, int id, int thumbnail_place_price) {
        this.thumbnail_place_name = thumbnail_place_name;
        this.thumbnail_place_road = thumbnail_place_road;
        this.thumbnail_place_image = thumbnail_place_image;
        this.id = id;
        this.thumbnail_place_price = thumbnail_place_price;
    }

    public String getThumbnail_place_name() {
        return thumbnail_place_name;
    }

    public void setThumbnail_place_name(String thumbnail_place_name) {
        this.thumbnail_place_name = thumbnail_place_name;
    }

    public String getThumbnail_place_road() {
        return thumbnail_place_road;
    }

    public void setThumbnail_place_road(String thumbnail_place_road) {
        this.thumbnail_place_road = thumbnail_place_road;
    }

    public String getThumbnail_place_image() {
        return thumbnail_place_image;
    }

    public void setThumbnail_place_image(String thumbnail_place_image) {
        this.thumbnail_place_image = thumbnail_place_image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThumbnail_place_price() {
        return thumbnail_place_price;
    }

    public void setThumbnail_place_price(int thumbnail_place_price) {
        this.thumbnail_place_price = thumbnail_place_price;
    }
}
