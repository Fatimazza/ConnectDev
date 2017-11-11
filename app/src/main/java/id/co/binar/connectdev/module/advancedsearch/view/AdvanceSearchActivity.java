package id.co.binar.connectdev.module.advancedsearch.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.components.toolbar.SimpleToolbar;
import id.co.binar.connectdev.components.toolbar.SimpleToolbarListener;

/**
 * Created by rioswarawan on 11/11/17.
 */

public class AdvanceSearchActivity extends AppCompatActivity {

    private SimpleToolbar toolbar;
    private Button buttonSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);

        toolbar = (SimpleToolbar) findViewById(R.id.toolbar);

        toolbar.setListener(simpleToolbarListener);
        toolbar.setName("Advanced Search");
        toolbar.edit(false);

        buttonSearch = (Button) findViewById(R.id.button_search);
        buttonSearch.setOnClickListener(onSearchClicked);
    }

    private View.OnClickListener onSearchClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onBackPressed();
        }
    };

    private SimpleToolbarListener simpleToolbarListener = new SimpleToolbarListener() {
        @Override
        public void onDestroy() {
            onBackPressed();
        }

        @Override
        public void onEdit() {

        }
    };
}
