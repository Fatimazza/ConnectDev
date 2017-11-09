package id.co.binar.connectdev.tools;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

import com.google.gson.Gson;

/**
 * Created by rioswarawan on 4/25/17.
 */

public class FragmentUtils {

    /**
     * Get object from Intent that has been serialized as JSON string.
     */
    @Nullable
    public static final <T> T getObjectFromJsonIntent(@Nullable Bundle bundle,
                                                      @Nullable String key,
                                                      @NonNull Class<T> tClass) {
        if (bundle == null)
            return null;

        String json = bundle.getString(key);
        if (TextUtils.isEmpty(json))
            return null;

        try {
            return new Gson().fromJson(json, tClass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get parameter passed to an activity. Call this from activity onCreate()
     * or anywhere near initialization.
     */
    public static final <T> T getParam(@NonNull Fragment fragment,
                                       @Nullable String paramKey,
                                       @NonNull Class<T> paramClass) {
        return getObjectFromJsonIntent(fragment.getArguments(), paramKey, paramClass);
    }

    /**
     * Switch view to specific Fragment.
     */
    public static void startFragment(FragmentActivity activity, Fragment fragment, @IdRes int containerViewId) {
        try {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.addToBackStack(null);
            ft.replace(containerViewId, fragment);
            ft.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Switch view to specific Fragment and pass a parameter.
     */
    public static <T> void startFragmentWParam(FragmentActivity activity, Fragment fragment, @IdRes int containerViewId, String key, T param) {
        Bundle bundle = new Bundle();
        bundle.putString(key, new Gson().toJson(param));
        fragment.setArguments(bundle);

        startFragment(activity, fragment, containerViewId);
    }

    public static void removeFragment(FragmentActivity activity, Fragment fragment) {
        try {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.remove(fragment);
            ft.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeFragment(FragmentActivity activity, @IdRes int containerViewId) {
        try {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.remove(activity.getSupportFragmentManager().findFragmentById(containerViewId));
            ft.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
