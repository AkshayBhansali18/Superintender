package com.example.superintender.ChatroomStuff;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class UserAccounts implements Parcelable {
    GeoPoint geoPoint;
    User user;
    @ServerTimestamp
    Date timestamp;

    public UserAccounts(GeoPoint geoPoint, User user, Date timestamp) {
        this.geoPoint = geoPoint;
        this.user = user;
        this.timestamp = timestamp;
    }
    public UserAccounts()
    {

    }

    protected UserAccounts(Parcel in) {
        user = in.readParcelable(User.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(user, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserAccounts> CREATOR = new Creator<UserAccounts>() {
        @Override
        public UserAccounts createFromParcel(Parcel in) {
            return new UserAccounts(in);
        }

        @Override
        public UserAccounts[] newArray(int size) {
            return new UserAccounts[size];
        }
    };

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
