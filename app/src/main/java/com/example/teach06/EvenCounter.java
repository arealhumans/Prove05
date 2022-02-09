package com.example.teach06;

import android.app.Activity;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class EvenCounter implements Runnable{
    private WeakReference<Activity> activityRef;

    public EvenCounter(Activity activity) {
        this.activityRef = new WeakReference<Activity>(activity);
    }

    @Override
    public void run() {

        // Start at 2 so we count the even numbers
        for (int i = 2; i < 100; i+=2) {
            System.out.println(i);

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // we are now finished counting, display the toast:

        // first, we'll get the activity from the WeakReference
        final Activity activity = activityRef.get();

        // now, make sure the activity was not destroyed since we last saw it
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // This is the code that will run on the UI thread.
                    Toast toast = Toast.makeText(activity, "Even Counting Finished", Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        }
    }
}