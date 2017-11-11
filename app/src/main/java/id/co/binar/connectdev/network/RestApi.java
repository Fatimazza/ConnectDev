package id.co.binar.connectdev.network;

import id.co.binar.connectdev.module.meetup.model.Meetup;
import id.co.binar.connectdev.module.profile.model.Profile;
import id.co.binar.connectdev.network.model.MeetupResponse;
import id.co.binar.connectdev.network.model.SearchFriendResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by rioswarawan on 11/8/17.
 */

public interface RestApi {

    @POST("/search")
    Call<SearchFriendResponse> getNearestFriend();

    @GET("/profile")
    Call<Profile> getProfile();

    @GET("/meetup")
    Call<MeetupResponse> getMeetup();

}
