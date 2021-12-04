package com.example.friendfinderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.friendfinderapp.Constants.ConfigurationAll;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EventFragment extends Fragment implements EventAdapter.OnEventListener {

    private List<Event> events = new ArrayList<>();

    // recycler view init
    RecyclerView recyclerViewEvent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        // event class
        addEventItem();
        recyclerViewEvent = view.findViewById(R.id.recycle_view_event);
        RecyclerView.LayoutManager layoutManagerEvent = new LinearLayoutManager(view.getContext());
        recyclerViewEvent.setLayoutManager(layoutManagerEvent);
        return view;
    }

    @Override
    public void onEventClick(int position) {
        Intent intent = new Intent(this.getContext(), Event_DetailEvent.class);
        intent.putExtra("event_name", events.get(position).getEvent_name());
        intent.putExtra("event_date", events.get(position).getEvent_date());
        intent.putExtra("event_image", events.get(position).getEvent_image());
        startActivity(intent);
    }

    private void addEventItem() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ConfigurationAll.EVENT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray eventArray = new JSONArray(response);
                    for (int i = 0; i < eventArray.length(); i++) {
                        JSONObject eventsJSONObject = eventArray.getJSONObject(i);
                        int id = eventsJSONObject.getInt("id");
                        String name_event = eventsJSONObject.getString("name_event");
                        String event_start_date = eventsJSONObject.getString("event_start_date");
                        String event_picture = eventsJSONObject.getString("event_picture");

                        Event event = new Event(name_event, event_picture, event_start_date, id);
                        events.add(event);
                    }
                    EventAdapter eventAdapter = new EventAdapter(events, EventFragment.this);
                    recyclerViewEvent.setAdapter(eventAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(getContext()).add(stringRequest);
    }
}