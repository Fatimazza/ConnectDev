package id.co.binar.connectdev.module.login.presenter;

import id.co.binar.connectdev.module.login.interactor.LoginInteractor;
import id.co.binar.connectdev.module.login.interactor.OnLoginFinished;
import id.co.binar.connectdev.module.login.view.OnLoginView;

/**
 * Created by rioswarawan on 11/8/17.
 */

public class LoginPresenter implements OnLoginPresent {

    private OnLoginView view;
    private LoginInteractor interactor;

    public LoginPresenter(OnLoginView view) {
        this.view = view;
        this.interactor = new LoginInteractor();
    }

    @Override
    public void facebookSignIn() {
        interactor.signIn(onLoginFinished);
    }

    @Override
    public void onDestroy() {
        view = null;
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
