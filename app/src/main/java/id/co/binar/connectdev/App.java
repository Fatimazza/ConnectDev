package id.co.binar.connectdev;

import android.app.Application;
import android.content.Context;

import com.facebook.FacebookSdk;
import com.onesignal.OneSignal;

/**
 * Created by rioswarawan on 11/7/17.
 */

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        FacebookSdk.sdkInitialize(this);

        oneSignalConfiguration();
        context = this;
    }

    public static Context getContext() {
        return context;
    }

    private void oneSignalConfiguration() {
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.None)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }
}
