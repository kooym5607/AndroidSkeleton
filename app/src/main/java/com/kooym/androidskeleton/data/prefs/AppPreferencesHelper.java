package com.kooym.androidskeleton.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_COOKIE_NAME = "PREF_KEY_COOKIE_NAME";
    private final SharedPreferences sharedPreferences;

    public AppPreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("SAVE_LOGIN_DATA", false);
        editor.putBoolean("FIRST_EXECUTE", true);
    }

    @Override
    public Set<String> getCookie() {
        return sharedPreferences.getStringSet(PREF_KEY_COOKIE_NAME, new HashSet<>());
    }

    @Override
    public void setCookie(HashSet<String> cookie) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet(PREF_KEY_COOKIE_NAME, cookie);
        editor.apply();
    }

    @Override
    public void clearPreference() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
