package id.co.binar.connectdev.module.profile.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.binar.connectdev.R;

/**
 * Created by rioswarawan on 11/10/17.
 */

public class FriendRequestSentDialog {

    private Activity activity;

    public FriendRequestSentDialog(Activity activity) {
        this.activity = activity;
    }

    public void show() {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_request_sent);
        dialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 1500);
    }
}
