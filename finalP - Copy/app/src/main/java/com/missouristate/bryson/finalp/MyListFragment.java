package com.missouristate.bryson.finalp;

import android.view.View;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyListFragment extends Fragment {

    private OnItemSelectedListener listener;

    DatabaseHelper dbHelper;
    List<String> filmListing;
    List<String> movieSummary;
    public static int BackgoundNum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        filmListing = new ArrayList<String>(Arrays.asList(DummyData.movie_name));

        movieSummary = new ArrayList<String>(Arrays.asList(DummyData.movie_summary));


        // Now that we have some dummy data, create an ArrayAdapter.

        // The ArrayAdapter will take data from a source and

        // use it to populate the ListView it's attached to.

        final ArrayAdapter<String> movieAdapter =

                new ArrayAdapter<String>(

                        getActivity(), // The current context (this activity)

                        R.layout.list_item_movie, // The name of the layout ID.

                        R.id.list_movie_textview, // The ID of the textview to populate.

                        filmListing);


        View rootView =
                    //should be R.layout.movie_list_fragment
                inflater.inflate(R.layout.movie_list_fragment,

                        container,

                        false);


        // Get a reference to the ListView, and attach this adapter to it.
        //should be R.id.listview_movies
        ListView listView = rootView.findViewById(R.id.listview_movies);

        listView.setAdapter(movieAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String movieIndexString = movieAdapter.getItem(i);

                String information = movieIndexString + "\n\n\n" + movieSummary.get(i);

                BackgoundNum  = i;

                updateDetail(information);

            }


        });


        return rootView;

    }

    public interface OnItemSelectedListener {

        Button onColorItemSelected(String link);


    }

    @Override

    public void onAttach(Activity activity) {

        super.onAttach(activity);

        if (activity instanceof OnItemSelectedListener) {

            listener = (OnItemSelectedListener) activity;


        } else {

            throw new ClassCastException(activity.toString()

                    + " must implement MyListFragment.OnItemSelectedListener");

        }

    }

    public void updateDetail(String information) {

        listener.onColorItemSelected(information);

    }


}