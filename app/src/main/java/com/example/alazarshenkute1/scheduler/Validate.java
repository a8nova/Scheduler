package com.example.alazarshenkute1.scheduler;

import android.util.Patterns;

public class Validate {


    public Validate()
    {

    }

    // returns 1 if found
    // 0 if user not in system
    // -1 if wrong username/password
    public static int validateLogin( String email, String password ) {



        return 0;
    }

    public static boolean validateSignUp( String email, String password )
    {

        // check if email is valid
        CharSequence eml = email;
        if( !isValidEmail( eml ) ) {
            return false;
        }
        // check if password is
        //      - minimum 6 characters and contains atleast one digit
        if( password.length() < 6 ){
            return false;
        }
        // doesn't have atleast one digit
        if( !atLeastOneDigit( password ) ){
            return false;
        }
        return true;

    }
    // check if a string contains a digit
    // returns true when digit found, false otherwise
    private static boolean atLeastOneDigit( String password ) {
        for( int i = 0; i < password.length(); i++ ){
            if( Character.isDigit( password.charAt( i ) ) )
                return true;
        }
        return false;
    }

    private final static boolean isValidEmail( CharSequence target )
    {
        return Patterns.EMAIL_ADDRESS.matcher( target ).matches();
    }

}
