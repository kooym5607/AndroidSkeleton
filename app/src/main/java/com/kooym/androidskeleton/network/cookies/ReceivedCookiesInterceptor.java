package com.kooym.androidskeleton.network.cookies;

import com.kooym.androidskeleton.data.prefs.AppPreferencesHelper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;

public class ReceivedCookiesInterceptor implements Interceptor {

    private AppPreferencesHelper appPreferencesHelper;

    public ReceivedCookiesInterceptor(AppPreferencesHelper appPreferencesHelper) {
        this.appPreferencesHelper = appPreferencesHelper;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        BufferedSource source = originalResponse.body().source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        String responseBodyString = buffer.clone().readString(Charset.forName("UTF-8"));
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>(originalResponse.headers("Set-Cookie"));
            // Preference에 cookies를 넣어주는 작업을 수행
            appPreferencesHelper.setCookie(cookies);
        }
        return originalResponse;
    }
}