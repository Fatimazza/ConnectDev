package id.co.binar.connectdev.module.meetup.model;

import java.util.List;

import id.co.binar.connectdev.network.model.FriendResponse;

/**
 * Created by rioswarawan on 11/10/17.
 */

public class Meetup {

    public int id;
    public String name;
    public String desc;
    public String place;
    public String waktu;
    public String date;
    public List<FriendResponse> users;
}
