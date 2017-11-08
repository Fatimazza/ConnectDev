package id.co.binar.connectdev;

import android.app.Application;
import android.content.Context;

import com.facebook.FacebookSdk;

/**
 * Created by rioswarawan on 11/7/17.
 */

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        FacebookSdk.sdkInitialize(this);
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
