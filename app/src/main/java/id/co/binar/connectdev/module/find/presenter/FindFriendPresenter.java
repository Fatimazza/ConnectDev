package id.co.binar.connectdev.module.find.presenter;

import id.co.binar.connectdev.network.NetworkService;
import id.co.binar.connectdev.network.RestApi;
import id.co.binar.connectdev.network.model.SearchFriendResponse;
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

        listener.showDialog();
        this.restApi.getNearestFriend().enqueue(new Callback<SearchFriendResponse>() {
            @Override
            public void onResponse(Call<SearchFriendResponse> call, Response<SearchFriendResponse> response) {
                if (response.body() != null) {
                    listener.friendFetched(response.body().friend);
                    listener.hideDialog();
                }
            }

            @Override
            public void onFailure(Call<SearchFriendResponse> call, Throwable t) {
                listener.onError(t.getLocalizedMessage());
                listener.hideDialog();
            }
        });
    }
}
