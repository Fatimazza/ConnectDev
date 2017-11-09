package id.co.binar.connectdev.components.bottombar;

import android.content.Context;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import id.co.binar.connectdev.R;

/**
 * Created by rioswarawan on 11/8/17.
 */

public class BottomBar extends LinearLayout {

    private View rootView;
    private LinearLayout buttonFind;
    private LinearLayout buttonMeetup;
    private LinearLayout buttonChat;
    private LinearLayout buttonFriend;

    private ImageView imageFind;
    private ImageView imageMeetup;
    private ImageView imageChat;
    private ImageView imageFriend;

    private TextView textFind;
    private TextView textMeetup;
    private TextView textChat;
    private TextView textFriend;

    private BottomBarListener listener;

    public BottomBar(Context context) {
        super(context);
        init(context);
    }

    public BottomBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.view_bottombar, this, true);
        this.buttonFind = (LinearLayout) rootView.findViewById(R.id.button_find);
        this.buttonMeetup = (LinearLayout) rootView.findViewById(R.id.button_meetup);
        this.buttonChat = (LinearLayout) rootView.findViewById(R.id.button_chat);
        this.buttonFriend = (LinearLayout) rootView.findViewById(R.id.button_friend);

        this.imageFind = (ImageView) rootView.findViewById(R.id.image_find);
        this.imageMeetup = (ImageView) rootView.findViewById(R.id.image_meetup);
        this.imageChat = (ImageView) rootView.findViewById(R.id.image_chat);
        this.imageFriend = (ImageView) rootView.findViewById(R.id.image_friend);

        this.textFind = (TextView) rootView.findViewById(R.id.text_find);
        this.textMeetup = (TextView) rootView.findViewById(R.id.text_meetup);
        this.textChat = (TextView) rootView.findViewById(R.id.text_chat);
        this.textFriend = (TextView) rootView.findViewById(R.id.text_friend);
    }

    public void setListener(BottomBarListener listener) {
        this.listener = listener;
        this.buttonFind.setOnClickListener(onFindClicked);
        this.buttonMeetup.setOnClickListener(onMeetupClicked);
        this.buttonChat.setOnClickListener(onChatClicked);
        this.buttonFriend.setOnClickListener(onFriendClicked);
    }

    public void selectBar(int position) {
        if (position == 0) {
            buttonFind.performClick();
        } else if (position == 1) {
            buttonMeetup.performClick();
        } else if (position == 2) {
            buttonChat.performClick();
        } else if (position == 3) {
            buttonFriend.performClick();
        }
    }

    private void state(ImageView baseIcon, @DrawableRes int modifiedIcon, TextView text, @ColorRes int modifiedTextColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            baseIcon.setImageDrawable(getContext().getDrawable(modifiedIcon));
            text.setTextColor(getContext().getColor(modifiedTextColor));
        } else {
            baseIcon.setImageDrawable(getContext().getResources().getDrawable(modifiedIcon));
            text.setTextColor(getContext().getResources().getColor(modifiedTextColor));
        }
    }

    private OnClickListener onFindClicked = new OnClickListener() {
        @Override
        public void onClick(View view) {
            state(imageFind, R.drawable.ic_find_active, textFind, R.color.bottomBarTextActive);
            state(imageMeetup, R.drawable.ic_meetup, textMeetup, R.color.bottomBarText);
            state(imageChat, R.drawable.ic_chat, textChat, R.color.bottomBarText);
            state(imageFriend, R.drawable.ic_friend, textFriend, R.color.bottomBarText);

            listener.onFindSelected();
        }
    };

    private OnClickListener onMeetupClicked = new OnClickListener() {
        @Override
        public void onClick(View view) {
            state(imageFind, R.drawable.ic_find, textFind, R.color.bottomBarText);
            state(imageMeetup, R.drawable.ic_find_active, textMeetup, R.color.bottomBarTextActive);
            state(imageChat, R.drawable.ic_chat, textChat, R.color.bottomBarText);
            state(imageFriend, R.drawable.ic_friend, textFriend, R.color.bottomBarText);

            listener.onMeetupSelected();
        }
    };

    private OnClickListener onChatClicked = new OnClickListener() {
        @Override
        public void onClick(View view) {
            state(imageFind, R.drawable.ic_find, textMeetup, R.color.bottomBarText);
            state(imageMeetup, R.drawable.ic_meetup, textMeetup, R.color.bottomBarText);
            state(imageChat, R.drawable.ic_find_active, textChat, R.color.bottomBarTextActive);
            state(imageFriend, R.drawable.ic_friend, textFriend, R.color.bottomBarText);

            listener.onChatSelected();
        }
    };

    private OnClickListener onFriendClicked = new OnClickListener() {
        @Override
        public void onClick(View view) {
            state(imageFind, R.drawable.ic_find, textMeetup, R.color.bottomBarText);
            state(imageMeetup, R.drawable.ic_meetup, textMeetup, R.color.bottomBarText);
            state(imageChat, R.drawable.ic_chat, textChat, R.color.bottomBarText);
            state(imageFriend, R.drawable.ic_find_active, textFriend, R.color.bottomBarTextActive);

            listener.onFriendSelected();
        }
    };
}
