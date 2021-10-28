package com.kooym.androidskeleton.utils;

import android.util.Log;

import com.kooym.androidskeleton.BaseApplication;

public class Dlog {
    static final String APP_NAME = "DEFAULT";

    /**
     * Log Level Error
     **/
    public static final void e(String message) {
        if (BaseApplication.DEBUG) Log.e(APP_NAME, buildLogMsg(message));
    }

    /**
     * Log Level Warning
     **/
    public static final void w(String message) {
        if (BaseApplication.DEBUG) Log.w(APP_NAME, buildLogMsg(message));
    }

    /**
     * Log Level Information
     **/
    public static final void i(String message) {
        if (BaseApplication.DEBUG) Log.i(APP_NAME, buildLogMsg(message));
    }

    /**
     * Log Level Debug
     **/
    public static final void d(String message) {
        if (BaseApplication.DEBUG) Log.d(APP_NAME, buildLogMsg(message));
    }

    /**
     * Log Level Verbose
     **/
    public static final void v(String message) {
        if (BaseApplication.DEBUG) Log.v(APP_NAME, buildLogMsg(message));
    }


    public static String buildLogMsg(String message) {

        StackTraceElement ste = Thread.currentThread().getStackTrace()[4];

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(ste.getFileName().replace(".java", ""));
        sb.append("::");
        sb.append(ste.getMethodName());
        sb.append("]");
        sb.append(message);

        return sb.toString();

    }
}