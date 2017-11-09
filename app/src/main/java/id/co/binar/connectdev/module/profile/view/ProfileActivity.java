package id.co.binar.connectdev.module.profile.view;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.module.profile.presenter.OnLoadProfileListener;
import id.co.binar.connectdev.module.profile.presenter.ProfilePresenter;
import id.co.binar.connectdev.network.model.Friend;

import static id.co.binar.connectdev.App.getContext;

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

    private ProfilePresenter profilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();
        setListener();

        profilePresenter = new ProfilePresenter();
        profilePresenter.getProfile(onLoadProfileListener);
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

    private OnLoadProfileListener onLoadProfileListener = new OnLoadProfileListener() {
        @Override
        public void profileFetched(Friend friend) {
            populateProfileData(friend);
        }

        @Override
        public void onError(String message) {
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    };

    private void populateProfileData(Friend friend) {
        tvDistance.setText(friend.distance+" m");
        tvFullname.setText(friend.name);
        tvSkill.setText(friend.skill);
        tvEmail.setText(friend.email);
        tvHandphone.setText(friend.phone);
        tvCity.setText(friend.city);
        etAbout.setText(friend.about);
        etSkill.setText(friend.skill);
        etInterest.setText(friend.interest);
        etGithub.setText(friend.github);
        etLinkedin.setText(friend.linkedin);
    }
}
