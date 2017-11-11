package id.co.binar.connectdev.module.profile.model;

import id.co.binar.connectdev.network.model.FriendResponse;

/**
 * Created by rioswarawan on 11/10/17.
 */

public class Profile {

    public boolean self;
    public boolean friend;

    public String github;
    public String linkedin;
    public String dribble;

    // Parse here
    public FriendResponse profile;
}
