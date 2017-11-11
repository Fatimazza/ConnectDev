package id.co.binar.connectdev.module.find.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.components.layoutmanager.NonScrollableLinearLayoutManager;
import id.co.binar.connectdev.module.find.presenter.FindFriendPresenter;
import id.co.binar.connectdev.module.find.presenter.OnFindFriendListener;
import id.co.binar.connectdev.module.profile.model.Profile;
import id.co.binar.connectdev.module.profile.view.ProfileActivity;
import id.co.binar.connectdev.network.model.FriendResponse;
import id.co.binar.connectdev.tools.ActivityUtils;

/**
 * Created by rioswarawan on 11/9/17.
 */

public class FindFragment extends Fragment {

    private EditText inputSearch;
    private TextView textAdvancedSearch;
    private ImageView imageSearch;
    private RecyclerView recyclerUser;

    private FindFriendPresenter presenter;
    private List<FriendResponse> friendResponses;
    private FriendAdapter adapter;

    private ProgressDialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_find, container, false);

        inputSearch = (EditText) contentView.findViewById(R.id.input_search);
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(inputSearch.getWindowToken(), 0);
        }

        imageSearch = (ImageView) contentView.findViewById(R.id.image_search);
        imageSearch.setOnClickListener(onSearchClicked);

        textAdvancedSearch = (TextView) contentView.findViewById(R.id.text_advanced_search);
        textAdvancedSearch.setOnClickListener(onAdvanceSearchClicked);

        friendResponses = new ArrayList<>();
        adapter = new FriendAdapter(getActivity(), friendResponses, onFriendItemClickListener);
        recyclerUser = (RecyclerView) contentView.findViewById(R.id.recycler_user);
        recyclerUser.setAdapter(adapter);
        recyclerUser.setLayoutManager(new NonScrollableLinearLayoutManager(getActivity()));

        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Brewing the coffee...");

        presenter = new FindFriendPresenter();
        presenter.getNearestFriend(onFindFriendListener);

        return contentView;
    }

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
        public void friendFetched(List<FriendResponse> friendResponses) {
            if (friendResponses != null) {
                FindFragment.this.friendResponses.addAll(friendResponses);
                FindFragment.this.adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onError(String message) {
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
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

    private OnFriendItemClickListener onFriendItemClickListener = new OnFriendItemClickListener() {
        @Override
        public void onFriendClicked(int position) {
            Profile profile = new Profile();
            profile.self = false;
            profile.friend = position % 2 == 0;

            ActivityUtils.startActivityWParam(getActivity(), ProfileActivity.class, ProfileActivity.paramKey, profile);
        }
    };
}
