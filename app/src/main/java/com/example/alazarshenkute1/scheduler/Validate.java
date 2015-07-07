package com.example.alazarshenkute1.scheduler;

public class Validate {

    // Keys for retrieving user data
    private static final String EMAIL_KEY = "email";
    private static final String NAME_KEY = "name";
    private static final String PASSWORD_KEY = "passWord";

    public Validate()
    {

    }

    // returns 1 if found
    // 0 if user not in system
    // -1 if wrong username/password
    public int validateLogin() {
        //
       // SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences();
        // String name = preferences.getString(EMAIL_KEY, "");
        return 0;
    }
}
