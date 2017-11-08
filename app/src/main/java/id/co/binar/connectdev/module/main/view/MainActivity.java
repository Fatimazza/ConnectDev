package id.co.binar.connectdev.module.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.components.bottombar.BottomBar;
import id.co.binar.connectdev.components.bottombar.BottomBarListener;

/**
 * Created by rioswarawan on 11/8/17.
 */

public class MainActivity extends AppCompatActivity {

    private BottomBar bottomBar;
    private FrameLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (FrameLayout) findViewById(R.id.container);
        bottomBar = (BottomBar) findViewById(R.id.bottom_bar);
        bottomBar.setListener(bottomBarListener);
    }

    private BottomBarListener bottomBarListener = new BottomBarListener() {
        @Override
        public void onFindSelected() {
            Toast.makeText(MainActivity.this, "A", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onMeetupSelected() {
            Toast.makeText(MainActivity.this, "B", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onChatSelected() {
            Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFriendSelected() {
            Toast.makeText(MainActivity.this, "D", Toast.LENGTH_SHORT).show();
        }
    };
}
