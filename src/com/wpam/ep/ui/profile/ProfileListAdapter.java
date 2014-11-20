package com.wpam.ep.ui.profile;

import android.app.ListActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.wpam.ep.R;
import com.wpam.ep.domain.Profile;
import com.wpam.ep.ui.BaseListAdapter;
import java.util.List;

/**
 * Project: Estimote Profiler
 * User: Mateusz Filipowicz
 * Date: 2014-11-09
 * Time: 12:54
 */
public class ProfileListAdapter extends BaseListAdapter<Profile, ProfileListHolder> {

    public ProfileListAdapter(ListActivity listActivity, List<Profile> data) {
        super(listActivity, data, R.layout.profile_list_item);
    }

    @Override
    protected ProfileListHolder getViewHolder(View view) {
        ProfileListHolder holder = new ProfileListHolder();
        holder.name = (TextView) view.findViewById(R.id.profile_list_name);
        holder.isUsed = (ImageView) view.findViewById(R.id.profile_list_used_image);
        return holder;
    }

    @Override
    protected ProfileListHolder setViewHolder(ProfileListHolder holder, View view, int position) {
        if(hasData()) {
            Profile tempValue = data.get(position);

            holder.name.setText(tempValue.getName());
        }
        else {
            holder.name.setText(view.getResources().getText(R.string.profile_tab_no_data));
        }
        return null;
    }

    @Override
    public void onClick(View v) {
        Log.e("CustomAdapter", "=====Row button clicked=====");
    }

    private class OnItemClickListener  implements View.OnClickListener {
        private int mPosition;

        OnItemClickListener(int position){
            mPosition = position;
        }

        @Override
        public void onClick(View arg0) {

              Log.e("CustomAdapter", "Row clicked");
//            CustomListViewAndroidExample sct = (CustomListViewAndroidExample)activity;

//            sct.onItemClick(mPosition);
        }
    }
}
