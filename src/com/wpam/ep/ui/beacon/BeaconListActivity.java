package com.wpam.ep.ui.beacon;

import android.os.Bundle;
import com.wpam.ep.R;
import com.wpam.ep.ui.ListBaseActivity;

/**
 * Project: Estimote Profiler
 * User: Mateusz Filipowicz
 * Date: 2014-11-09
 * Time: 13:43
 */
public class BeaconListActivity extends ListBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beacon_list);
    }
}
