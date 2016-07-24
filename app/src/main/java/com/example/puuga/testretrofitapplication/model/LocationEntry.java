package com.example.puuga.testretrofitapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by siwao on 17/7/2559.
 */
public class LocationEntry implements Parcelable {
    public String id;
    public String location_id;
    public String user_id;
    public String app_id;
    public String action;
    public String created_at;

    public LocationEntry() {
    }

    protected LocationEntry(Parcel in) {
        id = in.readString();
        location_id = in.readString();
        user_id = in.readString();
        app_id = in.readString();
        action = in.readString();
        created_at = in.readString();
    }

    public static final Creator<LocationEntry> CREATOR = new Creator<LocationEntry>() {
        @Override
        public LocationEntry createFromParcel(Parcel in) {
            return new LocationEntry(in);
        }

        @Override
        public LocationEntry[] newArray(int size) {
            return new LocationEntry[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(location_id);
        parcel.writeString(user_id);
        parcel.writeString(app_id);
        parcel.writeString(action);
        parcel.writeString(created_at);
    }
}
