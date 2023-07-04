package com.example.project;

import android.app.Activity;

public class Section {
    private String title;
    private Class<? extends Activity> activityClass;

    public Section(String title, Class<? extends Activity> activityClass) {
        this.title = title;
        this.activityClass = activityClass;
    }

    public String getTitle() {
        return title;
    }

    public Class<? extends Activity> getActivityClass() {
        return activityClass;
    }
}
