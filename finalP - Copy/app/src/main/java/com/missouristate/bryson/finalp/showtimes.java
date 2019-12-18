package com.missouristate.bryson.finalp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class showtimes extends Activity {
    TextView movieTV, timeTV;
    DatabaseHelper dbHelper;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showtimesview);
        dbHelper = new DatabaseHelper(this);
        updateView();
    }
    public void updateView(){
        ArrayList<Movie> movies = dbHelper.selectAll( );
        String movieInfo = "";
        String timeInfo = "";
        movieTV = findViewById(R.id.movie_tv);
        timeTV = findViewById(R.id.times_tv);

        if (movies.size() > 0)
        {
            for (Movie movie : movies) {
                movieInfo += movie.getName() + "\n\n\n";
                timeInfo += "\n" + movie.getTime() + "\n\n";
            }
            //displays the list of movies with their info
            movieTV.setText(movieInfo);
            timeTV.setText(timeInfo);
        }
        else {
            movieTV.setText("NULL.");
            timeTV.setText(null);
        }

    }
}
