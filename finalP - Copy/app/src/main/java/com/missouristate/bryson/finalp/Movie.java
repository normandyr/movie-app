package com.missouristate.bryson.finalp;

public class Movie {
        private int id;
        private String name;
        private String time;

        public Movie( int newId, String newName, String newTime ) {
            setId( newId );
            setName( newName );
            setTime( newTime );
        }

        public void setId( int newId ) {
            id = newId;
        }

        public void setName( String newName ) {
            name = newName;
        }

        public void setTime( String newTime ) {
            if( newTime != null)
                time = newTime;
        }

        public int getId( ) {
            return id;
        }

        public String getName( ) {
            return name;
        }

        public String getTime( ) {
            return time;
        }
}
