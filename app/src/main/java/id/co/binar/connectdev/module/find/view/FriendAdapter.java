package id.co.binar.connectdev.module.find.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.network.model.Friend;

/**
 * Created by rioswarawan on 11/9/17.
 */

public class FriendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Friend> friends;
    private LayoutInflater inflater;
    private OnFriendItemClickListener onFriendItemClickListener;

    public FriendAdapter(Context context, List<Friend> friends, OnFriendItemClickListener onFriendItemClickListener) {
        this.context = context;
        this.friends = friends;
        this.inflater = LayoutInflater.from(context);
        this.onFriendItemClickListener = onFriendItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_friend, parent, false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        FriendViewHolder viewHolder = (FriendViewHolder) holder;
        Friend friend = friends.get(position);

        // add data to view
        viewHolder.name.setText(friend.name);
        viewHolder.skill.setText(friend.skill);
        viewHolder.distance.setText(friend.distance + " m");
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFriendItemClickListener.onFriendClicked(position);
            }
        });

        Glide.with(context)
                .load("https://randomuser.me/api/portraits/med/women/71.jpg")
                .into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    class FriendViewHolder extends RecyclerView.ViewHolder {

        LinearLayout layout;
        TextView name, skill, distance;
        ImageView image;

        public FriendViewHolder(View itemView) {
            super(itemView);

            layout = (LinearLayout) itemView.findViewById(R.id.layout);
            image = (ImageView) itemView.findViewById(R.id.image_profile);
            name = (TextView) itemView.findViewById(R.id.text_name);
            skill = (TextView) itemView.findViewById(R.id.text_skill);
            distance = (TextView) itemView.findViewById(R.id.text_distance);
        }
    }
}
