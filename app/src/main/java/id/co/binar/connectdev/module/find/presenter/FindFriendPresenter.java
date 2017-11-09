package id.co.binar.connectdev.module.find.presenter;

import id.co.binar.connectdev.network.NetworkService;
import id.co.binar.connectdev.network.RestApi;
import id.co.binar.connectdev.network.model.SearchFriend;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rioswarawan on 11/9/17.
 */

public class FindFriendPresenter {

    private RestApi restApi;

    public FindFriendPresenter() {
        this.restApi = NetworkService.create();
    }

    public void getNearestFriend(final OnFindFriendListener listener) {
        this.restApi.getNearestFriend().enqueue(new Callback<SearchFriend>() {
            @Override
            public void onResponse(Call<SearchFriend> call, Response<SearchFriend> response) {
                if (response.body() != null) {
                    listener.friendFetched(response.body().friend);
                }
            }

            @Override
            public void onFailure(Call<SearchFriend> call, Throwable t) {
                listener.onError(t.getLocalizedMessage());
            }
        });
    }
}
