package id.co.binar.connectdev.module.profile.presenter;

import id.co.binar.connectdev.module.profile.model.Profile;
import id.co.binar.connectdev.network.NetworkService;
import id.co.binar.connectdev.network.RestApi;
import id.co.binar.connectdev.network.model.Friend;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fatimazza on 11/9/17.
 */

public class ProfilePresenter {

    private RestApi restApi;

    public ProfilePresenter() {
        this.restApi = NetworkService.create();
    }

    public void getProfile(final OnLoadProfileListener listener) {
        this.restApi.getProfile().enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (response.body() != null) {
                    Friend friend = response.body().profile;
                    listener.profileFetched(friend);
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                listener.onError(t.getLocalizedMessage());
            }
        });
    }
}
