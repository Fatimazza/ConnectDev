package id.co.binar.connectdev.components.bottombar;

import android.content.Context;
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

    private void state(ImageView baseIcon, int modifiedIcon, TextView text) {
        baseIcon.setImageDrawable(getContext().getDrawable(modifiedIcon));
        text.setTextColor(getContext().getColor(R.color.bottomBarTextActive));
    }

    private OnClickListener onFindClicked = new OnClickListener() {
        @Override
        public void onClick(View view) {
            state(imageFind, R.drawable.ic_find_active, textFind);
            state(imageMeetup, R.drawable.ic_meetup, textMeetup);
            state(imageChat, R.drawable.ic_chat, textChat);
            state(imageFriend, R.drawable.ic_friend, textFriend);

            listener.onFindSelected();
        }
    };

    private OnClickListener onMeetupClicked = new OnClickListener() {
        @Override
        public void onClick(View view) {
            state(imageFind, R.drawable.ic_find, textFind);
            state(imageMeetup, R.drawable.ic_find_active, textMeetup);
            state(imageChat, R.drawable.ic_chat, textChat);
            state(imageFriend, R.drawable.ic_friend, textFriend);

            listener.onMeetupSelected();
        }
    };

    private OnClickListener onChatClicked = new OnClickListener() {
        @Override
        public void onClick(View view) {
            state(imageFind, R.drawable.ic_find, textMeetup);
            state(imageMeetup, R.drawable.ic_meetup, textMeetup);
            state(imageChat, R.drawable.ic_find_active, textChat);
            state(imageFriend, R.drawable.ic_friend, textFriend);

            listener.onChatSelected();
        }
    };

    private OnClickListener onFriendClicked = new OnClickListener() {
        @Override
        public void onClick(View view) {
            state(imageFind, R.drawable.ic_find, textMeetup);
            state(imageMeetup, R.drawable.ic_meetup, textMeetup);
            state(imageChat, R.drawable.ic_chat, textChat);
            state(imageFriend, R.drawable.ic_find_active, textFriend);

            listener.onFriendSelected();
        }
    };
}
