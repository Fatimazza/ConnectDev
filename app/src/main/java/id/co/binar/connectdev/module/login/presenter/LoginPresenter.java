package id.co.binar.connectdev.module.login.presenter;

import android.app.Activity;

import java.lang.ref.WeakReference;

import id.co.binar.connectdev.module.login.interactor.LoginInteractor;
import id.co.binar.connectdev.module.login.interactor.OnLoginFinished;
import id.co.binar.connectdev.module.login.view.OnLoginView;

/**
 * Created by rioswarawan on 11/8/17.
 */

public class LoginPresenter implements OnLoginPresent {

    private OnLoginView view;
    private LoginInteractor interactor;
    private WeakReference<Activity> activityWeakReference;
    private Activity activity;

    public LoginPresenter(Activity activity, OnLoginView view) {
        this.view = view;
        this.interactor = new LoginInteractor();
        this.activityWeakReference = new WeakReference<>(activity);
        this.activity = activityWeakReference.get();
    }

    @Override
    public void facebookSignIn() {
        interactor.signIn(activity, onLoginFinished);
    }

    @Override
    public void onDestroy() {
        this.view = null;
        this.activity = null;
    }

    private OnLoginFinished onLoginFinished = new OnLoginFinished() {
        @Override
        public void signInSuccess() {
            view.onLoginSuccess();
        }

        @Override
        public void signInFailed(String message) {
            view.onError(message);
        }
    };
}
