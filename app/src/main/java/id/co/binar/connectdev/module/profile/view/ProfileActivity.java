package id.co.binar.connectdev.module.profile.view;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import id.co.binar.connectdev.R;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivAvatar;
    private ImageView ivOnlineIndicator;

    private TextView tvDistance;
    private TextView tvFullname;
    private TextView tvSkill;

    private TextView tvEmail;
    private TextView tvHandphone;
    private TextView tvCity;

    private LinearLayout llSocial;
    private LinearLayout llSocialEdit;

    private EditText etAbout;
    private EditText etInterest;
    private EditText etSkill;

    private EditText etGithub;
    private EditText etLinkedin;

    private Button btnFriends;
    private Button btnAddFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();
        setListener();
    }

    private void initView() {
        ivAvatar = (ImageView) findViewById(R.id.img_avatar);
        ivOnlineIndicator = (ImageView) findViewById(R.id.iv_online_indicator);

        tvDistance = (TextView) findViewById(R.id.tv_distance);
        tvFullname = (TextView) findViewById(R.id.tv_name);
        tvSkill = (TextView) findViewById(R.id.tv_skill);
        tvEmail = (TextView) findViewById(R.id.tv_email);
        tvHandphone = (TextView) findViewById(R.id.tv_handphone);
        tvCity = (TextView) findViewById(R.id.tv_city);

        llSocial = (LinearLayout) findViewById(R.id.ll_social);
        llSocialEdit = (LinearLayout) findViewById(R.id.ll_social_edit);

        etAbout = (EditText) findViewById(R.id.et_about);
        etInterest = (EditText) findViewById(R.id.et_interest);
        etSkill = (EditText) findViewById(R.id.et_skill);
        etGithub = (EditText) findViewById(R.id.et_github);
        etLinkedin = (EditText) findViewById(R.id.et_linkedin);

        btnFriends = (Button) findViewById(R.id.btn_friends);
        btnAddFriend = (Button) findViewById(R.id.btn_add_friend);
    }

    private void setListener() {
        btnFriends.setOnClickListener(this);
        btnAddFriend.setOnClickListener(this);
    }

    private void editProfile() {
        llSocial.setVisibility(View.GONE);
        llSocialEdit.setVisibility(View.VISIBLE);
        etAbout.setEnabled(true);
        etInterest.setEnabled(true);
        etSkill.setEnabled(true);
        btnAddFriend.setVisibility(View.GONE);
    }

    private void saveProfile() {
        llSocial.setVisibility(View.VISIBLE);
        llSocialEdit.setVisibility(View.GONE);
        etAbout.setEnabled(false);
        etInterest.setEnabled(false);
        etSkill.setEnabled(false);
        btnAddFriend.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_friends:
                saveProfile();
                break;
            case R.id.btn_add_friend:
                editProfile();
                break;
        }
    }

    private OnLoadProfileView loadProfileView = new OnLoadProfileView() {
        @Override
        public void onLoadProfileSucces() {
            // TODO: 11/8/17 Show Profile
            Toast.makeText(ProfileActivity.this, "Success", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLoadProfileError(String message) {

        }
    };
}
