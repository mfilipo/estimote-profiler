package com.wpam.ep.exception;

import android.content.Context;
import android.util.Log;

/**
 * Project: Estimote Profiler
 * User: Mateusz Filipowicz
 * Date: 2014-11-08
 * Time: 21:35
 */
public class ProfilerUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private final Context context;

    public ProfilerUncaughtExceptionHandler(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        this.context = context;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        Log.e(context.getClass().getSimpleName(), throwable.getMessage(), throwable);
    }
}
