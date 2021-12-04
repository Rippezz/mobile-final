package com.example.friendfinderapp;

public class Event {
    private String event_name, event_image, event_date;
    private int id;

    public Event(String event_name, String event_image, String event_date, int id) {
        this.event_name = event_name;
        this.event_image = event_image;
        this.event_date = event_date;
        this.id = id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_image() {
        return event_image;
    }

    public void setEvent_image(String event_image) {
        this.event_image = event_image;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
