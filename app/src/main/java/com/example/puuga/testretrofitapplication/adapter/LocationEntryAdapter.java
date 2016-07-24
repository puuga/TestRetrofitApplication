package com.example.puuga.testretrofitapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.puuga.testretrofitapplication.R;
import com.example.puuga.testretrofitapplication.model.LocationEntry;

/**
 * Created by siwao on 17/7/2559.
 */
public class LocationEntryAdapter extends RecyclerView.Adapter<LocationEntryAdapter.ViewHolder> {

    private LocationEntry[] locationEntries;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvId;
        public TextView mTvLocation;
        public TextView mTvAction;

        public ViewHolder(View v) {
            super(v);
            mTvId = (TextView) v.findViewById(R.id.tvId);
            mTvLocation = (TextView) v.findViewById(R.id.tvLocationId);
            mTvAction = (TextView) v.findViewById(R.id.tvAction);
        }
    }

    public LocationEntryAdapter(LocationEntry[] locationEntries) {
        this.locationEntries = locationEntries;
    }

    @Override
    public LocationEntryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_location_entry, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(LocationEntryAdapter.ViewHolder holder, int position) {
        LocationEntry locationEntry = locationEntries[position];
        holder.mTvId.setText(locationEntry.id);
        holder.mTvLocation.setText(locationEntry.location_id);
        holder.mTvAction.setText(locationEntry.action);
    }

    @Override
    public int getItemCount() {
        return locationEntries == null ? 0 : locationEntries.length;
    }
}
