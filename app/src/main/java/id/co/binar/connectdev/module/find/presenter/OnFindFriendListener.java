package id.co.binar.connectdev.module.find.presenter;

import java.util.List;

import id.co.binar.connectdev.network.model.FriendResponse;

/**
 * Created by rioswarawan on 11/9/17.
 */

public interface OnFindFriendListener {

    void friendFetched(List<FriendResponse> friendResponses);

    void onError(String message);

    void showDialog();

    void hideDialog();
}
