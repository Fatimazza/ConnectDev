package id.co.binar.connectdev.module.meetup.presenter;

import id.co.binar.connectdev.module.meetup.model.Meetup;
import id.co.binar.connectdev.network.NetworkService;
import id.co.binar.connectdev.network.RestApi;
import id.co.binar.connectdev.network.model.MeetupResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fatimazza on 11/9/17.
 */

public class MeetupPresenter {

    private RestApi restApi;

    public MeetupPresenter() {
        this.restApi = NetworkService.create();
    }

    public void getAllMeetup(final OnMeetupListener listener) {
        listener.showDialog();
        this.restApi.getMeetup().enqueue(new Callback<MeetupResponse>() {
            @Override
            public void onResponse(Call<MeetupResponse> call, Response<MeetupResponse> response) {
                listener.meetupFetched(response.body().meetup);
                listener.hideDialog();
            }

            @Override
            public void onFailure(Call<MeetupResponse> call, Throwable t) {
                listener.onError(t.getLocalizedMessage());
                listener.hideDialog();
            }
        });
    }
}
