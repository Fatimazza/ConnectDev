package id.co.binar.connectdev.network;

import id.co.binar.connectdev.module.profile.model.Profile;
import id.co.binar.connectdev.network.model.Friend;
import id.co.binar.connectdev.network.model.SearchFriend;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by rioswarawan on 11/8/17.
 */

public interface RestApi {

    @POST("/search")
    Call<SearchFriend> getNearestFriend();

    @GET("/profile")
    Call<Profile> getProfile();

}
