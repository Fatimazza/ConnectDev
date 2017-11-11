package id.co.binar.connectdev.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rioswarawan on 11/9/17.
 */

public class FriendResponse {

    public String name;
    public String photo;
    public String email;
    public String skill;
    public String interest;
    public String about;
    public Integer friends;
    public String city;
    public String phone;
    public String github;
    public String linkedin;

    @SerializedName("lat")
    public Double lattitude;
    @SerializedName("long")
    public Double longitude;

    public int distance;
    public boolean isFriend;
}
