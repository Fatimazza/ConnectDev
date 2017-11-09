package id.co.binar.connectdev.module.find.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.components.toolbar.Toolbar;

/**
 * Created by rioswarawan on 11/9/17.
 */

public class FindFragment extends Fragment {

    private Toolbar toolbar;
    private EditText inputSearch;
    private RecyclerView recyclerUser;
    private TextView textAdvancedSearch;
    private ImageView imageSearch;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_find, container, false);

        toolbar = (Toolbar) contentView.findViewById(R.id.toolbar);
        inputSearch = (EditText) contentView.findViewById(R.id.input_search);
        recyclerUser = (RecyclerView) contentView.findViewById(R.id.recycler_user);
        textAdvancedSearch = (TextView) contentView.findViewById(R.id.text_advanced_search);
        imageSearch = (ImageView) contentView.findViewById(R.id.image_search);

        toolbar.setProfileImage("https://randomuser.me/api/portraits/med/women/71.jpg");
        textAdvancedSearch.setOnClickListener(onAdvanceSearchClicked);
        imageSearch.setOnClickListener(onSearchClicked);

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
}
