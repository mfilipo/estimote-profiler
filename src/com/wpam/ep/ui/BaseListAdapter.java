package com.wpam.ep.ui;

import android.app.ListActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;
import com.wpam.ep.R;

import java.util.List;

/**
 * Project: Estimote Profiler
 * User: Mateusz Filipowicz
 * Date: 2014-11-09
 * Time: 18:29
 */
public abstract class BaseListAdapter<T, E extends ViewHolder> extends BaseAdapter implements View.OnClickListener {

    protected ListActivity listActivity;
    protected List<T> data;
    protected LayoutInflater inflater;
    protected int listItemResource;

    public BaseListAdapter(ListActivity listActivity, List<T> data, int listItemResource) {
        this.listActivity = listActivity;
        this.data = data;
        inflater = ( LayoutInflater )listActivity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listItemResource = listItemResource;
    }

    public boolean hasData() {
        return data.size() > 0;
    }

    public int getCount() {
        if(hasData()) {
            return data.size();
        }
        return 1;
    }

    public T getItem(int position) {
        return data.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    protected abstract E getViewHolder(View view);
    protected abstract E setViewHolder(E holder, View view, int position);

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        E holder;

        if (convertView == null) {
            view = inflater.inflate(listItemResource, null);

            holder = getViewHolder(view);

            view.setTag(holder);
        } else {
            holder = (E) view.getTag();
        }
        setViewHolder(holder, view, position);
        view.setClickable(true);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(listActivity, "DUPA STACHY", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
