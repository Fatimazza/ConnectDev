package id.co.binar.connectdev.module.profile.view.dialog;

import android.app.Activity;
import android.app.Dialog;
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

public class FriendRequestDialog {

    private TextView textName, textSkill, textAbout, textDistance;
    private ImageView imageProfile;
    private EditText inputNote;
    private Button buttonSendRequest;
    private FriendRequestListener listener;
    private Dialog dialog;

    public FriendRequestDialog(Activity activity, FriendRequestListener listener) {
        this.listener = listener;
        this.dialog = new Dialog(activity);
        this.dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.dialog.setCancelable(true);
        this.dialog.setContentView(R.layout.dialog_add_friend);

        this.textName = (TextView) dialog.findViewById(R.id.text_name);
        this.textSkill = (TextView) dialog.findViewById(R.id.text_skill);
        this.textAbout = (TextView) dialog.findViewById(R.id.text_about);
        this.textDistance = (TextView) dialog.findViewById(R.id.text_distance);
        this.imageProfile = (ImageView) dialog.findViewById(R.id.image_profile);
        this.inputNote = (EditText) dialog.findViewById(R.id.input_add_note);
        this.buttonSendRequest = (Button) dialog.findViewById(R.id.button_add_send_request);

        this.buttonSendRequest.setOnClickListener(onSendRequestClicked);
    }

    public Dialog getDialog() {
        return dialog;
    }

    private View.OnClickListener onSendRequestClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            listener.onRequestSent();
        }
    };
}
