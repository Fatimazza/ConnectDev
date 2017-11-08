package id.co.binar.connectdev.module.login.interactor;

/**
 * Created by rioswarawan on 11/8/17.
 */

public interface OnLoginFinished {

    void signInSuccess();

    void signInFailed(String message);
}
