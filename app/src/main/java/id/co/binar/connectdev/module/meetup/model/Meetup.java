package id.co.binar.connectdev.module.meetup.model;

import java.util.List;

import id.co.binar.connectdev.network.model.Friend;

/**
 * Created by rioswarawan on 11/10/17.
 */

public class Meetup {

    public int id;
    public String title;
    public String place;
    public String date;
    public String timeRange;
    public List<Friend> users;
}
