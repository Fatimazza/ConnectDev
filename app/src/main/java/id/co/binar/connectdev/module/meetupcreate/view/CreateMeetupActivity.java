package id.co.binar.connectdev.module.meetupcreate.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.module.meetup.view.dialog.CreateMeetupDialog;

/**
 * Created by rioswarawan on 11/11/17.
 */

public class CreateMeetupActivity extends AppCompatActivity {

    private Button addPhoto, addCreate;
    private ImageView featuredImage, imageUser1, imageUser2, imageUser3;

    private CreateMeetupDialog createMeetupDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meetup);

        addPhoto = (Button) findViewById(R.id.button_add_photo);
        addCreate = (Button) findViewById(R.id.button_create);
        featuredImage = (ImageView) findViewById(R.id.featured_image);
        imageUser1 = (ImageView) findViewById(R.id.image_user_1);
        imageUser2 = (ImageView) findViewById(R.id.image_user_2);
        imageUser3 = (ImageView) findViewById(R.id.image_user_3);
        addCreate = (Button) findViewById(R.id.button_create);


        createMeetupDialog = new CreateMeetupDialog(this);
        configure();

        addPhoto.setOnClickListener(onAddPhotoClicked);
        addCreate.setOnClickListener(onCreateClicked);
    }

    private void configure() {
        Glide.with(CreateMeetupActivity.this)
                .load("https://randomuser.me/api/portraits/med/men/55.jpg")
                .into(imageUser1);
        Glide.with(CreateMeetupActivity.this)
                .load("https://randomuser.me/api/portraits/med/women/10.jpg")
                .into(imageUser2);
        Glide.with(CreateMeetupActivity.this)
                .load("https://randomuser.me/api/portraits/med/men/10.jpg")
                .into(imageUser3);
    }

    private View.OnClickListener onAddPhotoClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Glide.with(CreateMeetupActivity.this)
                    .load("")
                    .placeholder(R.drawable.logo_react)
                    .into(featuredImage);
        }
    };

    private View.OnClickListener onCreateClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            createMeetupDialog.show();
        }
    };
}
