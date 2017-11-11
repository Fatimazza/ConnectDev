package id.co.binar.connectdev.module.profile.presenter;

import id.co.binar.connectdev.network.model.FriendResponse;

/**
 * Created by fatimazza on 11/9/17.
 */

public interface OnLoadProfileListener {

    void profileFetched(FriendResponse friendResponse);

    void onError(String message);

    void showDialog();

    void hideDialog();

}
