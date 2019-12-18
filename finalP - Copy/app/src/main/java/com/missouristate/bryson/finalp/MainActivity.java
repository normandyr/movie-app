package com.missouristate.bryson.finalp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements MyListFragment.OnItemSelectedListener {
    View view;
    DatabaseHelper dbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sets background by code
        view= this.getWindow().getDecorView();
        view.setBackgroundResource(R.drawable.movie);

        /*
        checks to see if these values are already
        in the database and if not, it adds them.
         */
        if (dbHelper.ifValuesExist()) {
         Log.wtf("DB", "values exist");
        }
        else {
            //insert the dummy data into the database
            dbHelper.insert();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id) {
            case R.id.picture:
                Log.wtf("mainactivity", "add");
                Intent picIntent = new Intent(this, Pic.class);
                this.startActivity(picIntent);
                return true;
            case R.id.quiz:
                Log.wtf("mainactivity", "add");
                Intent quizIntent = new Intent(this, Quiz.class);
                this.startActivity(quizIntent);
                return true;
            case R.id.showtimes:
                Log.wtf("mainactivity", "add");
                Intent showtimesIntent = new Intent(this, showtimes.class);
                this.startActivity(showtimesIntent);
                return true;
        }
        return true;
    }


    @Override

    public Button onColorItemSelected(String link) {

        //after item selected it changes background accordingly
        view = this.getWindow().getDecorView();
        if (MyListFragment.BackgoundNum == 0){
            view.setBackgroundResource(R.drawable.the_empire_strikes_back);
        } else if(MyListFragment.BackgoundNum == 1){
            view.setBackgroundResource(R.drawable.avengers_endgame);
        }else if(MyListFragment.BackgoundNum == 2){
            view.setBackgroundResource(R.drawable.the_incredibles);
        }else if(MyListFragment.BackgoundNum == 3){
            view.setBackgroundResource(R.drawable.toy_story);
        }else if(MyListFragment.BackgoundNum == 4){
            view.setBackgroundResource(R.drawable.finding_nemo);
        }
        //added a default picture right here just in case.
        else {
            view.setBackgroundResource(R.drawable.movie);
        }


        //CHECK IF FRAGMENT2 EXISTS IN THIS LAYOUT

        InformationFragment fragment2 = (InformationFragment) getFragmentManager()

                .findFragmentById(R.id.fragment2);

        //A TWO PANE CONFIGURATION

        if (fragment2 != null && fragment2.isInLayout()) {
            fragment2.setText(link);

        }

        //A SINGLE-PANE CONFIGURATION -

        //  IF FRAGMENT 2 DOES NOT EXIST IN THIS LAYOUT, THEN ACTIVATE THE NEXT ACTIVITY

        else {

            Intent intent = new Intent (this, InformationActivity.class);

            intent.putExtra("Information", link);

            startActivity (intent);

        }

        return null;
    }


}


