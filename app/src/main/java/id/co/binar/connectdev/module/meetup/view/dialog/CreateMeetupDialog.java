package id.co.binar.connectdev.module.meetup.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.view.Window;

import id.co.binar.connectdev.R;

/**
 * Created by rioswarawan on 11/10/17.
 */

public class CreateMeetupDialog {

    private Activity activity;

    public CreateMeetupDialog(Activity activity) {
        this.activity = activity;
    }

    public void show() {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_create_meetup);
        dialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 1500);
    }
}
