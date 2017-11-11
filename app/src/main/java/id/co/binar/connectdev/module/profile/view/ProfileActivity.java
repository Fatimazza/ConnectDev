package id.co.binar.connectdev.module.profile.view;


import android.app.ProgressDialog;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.login.LoginManager;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.cache.CacheKey;
import id.co.binar.connectdev.cache.GlobalCache;
import id.co.binar.connectdev.components.toolbar.SimpleToolbar;
import id.co.binar.connectdev.components.toolbar.SimpleToolbarListener;
import id.co.binar.connectdev.module.login.view.LoginActivity;
import id.co.binar.connectdev.module.profile.model.Profile;
import id.co.binar.connectdev.module.profile.presenter.OnLoadProfileListener;
import id.co.binar.connectdev.module.profile.presenter.ProfilePresenter;
import id.co.binar.connectdev.module.profile.view.dialog.FriendRequestDialog;
import id.co.binar.connectdev.module.profile.view.dialog.FriendRequestListener;
import id.co.binar.connectdev.module.profile.view.dialog.FriendRequestSentDialog;
import id.co.binar.connectdev.network.model.FriendResponse;
import id.co.binar.connectdev.tools.ActivityUtils;

public class ProfileActivity extends AppCompatActivity {

    public static final String paramKey = ProfileActivity.class.getName();

    private SimpleToolbar toolbar;
    private TextView textName, textSkill, textDistance, textTotalFriend;
    private TextView textPhone, textEmail, textCity;
    private TextView textUserAbout, textUserInterest, textUserSkill;
    private ImageView imageProfile, imageDribble, imageLinkedin, imageGithub;
    private Button buttonAddFriend, buttonChat, buttonLogout;

    private Profile profile;
    private ProfilePresenter presenter;
    private FriendRequestDialog friendRequestDialog;
    private FriendRequestSentDialog friendRequestSentDialog;

    private ProgressDialog dialog;

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
        buttonLogout = (Button) findViewById(R.id.button_logout);

        imageLinkedin.setOnClickListener(onLinkedinClicked);
        imageGithub.setOnClickListener(onGithubClicked);
        buttonAddFriend.setOnClickListener(onAddFriendClicked);
        buttonChat.setOnClickListener(onChatClicked);
        buttonLogout.setOnClickListener(onLogoutClicked);

        toolbar.setListener(simpleToolbarListener);
        toolbar.setName("Profile");

        friendRequestDialog = new FriendRequestDialog(this, friendRequestListener);
        friendRequestSentDialog = new FriendRequestSentDialog(this);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Brewing the coffee...");

        presenter = new ProfilePresenter();

        if (profile.self) {
            presenter.getProfile(onLoadProfileListener);
        } else {

            Glide.with(ProfileActivity.this)
                    .load(profile.profile.photo)
                    .into(imageProfile);

            textName.setText(profile.profile.name);
            textSkill.setText(profile.profile.skill);
            textTotalFriend.setText(profile.profile.friends + " Friend(s)");
            textEmail.setText(profile.profile.email);
            textPhone.setText(profile.profile.phone);
            textCity.setText(profile.profile.city);

            textUserAbout.setText(profile.profile.about);
            textUserInterest.setText(profile.profile.interest);
            textUserSkill.setText(profile.profile.skill);

            profile.github = profile.profile.github;
            profile.linkedin = profile.profile.linkedin;

            imageDribble.setVisibility(View.GONE);
        }

        configureProfile();
    }

    private void configureProfile() {

        if (profile.self) {
            toolbar.edit(true);
            buttonAddFriend.setVisibility(View.GONE);
            buttonChat.setVisibility(View.GONE);
            textDistance.setVisibility(View.GONE);
        } else {
            toolbar.edit(false);
            buttonAddFriend.setVisibility(profile.friend ? View.GONE : View.VISIBLE);
            buttonLogout.setVisibility(View.GONE);
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

    private OnLoadProfileListener onLoadProfileListener = new OnLoadProfileListener() {
        @Override
        public void profileFetched(FriendResponse friendResponse) {
            String userId = GlobalCache.read(CacheKey.facebookUserId, String.class);
            String facebookPhoto = "https://graph.facebook.com/" + userId + "/picture?type=large";
            Glide.with(ProfileActivity.this)
                    .load(facebookPhoto)
                    .into(imageProfile);

            textName.setText(friendResponse.name);
            textSkill.setText(friendResponse.skill);
            textTotalFriend.setText(friendResponse.friends + " Friend(s)");
            textEmail.setText(friendResponse.email);
            textPhone.setText(friendResponse.phone);
            textCity.setText(friendResponse.city);

            textUserAbout.setText(friendResponse.about);
            textUserInterest.setText(friendResponse.interest);
            textUserSkill.setText(friendResponse.skill);

            profile.github = friendResponse.github;
            profile.linkedin = friendResponse.linkedin;

            imageDribble.setVisibility(View.GONE);
        }

        @Override
        public void onError(String message) {

        }

        @Override
        public void showDialog() {
            dialog.show();
        }

        @Override
        public void hideDialog() {
            dialog.dismiss();
        }
    };

    private View.OnClickListener onLogoutClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LoginManager.getInstance().logOut();
            ActivityUtils.returnClearTop(ProfileActivity.this, LoginActivity.class);
        }
    };

    private View.OnClickListener onChatClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ActivityUtils.startActivityUrl(ProfileActivity.this, "fb-messenger://user/10212289936858364");
        }
    };

    private View.OnClickListener onAddFriendClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            friendRequestDialog.getDialog().show();
        }
    };

    private View.OnClickListener onGithubClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ActivityUtils.startActivityUrl(ProfileActivity.this, profile.github);
        }
    };

    private View.OnClickListener onLinkedinClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ActivityUtils.startActivityUrl(ProfileActivity.this, profile.linkedin);
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
