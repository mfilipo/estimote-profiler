package com.wpam.ep;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TabHost;
import com.wpam.ep.domain.Profile;
import com.wpam.ep.ui.TabBaseActivity;
import com.wpam.ep.ui.beacon.BeaconListActivity;
import com.wpam.ep.ui.profile.ProfileListActivity;

import java.sql.SQLException;

public class Main extends TabBaseActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final String profilesTabName = getString(R.string.profile_tab);
        addTab(profilesTabName, ProfileListActivity.class);

        final String beaconsTabName = getString(R.string.beacon_tab);
        addTab(beaconsTabName, BeaconListActivity.class);
    }

    private void addTab(String tabName, Class<? extends Activity> clss) {
        addTab(tabName, clss, null);
    }

    private void addTab(String tabName, Class<? extends Activity> clss, Drawable icon) {
        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec(tabName);
        tabSpec.setIndicator(tabName, icon);
        Intent inboxIntent = new Intent(this, clss);
        tabSpec.setContent(inboxIntent);
        tabHost.addTab(tabSpec);
    }
}
