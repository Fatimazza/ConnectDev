package id.co.binar.connectdev.module.profile.presenter;

import id.co.binar.connectdev.network.model.Friend;

/**
 * Created by fatimazza on 11/9/17.
 */

public interface OnLoadProfileListener {

    void profileFetched(Friend friend);

    void onError(String message);

}
