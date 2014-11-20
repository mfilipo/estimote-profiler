package com.wpam.ep.ui;

import android.os.Bundle;
import com.j256.ormlite.android.apptools.OrmLiteBaseTabActivity;
import com.wpam.ep.database.DbHelper;
import com.wpam.ep.exception.ProfilerUncaughtExceptionHandler;

/**
 * Project: Estimote Profiler
 * User: Mateusz Filipowicz
 * Date: 2014-11-09
 * Time: 13:36
 */
public class TabBaseActivity extends OrmLiteBaseTabActivity<DbHelper> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ProfilerUncaughtExceptionHandler(this));
    }

}
