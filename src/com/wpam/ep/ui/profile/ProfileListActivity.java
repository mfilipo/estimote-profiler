package com.wpam.ep.ui.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.wpam.ep.R;
import com.wpam.ep.domain.Profile;
import com.wpam.ep.ui.ListBaseActivity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: Estimote Profiler
 * User: Mateusz Filipowicz
 * Date: 2014-11-09
 * Time: 13:41
 */
public class ProfileListActivity extends ListBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_list);
        List<Profile> profiles = null;
        try {
            profiles = getHelper().getProfileDAO().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            profiles = new ArrayList<>();
        }
        setListAdapter(new ProfileListAdapter(this, profiles));
        getListView().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ProfileListActivity.this, "Dupa", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ProfileListActivity.this, "Cycki", Toast.LENGTH_LONG).show();
            }
        });
    }
}
