package com.example.android.lifecycle;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
     * This tag will be used for logging. It is best practice to use the class's name using
     * getSimpleName as that will greatly help to identify the location from which your logs are
     * being posted.
     */
    private static final String TAG = MainActivity.class.getSimpleName();
    // TODO (1) Create a key String called LIFECYCLE_CALLBACKS_TEXT_KEY
    public static final String LIFECYCLE_CALLBACKS_TEXT_KEY = "callbacks";

    /* Constant values for the names of each respective lifecycle callback */
    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private static final String ON_SAVE_INSTANCE_STATE = "onSaveInstanceState";

    /*
     * This TextView will contain a running log of every lifecycle callback method called from this
     * Activity. This TextView can be reset to its default state by clicking the Button labeled
     * "Reset Log"
     */
    private TextView mLifecycleDisplay;

    /**
     * Called when the activity is first created. This is where you should do all of your normal
     * static set up: create views, bind data to lists, etc.
     *
     * Always followed by onStart().
     *
     * @param savedInstanceState The Activity's previously frozen state, if there was one.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLifecycleDisplay = (TextView) findViewById(R.id.tv_lifecycle_events_display);

        // TODO (6) If savedInstanceState is not null and contains LIFECYCLE_CALLBACKS_TEXT_KEY, set that text on our TextView
        if (savedInstanceState != null){
            if (savedInstanceState.containsKey(LIFECYCLE_CALLBACKS_TEXT_KEY)){
                String allPreviousLifeCycleCallBacks = savedInstanceState
                        .getString(LIFECYCLE_CALLBACKS_TEXT_KEY);
                mLifecycleDisplay.setText(allPreviousLifeCycleCallBacks);
            }
        }

        // T05a.01 COMPLETED (1) Use logAndAppend within onCreate
        logAndAppend(ON_CREATE);
    }

    // T05a.01 COMPLETED (2) Override onStart, call super.onStart, and call logAndAppend with ON_START

    @Override
    protected void onStart() {
        super.onStart();
        logAndAppend(ON_START);
    }

    // T05a.01 COMPLETED (3) Override onResume, call super.onResume, and call logAndAppend with ON_RESUME

    @Override
    protected void onResume() {
        super.onResume();
        logAndAppend(ON_RESUME);
    }

    // T05a.01 COMPLETED (4) Override onPause, call super.onPause, and call logAndAppend with ON_PAUSE

    @Override
    protected void onPause() {
        super.onPause();
        logAndAppend(ON_PAUSE);
    }

    // T05a.01 COMPLETED (5) Override onStop, call super.onStop, and call logAndAppend with ON_STOP

    @Override
    protected void onStop() {
        super.onStop();
        logAndAppend(ON_STOP);
    }

    // T05a.01 COMPLETED (6) Override onRestart, call super.onRestart, and call logAndAppend with ON_RESTART

    @Override
    protected void onRestart() {
        super.onRestart();
        logAndAppend(ON_RESTART);
    }

    // T05a.01 COMPLETED (7) Override onDestroy, call super.onDestroy, and call logAndAppend with ON_DESTROY

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logAndAppend(ON_DESTROY);
    }


    // TODO (2) Override onSaveInstanceState
    // Do steps 3 - 5 within onSaveInstanceState
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO (3) Call super.onSaveInstanceState
        super.onSaveInstanceState(outState);
        // TODO (4) Call logAndAppend with the ON_SAVE_INSTANCE_STATE String
        logAndAppend(ON_SAVE_INSTANCE_STATE);
        // TODO (5) Put the text from the TextView in the outState bundle
        String lifeCycleDisplayTextViewContents = mLifecycleDisplay.getText().toString();
        outState.putString(LIFECYCLE_CALLBACKS_TEXT_KEY, lifeCycleDisplayTextViewContents);
    }

    /**
     * Logs to the console and appends the lifecycle method name to the TextView so that you can
     * view the series of method callbacks that are called both from the app and from within
     * Android Studio's Logcat.
     *
     * @param lifecycleEvent The name of the event to be logged.
     */
    private void logAndAppend(String lifecycleEvent) {
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);

        mLifecycleDisplay.append(lifecycleEvent + "\n");
    }

    /**
     * This method resets the contents of the TextView to its default text of "Lifecycle callbacks"
     *
     * @param view The View that was clicked. In this case, it is the Button from our layout.
     */
    public void resetLifecycleDisplay(View view) {
        mLifecycleDisplay.setText("Lifecycle callbacks:\n");
    }
}
