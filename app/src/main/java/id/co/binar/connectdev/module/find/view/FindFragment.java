package id.co.binar.connectdev.module.find.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.components.toolbar.Toolbar;
import id.co.binar.connectdev.components.toolbar.ToolbarListener;
import id.co.binar.connectdev.module.find.presenter.FindFriendPresenter;
import id.co.binar.connectdev.module.find.presenter.OnFindFriendListener;
import id.co.binar.connectdev.module.profile.view.ProfileActivity;
import id.co.binar.connectdev.network.model.Friend;
import id.co.binar.connectdev.tools.FragmentUtils;

/**
 * Created by rioswarawan on 11/9/17.
 */

public class FindFragment extends Fragment {

    private Toolbar toolbar;
    private EditText inputSearch;
    private TextView textAdvancedSearch;
    private ImageView imageSearch;
    private RecyclerView recyclerUser;

    private FindFriendPresenter presenter;
    private List<Friend> friends;
    private FriendAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_find, container, false);

        inputSearch = (EditText) contentView.findViewById(R.id.input_search);

        imageSearch = (ImageView) contentView.findViewById(R.id.image_search);
        imageSearch.setOnClickListener(onSearchClicked);

        textAdvancedSearch = (TextView) contentView.findViewById(R.id.text_advanced_search);
        textAdvancedSearch.setOnClickListener(onAdvanceSearchClicked);

        toolbar = (Toolbar) contentView.findViewById(R.id.toolbar);
        toolbar.setListener(toolbarListener);
        toolbar.setProfileImage("https://randomuser.me/api/portraits/med/women/71.jpg");

        friends = new ArrayList<>();
        adapter = new FriendAdapter(getActivity(), friends, onFriendItemClickListener);
        recyclerUser = (RecyclerView) contentView.findViewById(R.id.recycler_user);
        recyclerUser.setAdapter(adapter);
        recyclerUser.setLayoutManager(new LinearLayoutManager(getActivity()));

        presenter = new FindFriendPresenter();
        presenter.getNearestFriend(onFindFriendListener);

        return contentView;
    }

    private ToolbarListener toolbarListener = new ToolbarListener() {
        @Override
        public void onNotificationClicked() {

        }

        @Override
        public void onProfileClicked() {

        }
    };

    private View.OnClickListener onAdvanceSearchClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private View.OnClickListener onSearchClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private OnFindFriendListener onFindFriendListener = new OnFindFriendListener() {
        @Override
        public void friendFetched(List<Friend> friends) {
            FindFragment.this.friends.addAll(friends);
            FindFragment.this.adapter.notifyDataSetChanged();
        }

        @Override
        public void onError(String message) {
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    };

    private OnFriendItemClickListener onFriendItemClickListener = new OnFriendItemClickListener() {
        @Override
        public void onFriendClicked(int position) {

        }
    };
}