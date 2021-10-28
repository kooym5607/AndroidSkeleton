package com.kooym.androidskeleton.network.cookies;

import android.content.res.Resources;

import com.kooym.androidskeleton.data.prefs.AppPreferencesHelper;

import java.io.IOException;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddCookiesInterceptor implements Interceptor {

    private AppPreferencesHelper appPreferencesHelper;

    public AddCookiesInterceptor(AppPreferencesHelper appPreferencesHelper) {
        this.appPreferencesHelper = appPreferencesHelper;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        Set<String> preferences = appPreferencesHelper.getCookie();

        for (String cookie : preferences) {
            builder.addHeader("Cookie", cookie);
        }

        builder.addHeader("Content-Type", "application/json; charset=utf-8");
        builder.addHeader("Accept", "application/json; charset=utf-8");
        builder.addHeader("Language", Resources.getSystem().getConfiguration().getLocales().get(0).getLanguage());

        // Web,Android,iOS 구분을 위해 User-Agent 세팅
        builder.removeHeader("User-Agent").addHeader("User-Agent", "Android");
        builder.addHeader("deviceOS", "ANDROID");

        return chain.proceed(builder.build());
    }
}