package com.wpam.ep.ui;

import android.os.Bundle;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.wpam.ep.database.DbHelper;
import com.wpam.ep.exception.ProfilerUncaughtExceptionHandler;

/**
 * Project: Estimote Profiler
 * User: Mateusz Filipowicz
 * Date: 2014-11-08
 * Time: 21:34
 */
public abstract class BaseActivity extends OrmLiteBaseActivity<DbHelper> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ProfilerUncaughtExceptionHandler(this));
    }
}
