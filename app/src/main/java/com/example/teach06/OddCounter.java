package com.example.teach06;

import android.app.Activity;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/**
 * This class will run on a background thread and count to 100 by odds.
 * For simplicity, it does not use WeakReferences (as you should to do this properly).
 */
public class OddCounter implements Runnable {
    // NOTE: For ease of understanding the basic concepts, this class does not show
    // the WeakReference as defined in the Strech Challenge please see the EvenCounter
    // class for an example of how to use that.
    private Activity activity;

    /**
     * Creates a new OddCounter with the activity that will be used for the Toast
     * at the end.
     * @param activity
     */
    public OddCounter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void run() {
        // Start at 1 to count by odds
        for (int i = 1; i < 100; i+=2) {
            System.out.println(i);

            try {
                // Simulate a more complex process by sleeping here.
                // In a real program you wouldn't sleep, it just wastes time.
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // we are now finished counting, display the toast:
        // (This could be done with a lambda instead which would be more succinct,
        // but this example shows it will an anonymous class to be more explicit
        // about what's happening.
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // This is the code that will run on the UI thread.
                Toast toast = Toast.makeText(activity, "Odd Counting Finished", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
