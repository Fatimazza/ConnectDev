package id.co.binar.connectdev.module.meetup.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.components.layoutmanager.NonScrollableLinearLayoutManager;
import id.co.binar.connectdev.module.meetup.model.Meetup;
import id.co.binar.connectdev.module.meetup.presenter.MeetupPresenter;
import id.co.binar.connectdev.module.meetup.presenter.OnMeetupListener;
import id.co.binar.connectdev.module.meetup.view.dialog.CreateMeetupDialog;
import id.co.binar.connectdev.module.meetupcreate.view.CreateMeetupActivity;
import id.co.binar.connectdev.module.meetupdetail.view.MeetupDetailActivity;
import id.co.binar.connectdev.tools.ActivityUtils;

/**
 * Created by rioswarawan on 11/10/17.
 */

public class MeetupFragment extends Fragment {

    private EditText inputSearch;
    private RecyclerView recyclerMeetup;
    private FloatingActionButton floatingActionButton;

    private List<Meetup> meetups;
    private MeetupAdapter adapter;

    private MeetupPresenter presenter;
    private ProgressDialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_meetup, container, false);

        meetups = new ArrayList<>();
        adapter = new MeetupAdapter(getActivity(), meetups, onMeetupItemListener);

        floatingActionButton = (FloatingActionButton) contentView.findViewById(R.id.button_add_meetup);
        inputSearch = (EditText) contentView.findViewById(R.id.input_search);
        recyclerMeetup = (RecyclerView) contentView.findViewById(R.id.recycler_meetup);
        recyclerMeetup.setAdapter(adapter);
        recyclerMeetup.setLayoutManager(new NonScrollableLinearLayoutManager(getActivity()));

        floatingActionButton.setOnClickListener(onFabClicked);

        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Brewing the coffee");

        presenter = new MeetupPresenter();
        presenter.getAllMeetup(onMeetupListener);

        return contentView;
    }

    private View.OnClickListener onFabClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ActivityUtils.startActivity(getActivity(), CreateMeetupActivity.class);
        }
    };

    private OnMeetupItemListener onMeetupItemListener = new OnMeetupItemListener() {
        @Override
        public void onSelect(int position) {
            Meetup meetup = meetups.get(position);

            ActivityUtils.startActivityWParam(getActivity(), MeetupDetailActivity.class, MeetupDetailActivity.paramKey, meetup);
        }
    };

    private OnMeetupListener onMeetupListener = new OnMeetupListener() {
        @Override
        public void meetupFetched(List<Meetup> meetups) {
            MeetupFragment.this.meetups.addAll(meetups);
            MeetupFragment.this.adapter.notifyDataSetChanged();
        }

        @Override
        public void onError(String message) {
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void showDialog() {
            dialog.show();
        }

        @Override
        public void hideDialog() {
            dialog.dismiss();
        }
    };
}
