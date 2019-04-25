package com.example.superintender.ChatroomStuff;

import android.app.Application;


public class UserClient extends Application {

    private static User mainuser = null;

    public User getUser() {
        return mainuser;
    }

    public static void setUser(User user) {
        mainuser = user;
    }

}
