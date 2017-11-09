package id.co.binar.connectdev.components.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import id.co.binar.connectdev.R;

/**
 * Created by rioswarawan on 11/9/17.
 */

public class Toolbar extends LinearLayout {

    private View rootView;
    private ImageView imageNotification, imageProfile;

    private ToolbarListener listener;

    public Toolbar(Context context) {
        super(context);
        init(context);
    }

    public Toolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.view_toolbar, this, true);
        this.imageNotification = (ImageView) rootView.findViewById(R.id.image_notification);
        this.imageProfile = (ImageView) rootView.findViewById(R.id.image_profile);
    }

    public void setListener(ToolbarListener listener) {
        this.listener = listener;
        this.imageNotification.setOnClickListener(onNotificationClicked);
        this.imageProfile.setOnClickListener(onProfileClicked);
    }

    public void setProfileImage(String image) {
        Glide.with(getContext())
                .load(image)
                .into(imageProfile);
    }

    private OnClickListener onNotificationClicked = new OnClickListener() {
        @Override
        public void onClick(View view) {
            listener.onNotificationClicked();
        }
    };

    private OnClickListener onProfileClicked = new OnClickListener() {
        @Override
        public void onClick(View view) {
            listener.onProfileClicked();
        }
    };
}
