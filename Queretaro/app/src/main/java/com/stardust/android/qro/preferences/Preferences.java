package com.stardust.android.qro.preferences;

import android.content.Context;
import android.content.SharedPreferences;


public class Preferences {
    private static final String PREFERENCES = "com.stardust.android.qro";

    private static final String USER_ID = "user.id";
    private static final String USERNAME = "user.username";
    private static final String LASTNAME = "user.lastname";
    private static final String PHONE = "user.ic_phone_signin";
    private static final String EMAIL = "user.email";
    private static final String USER_TYPE = "user.usertype";
    private static final String REPUTATION = "user.reputation";
    private static final String REGISTER_TOKEN = "device.token";

    private static Preferences instance;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private Preferences(Context context) {
        this.preferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        this.editor = preferences.edit();
    }

    public static synchronized Preferences getInstance(Context context) {
        if (instance == null) {
            instance = new Preferences(context);
        }
        return instance;
    }

    public Boolean getLoggedUser() {
        return preferences.getInt(USER_ID, 0) != 0;
    }

    /*public User getUser() {
        if (preferences.getInt(USER_ID, 0) != 0) {
            return User.Builder()
                    .userId(preferences.getInt(USER_ID, 0))
                    .userName(preferences.getString(USERNAME, null))
                    .lastName(preferences.getString(LASTNAME, null))
                    .phone(preferences.getString(PHONE, null))
                    .email(preferences.getString(EMAIL, null))
                    .userType(preferences.getInt(USER_TYPE, 0))
                    .reputation(preferences.getLong(REPUTATION, 0))
                    .build();
        }
        return User.Builder()
                .build();
    }

    public int getUserID(){
        if (preferences.getInt(USER_ID, 0) != 0) {
            return preferences.getInt(USER_ID,0);
        }
        return 0;
    }

    public boolean putUser(User user) {
        editor.putInt(USER_ID, user.getUserId());
        editor.putString(USERNAME, user.getUserName());
        editor.putString(LASTNAME, user.getLastName());
        editor.putString(PHONE, user.getPhone());
        editor.putString(EMAIL, user.getEmail());
        editor.putInt(USER_TYPE, user.getUserType());
        editor.putLong(REPUTATION, (long) user.getReputation());
        return editor.commit();
    }*/

    public void registerToken(boolean register){
        editor.putBoolean(REGISTER_TOKEN,register);
        editor.commit();
    }

    public Boolean registeredToken(){
        return preferences.getBoolean(REGISTER_TOKEN,false);
    }

    public void logout() {
        editor.clear();
        editor.commit();
    }
}
