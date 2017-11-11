package id.co.binar.connectdev.module.meetupdetail.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.components.toolbar.SimpleToolbar;
import id.co.binar.connectdev.components.toolbar.SimpleToolbarListener;

public class MeetupDetailActivity extends AppCompatActivity {

    public static final String paramKey = MeetupDetailActivity.class.getName();

    private SimpleToolbar toolbar;
    private TextView textTitle, textDate, textTimeRange, textUserMore;
    private ImageView featuredImage, imageUser1, imageUser2, imageUser3;
    private EditText inputAbout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetup_detail);

        toolbar = (SimpleToolbar) findViewById(R.id.toolbar);
        textTitle = (TextView) findViewById(R.id.text_title);
        textDate = (TextView) findViewById(R.id.text_date);
        textTimeRange = (TextView) findViewById(R.id.text_time_range);
        featuredImage = (ImageView) findViewById(R.id.image_profile);
        textUserMore = (TextView) findViewById(R.id.text_more_people);
        imageUser1 = (ImageView) findViewById(R.id.image_user_1);
        imageUser2 = (ImageView) findViewById(R.id.image_user_2);
        imageUser3 = (ImageView) findViewById(R.id.image_user_3);

        toolbar.setListener(simpleToolbarListener);
        toolbar.setName("Meetup");
        toolbar.edit(false);
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
