package id.co.binar.connectdev.module.meetup.presenter;

import java.util.List;

import id.co.binar.connectdev.module.meetup.model.Meetup;

/**
 * Created by fatimazza on 11/9/17.
 */

public interface OnMeetupListener {

    void meetupFetched(List<Meetup> meetups);

    void onError(String message);

    void showDialog();

    void hideDialog();
}
