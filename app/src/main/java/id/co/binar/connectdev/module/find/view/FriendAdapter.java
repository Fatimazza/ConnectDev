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
import id.co.binar.connectdev.network.model.FriendResponse;

/**
 * Created by rioswarawan on 11/9/17.
 */

public class FriendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<FriendResponse> friendResponses;
    private LayoutInflater inflater;
    private OnFriendItemClickListener onFriendItemClickListener;

    public FriendAdapter(Context context, List<FriendResponse> friendResponses, OnFriendItemClickListener onFriendItemClickListener) {
        this.context = context;
        this.friendResponses = friendResponses;
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
        FriendResponse friendResponse = friendResponses.get(position);

        // add data to view
        viewHolder.name.setText(friendResponse.name);
        viewHolder.skill.setText(friendResponse.skill);
        viewHolder.distance.setText(friendResponse.distance + " m");
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFriendItemClickListener.onFriendClicked(position);
            }
        });

        if (position % 4 == 0) {
            Glide.with(context)
                    .load("https://randomuser.me/api/portraits/med/women/71.jpg")
                    .into(viewHolder.image);
        } else if (position % 3 == 0) {
            Glide.with(context)
                    .load("https://randomuser.me/api/portraits/med/men/7.jpg")
                    .into(viewHolder.image);
        } else if (position % 2 == 0) {
            Glide.with(context)
                    .load("https://randomuser.me/api/portraits/med/men/22.jpg")
                    .into(viewHolder.image);
        } else if (position % 1 == 0) {
            Glide.with(context)
                    .load("https://randomuser.me/api/portraits/med/men/71.jpg")
                    .into(viewHolder.image);
        }
    }

    @Override
    public int getItemCount() {
        return friendResponses.size();
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
