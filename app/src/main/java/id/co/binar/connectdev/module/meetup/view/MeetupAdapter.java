package id.co.binar.connectdev.module.meetup.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.module.meetup.model.Meetup;

/**
 * Created by rioswarawan on 11/9/17.
 */

public class MeetupAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Meetup> meetups;
    private LayoutInflater inflater;
    private OnMeetupItemListener onMeetupItemListener;

    private int totalUser = 5;

    public MeetupAdapter(Context context, List<Meetup> meetups, OnMeetupItemListener onMeetupItemListener) {
        this.context = context;
        this.meetups = meetups;
        this.inflater = LayoutInflater.from(context);
        this.onMeetupItemListener = onMeetupItemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_meetup, parent, false);
        return new MeetupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MeetupViewHolder viewHolder = (MeetupViewHolder) holder;
        Meetup meetup = meetups.get(position);

        // add data to view
        viewHolder.title.setText(meetup.name);
        viewHolder.place.setText(meetup.place);
        viewHolder.date.setText(meetup.date);
        viewHolder.timeRange.setText(meetup.waktu);

        for (int i = 0; i < totalUser; i++) {
            if (i == 0) {
                Glide.with(context)
                        .load("https://randomuser.me/api/portraits/med/women/71.jpg")
                        .into(viewHolder.imageUser1);
            } else if (i == 1) {
                Glide.with(context)
                        .load("https://randomuser.me/api/portraits/med/women/71.jpg")
                        .into(viewHolder.imageUser2);
            } else if (i == 2) {
                Glide.with(context)
                        .load("https://randomuser.me/api/portraits/med/women/71.jpg")
                        .into(viewHolder.imageUser3);
            }
        }

        if (totalUser - 3 != 0) {
            String count = String.valueOf(totalUser - 3);
            viewHolder.more.setText("+" + count);
        }

        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMeetupItemListener.onSelect(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return meetups.size();
    }

    class MeetupViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        TextView title, place, date, timeRange, more;
        ImageView imageUser1, imageUser2, imageUser3;

        public MeetupViewHolder(View itemView) {
            super(itemView);

            card = (CardView) itemView.findViewById(R.id.card);
            imageUser1 = (ImageView) itemView.findViewById(R.id.image_user_1);
            imageUser2 = (ImageView) itemView.findViewById(R.id.image_user_2);
            imageUser3 = (ImageView) itemView.findViewById(R.id.image_user_3);
            title = (TextView) itemView.findViewById(R.id.text_title);
            place = (TextView) itemView.findViewById(R.id.text_place);
            date = (TextView) itemView.findViewById(R.id.text_date);
            timeRange = (TextView) itemView.findViewById(R.id.text_time_range);
            more = (TextView) itemView.findViewById(R.id.text_more_people);
        }
    }
}
