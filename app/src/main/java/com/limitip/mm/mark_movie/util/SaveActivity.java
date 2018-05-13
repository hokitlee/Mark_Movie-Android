package com.limitip.mm.mark_movie.util;

import android.app.Activity;

public class SaveActivity {
    static Activity myActivity;

    public static Activity getMyActivity() {
        return myActivity;
    }

    public static void setMyActivity(Activity myActivity) {
        SaveActivity.myActivity = myActivity;
    }
}
