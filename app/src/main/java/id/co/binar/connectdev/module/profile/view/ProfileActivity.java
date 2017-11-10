package id.co.binar.connectdev.module.profile.view;


import android.support.annotation.Nullable;
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
import id.co.binar.connectdev.components.toolbar.SimpleToolbar;
import id.co.binar.connectdev.components.toolbar.SimpleToolbarListener;
import id.co.binar.connectdev.module.profile.presenter.OnLoadProfileListener;
import id.co.binar.connectdev.module.profile.presenter.ProfilePresenter;
import id.co.binar.connectdev.network.model.Friend;

import static id.co.binar.connectdev.App.getContext;

public class ProfileActivity extends AppCompatActivity {

    private SimpleToolbar toolbar;
    private TextView textName, textSkill, textDistance, textTotalFriend;
    private TextView textPhone, textEmail, textCity;
    private TextView textUserAbout, textUserInterest, textUserSkill;
    private ImageView imageProfile, imageDribble, imageLinkedin, imageGithub;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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

        toolbar.setListener(simpleToolbarListener);
        toolbar.setName("Profile");
    }

    private SimpleToolbarListener simpleToolbarListener = new SimpleToolbarListener() {
        @Override
        public void onDestroy() {
            finish();
        }
    };

    private View.OnClickListener onChatClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            
        }
    };

    private View.OnClickListener onAddFriendClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
}
