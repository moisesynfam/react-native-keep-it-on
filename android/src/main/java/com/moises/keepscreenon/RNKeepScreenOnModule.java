
package com.moises.keepscreenon;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.PowerManager;
import android.telecom.Call;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNKeepScreenOnModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private PowerManager.WakeLock screenOffWakeLock;
    private static final String TAG = RNKeepScreenOnModule.class.getSimpleName();

    public RNKeepScreenOnModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;

        PowerManager powerManager = (PowerManager) reactContext.getSystemService(Context.POWER_SERVICE);
        screenOffWakeLock = powerManager.newWakeLock(PowerManager.PROXIMITY_SCREEN_OFF_WAKE_LOCK, TAG);
    }



    @Override
    public String getName() {
    return "RNKeepScreenOn";
    }


    @ReactMethod
    public void enableProximity(Callback callback) {

        try {
            screenOffWakeLock.acquire();
          callback.invoke(true);
        } catch (Exception e) {
            e.printStackTrace();
          callback.invoke(false, e);
        }

    }

    @ReactMethod
    public void disableProximity(Callback callback) {
        try {

            screenOffWakeLock.release();
            callback.invoke(true);
        } catch (Exception e) {
            callback.invoke(false, e);
        }

    }

    @ReactMethod
    public void  activate(final boolean shouldDisplayOnLockScreen) {
        final Activity currentActivity = getCurrentActivity();
        if(currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() {
              @Override
              public void run() {
              if(shouldDisplayOnLockScreen)
                  currentActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
                  currentActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
              }
            });
        }

    }

    @ReactMethod
    public void  deactivate() {
        final Activity currentActivity = getCurrentActivity();
        if(currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    currentActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
                    currentActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                }
            });
        }

    }
}