package com.example.friendfinderapp.Constants;

public class ConfigurationAll {

    public static String user_id = "";
    static String ip = "10.212.151.247";
    public static final String baseUrl = "http://" + ip + "/friend-finder/public/";

    public static String ImageURL = "http://" + ip + "/friend-finder/public/img/";

    public static final String EVENT_URL = "http://" + ip + "/friend-finder/public/API/getAllEvent";
    public static final String THUMBNAIL_EVENT_URL = "http://" + ip + "/friend-finder/public/API/getEventThumbnail";
    public static final String THUMBNAIL_PLACE_URL = "http://" + ip + "/friend-finder/public/API/getDataPlace";
    public static final String PLACE_URL = "http://" + ip + "/friend-finder/public/API/getDataPlace";
}
