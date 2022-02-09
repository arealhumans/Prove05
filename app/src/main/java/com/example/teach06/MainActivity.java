package com.example.teach06;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onOddClick(View view) {
        OddCounter counter = new OddCounter(this);
        Thread thread = new Thread(counter);

        thread.start();
    }

    public void onEvenClick(View view) {
        // This example does the exact same things as the other event handler
        // but does it all on one line.
        new Thread(new EvenCounter(this)).start();
    }
}