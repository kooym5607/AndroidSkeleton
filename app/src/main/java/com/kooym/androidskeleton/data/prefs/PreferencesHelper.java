package com.kooym.androidskeleton.data.prefs;

import java.util.HashSet;
import java.util.Set;

public interface PreferencesHelper {
    Set<String> getCookie();
    void setCookie(HashSet<String> cookie);
    void clearPreference();
}
