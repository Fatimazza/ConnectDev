package id.co.binar.connectdev.module.meetupdetail.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.components.toolbar.SimpleToolbar;
import id.co.binar.connectdev.components.toolbar.SimpleToolbarListener;
import id.co.binar.connectdev.module.meetup.model.Meetup;
import id.co.binar.connectdev.network.model.FriendResponse;
import id.co.binar.connectdev.tools.ActivityUtils;

public class MeetupDetailActivity extends AppCompatActivity {

    public static final String paramKey = MeetupDetailActivity.class.getName();

    private SimpleToolbar toolbar;
    private TextView textTitle, textDate, textTimeRange, textUserMore;
    private ImageView featuredImage, imageUser1, imageUser2, imageUser3;
    private EditText inputAbout;

    private Meetup meetup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetup_detail);

        meetup = ActivityUtils.getParam(this, paramKey, Meetup.class);

        toolbar = (SimpleToolbar) findViewById(R.id.toolbar);
        textTitle = (TextView) findViewById(R.id.text_title);
        textDate = (TextView) findViewById(R.id.text_date);
        textTimeRange = (TextView) findViewById(R.id.text_time_range);
        featuredImage = (ImageView) findViewById(R.id.featuredImage);
        textUserMore = (TextView) findViewById(R.id.text_more_people);
        imageUser1 = (ImageView) findViewById(R.id.image_user_1);
        imageUser2 = (ImageView) findViewById(R.id.image_user_2);
        imageUser3 = (ImageView) findViewById(R.id.image_user_3);
        inputAbout= (EditText) findViewById(R.id.input_about);

        toolbar.setListener(simpleToolbarListener);
        toolbar.setName("Meetup");
        toolbar.edit(false);

        configure();
    }

    private void configure() {
        textTitle.setText(meetup.name);
        textDate.setText(meetup.date);
        textTimeRange.setText(meetup.waktu);
        inputAbout.setText(meetup.desc);

        Glide.with(this)
                .load(meetup.photo)
                .into(featuredImage);

        for (int i = 0; i < 3; i++) {
            FriendResponse friendResponse = meetup.friend.get(i);
            if (i == 0) {
                Glide.with(this)
                        .load(friendResponse.photo)
                        .into(imageUser1);
            } else if (i == 1) {
                Glide.with(this)
                        .load(friendResponse.photo)
                        .into(imageUser2);
            } else if (i == 2) {
                Glide.with(this)
                        .load(friendResponse.photo)
                        .into(imageUser3);
            }
        }

        if (meetup.friend.size() - 3 > 0) {
            String count = String.valueOf(meetup.friend.size() - 3);
            textUserMore.setText("+" + count);
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
}
