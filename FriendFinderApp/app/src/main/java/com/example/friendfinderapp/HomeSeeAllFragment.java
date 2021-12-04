package com.example.friendfinderapp;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class HomeSeeAllFragment extends Fragment implements EventAdapter.OnEventListener {

    private ArrayList<Category> categories;
    private List<Event> events = new ArrayList<>();

    // recycler view init
    RecyclerView recyclerViewEvent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_see_all, container, false);

        // init
        NavController navController = Navigation.findNavController((Activity) view.getContext(), R.id.fragment);

        ImageView btn_back_to_home = view.findViewById(R.id.btn_back_to_home);

        // event
        // back to home
        btn_back_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.homeFragment);
            }
        });

        // categories
        addCategoryItem();
        RecyclerView recyclerViewCategories = view.findViewById(R.id.recycle_view_category);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories);
        recyclerViewCategories.setAdapter(categoryAdapter);
        RecyclerView.LayoutManager layoutManagerCategories = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategories.setLayoutManager(layoutManagerCategories);

        // event class
        addEventItem();
        recyclerViewEvent = view.findViewById(R.id.recycle_view_event);
        RecyclerView.LayoutManager layoutManagerEvent = new LinearLayoutManager(view.getContext());
        recyclerViewEvent.setLayoutManager(layoutManagerEvent);

        return view;
    }

    // add category item
    private void addCategoryItem() {
        categories = new ArrayList<>();
        categories.add(new Category("Place", R.mipmap.place));
        categories.add(new Category("Sport", R.mipmap.category));
        categories.add(new Category("Education", R.mipmap.category1));
        categories.add(new Category("Hangout", R.mipmap.category2));
        categories.add(new Category("Vacation", R.mipmap.category3));
    }

    // add event item
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
                    EventAdapter eventAdapter = new EventAdapter(events, HomeSeeAllFragment.this);
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

    @Override
    public void onEventClick(int position) {
        Toast.makeText(this.getContext(), "Selected" + events.get(position).getEvent_name(), Toast.LENGTH_SHORT).show();
    }
}