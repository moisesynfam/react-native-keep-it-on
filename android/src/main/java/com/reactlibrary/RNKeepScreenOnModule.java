
package com.reactlibrary;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNKeepScreenOnModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNKeepScreenOnModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNKeepScreenOn";
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