package com.example.franciscoandrade.daggerstepbystep;

import android.app.Application;

/**
 * Most Important class
 * App is a subclass of Application class
 */


public class App extends Application {

    /**
     * To use this class App from other classes we nedd to create a static reference variable, with respective get method
     * Include App in Manifest File
     * android:name=".App"
     */
    private static App app;

    //Reference to interface
    private MemberAppComponent memberAppComponent;

    /**
     * Override onCreate() method
     */
    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * assign current instance to app
         */
        app=this;

        /**
         * Dagger..
         * Dagger generates code for us, We defined an interface called MemeberAppComponent
         * Dagger will generate a class called DaggerMemberAppComponent (Rebuild Project)
         */

        memberAppComponent= DaggerMemberAppComponent.builder()
                //include all modules
                .memberDataModule(new MemberDataModule())
                .build();
    }


    public static App getApp() {
        return app;
    }

    /**
     * To get interface we can create a getter method
     */

    public MemberAppComponent getMemberAppComponent() {
        return memberAppComponent;
    }
}

