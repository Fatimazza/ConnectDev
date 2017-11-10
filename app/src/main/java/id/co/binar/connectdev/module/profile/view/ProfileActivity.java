package id.co.binar.connectdev.module.profile.view;


import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.components.toolbar.SimpleToolbar;
import id.co.binar.connectdev.components.toolbar.SimpleToolbarListener;
import id.co.binar.connectdev.module.profile.model.Profile;
import id.co.binar.connectdev.module.profile.view.dialog.FriendRequestDialog;
import id.co.binar.connectdev.module.profile.view.dialog.FriendRequestListener;
import id.co.binar.connectdev.module.profile.view.dialog.FriendRequestSentDialog;
import id.co.binar.connectdev.tools.ActivityUtils;

public class ProfileActivity extends AppCompatActivity {

    public static final String paramKey = ProfileActivity.class.getName();

    private SimpleToolbar toolbar;
    private TextView textName, textSkill, textDistance, textTotalFriend;
    private TextView textPhone, textEmail, textCity;
    private TextView textUserAbout, textUserInterest, textUserSkill;
    private ImageView imageProfile, imageDribble, imageLinkedin, imageGithub;
    private Button buttonAddFriend;
    private Button buttonChat;

    private Profile profile;
    private FriendRequestDialog friendRequestDialog;
    private FriendRequestSentDialog friendRequestSentDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile = ActivityUtils.getParam(this, paramKey, Profile.class);

        toolbar = (SimpleToolbar) findViewById(R.id.toolbar);
        textName = (TextView) findViewById(R.id.text_name);
        textSkill = (TextView) findViewById(R.id.text_skill);
        textDistance = (TextView) findViewById(R.id.text_distance);
        textTotalFriend = (TextView) findViewById(R.id.text_total_friend);
        textPhone = (TextView) findViewById(R.id.text_phone);
        textEmail = (TextView) findViewById(R.id.text_email);
        textCity = (TextView) findViewById(R.id.text_city);
        textUserAbout = (TextView) findViewById(R.id.text_user_about);
        textUserInterest = (TextView) findViewById(R.id.text_user_interest);
        textUserSkill = (TextView) findViewById(R.id.text_user_skill);
        imageProfile = (ImageView) findViewById(R.id.image_profile);
        imageDribble = (ImageView) findViewById(R.id.image_dribble);
        imageLinkedin = (ImageView) findViewById(R.id.image_linkedin);
        imageGithub = (ImageView) findViewById(R.id.image_github);
        buttonAddFriend = (Button) findViewById(R.id.button_add_friend);
        buttonChat = (Button) findViewById(R.id.button_chat);

        buttonAddFriend.setOnClickListener(onAddFriendClicked);
        buttonChat.setOnClickListener(onChatClicked);

        toolbar.setListener(simpleToolbarListener);
        toolbar.setName("Profile");

        friendRequestDialog = new FriendRequestDialog(this, friendRequestListener);
        friendRequestSentDialog = new FriendRequestSentDialog(this);

        configureProfile();
    }

    private void configureProfile() {

        if (profile.self) {
            toolbar.edit(true);
            buttonAddFriend.setVisibility(View.GONE);
            buttonChat.setVisibility(View.GONE);
        } else {
            toolbar.edit(false);
            buttonAddFriend.setVisibility(profile.friend ? View.GONE : View.VISIBLE);
        }
    }

    private SimpleToolbarListener simpleToolbarListener = new SimpleToolbarListener() {
        @Override
        public void onDestroy() {
            onBackPressed();
        }

        @Override
        public void onEdit() {

        }
    };

    private View.OnClickListener onChatClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ActivityUtils.startActivityUrl(ProfileActivity.this, "fb://messaging/24353623");
        }
    };

    private View.OnClickListener onAddFriendClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            friendRequestDialog.getDialog().show();
        }
    };

    private FriendRequestListener friendRequestListener = new FriendRequestListener() {
        @Override
        public void onRequestSent() {
            friendRequestDialog.getDialog().dismiss();
            friendRequestSentDialog.show();
        }
    };
}
