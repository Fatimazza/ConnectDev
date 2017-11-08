package id.co.binar.connectdev.module.login.interactor;

import android.app.Activity;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

/**
 * Created by rioswarawan on 11/8/17.
 */

public class LoginInteractor {

    private OnLoginFinished finishCallback;
    private String[] permissions = {"public_profile"};

    public void signIn(Activity activity, OnLoginFinished callback) {
        finishCallback = callback;

        CallbackManager facebookCallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(facebookCallbackManager, facebookCallback);
        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList(permissions));
    }

    private FacebookCallback<LoginResult> facebookCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            finishCallback.signInSuccess();
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onError(FacebookException e) {
            finishCallback.signInFailed(e.getMessage());
        }
    };
}
