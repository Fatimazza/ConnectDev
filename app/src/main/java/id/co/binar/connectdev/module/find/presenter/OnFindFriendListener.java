package id.co.binar.connectdev.module.find.presenter;

import java.util.List;

import id.co.binar.connectdev.network.model.Friend;

/**
 * Created by rioswarawan on 11/9/17.
 */

public interface OnFindFriendListener {

    void friendFetched(List<Friend> friends);

    void onError(String message);
}
