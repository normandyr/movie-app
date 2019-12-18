package com.missouristate.bryson.finalp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
//left out some statements and methods for the database for now.
//could be added later to increase functionality.

//if wanting to make this a real application, we could add a for i loop
//to add the additional movie titles and what-not

public class DatabaseHelper extends SQLiteOpenHelper {
    private DummyData dD = new DummyData();

    private static final String DATABASE_NAME = "moviesDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "movie";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SHOWTIME = "showtime";

    public DatabaseHelper( Context context ) {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    public void onCreate( SQLiteDatabase db ) {
        // build sql create statement
        String sqlCreate = "create table " + TABLE_NAME + "( " + ID;
        sqlCreate += " integer primary key autoincrement, " + NAME;
        sqlCreate += " text, " + SHOWTIME + " text )" ;

        db.execSQL( sqlCreate );
    }

    public void onUpgrade( SQLiteDatabase db,
                           int oldVersion, int newVersion ) {
        // Drop old table if it exists
        db.execSQL( "drop table if exists " + TABLE_NAME );
        // Re-create tables
        onCreate( db );
    }

    public ArrayList<Movie> selectAll( ) {
        String sqlQuery = "select * from " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase( );
        Cursor cursor = db.rawQuery( sqlQuery, null );

        ArrayList<Movie> movies = new ArrayList<Movie>( );
        while( cursor.moveToNext( ) ) {
            Movie currentMovie
                    = new Movie( Integer.parseInt( cursor.getString( 0 ) ),
                    cursor.getString( 1 ), cursor.getString( 2 ) );
            movies.add( currentMovie );
        }
        db.close( );
        return movies;
    }

    /*
    so for now, since this isn't a fully functioning app, there is dummy data used.
    this set of code will be used to check if the data is already in the table and if
    it is, it won't insert anymore rows to avoid constantly writing to the database.
     */
    public boolean ifValuesExist(){
        boolean exists;
        if (selectAll().size()>0)
        {
            exists = true;
        }
        else {
            exists = false;
        }
        return exists;
    }

    //code to add the pre-described
    // movies to the app's database.

    public void insert() {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlInsert = "insert into " + TABLE_NAME;
        sqlInsert += " values( null, '" + dD.movie_name[0];
        sqlInsert += "', '" + dD.movie_showtimes[0] + "' ),";

        sqlInsert += " ( null, '" + dD.movie_name[1];
        sqlInsert += "', '" + dD.movie_showtimes[1] + "' ),";

        sqlInsert += " ( null, '" + dD.movie_name[2];
        sqlInsert += "', '" + dD.movie_showtimes[2] + "' ),";

        sqlInsert += " ( null, '" + dD.movie_name[3];
        sqlInsert += "', '" + dD.movie_showtimes[3] + "' ),";

        sqlInsert += " ( null, '" + dD.movie_name[4];
        sqlInsert += "', '" + dD.movie_showtimes[4] + "' )";

        db.execSQL( sqlInsert );
        db.close( );
    }
}