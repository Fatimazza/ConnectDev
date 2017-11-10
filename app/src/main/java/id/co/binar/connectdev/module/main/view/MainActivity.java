package id.co.binar.connectdev.module.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.components.bottombar.BottomBar;
import id.co.binar.connectdev.components.bottombar.BottomBarListener;
import id.co.binar.connectdev.module.find.view.FindFragment;
import id.co.binar.connectdev.module.meetup.view.MeetupFragment;
import id.co.binar.connectdev.tools.FragmentUtils;

/**
 * Created by rioswarawan on 11/8/17.
 */

public class MainActivity extends AppCompatActivity {

    private BottomBar bottomBar;
    private FrameLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        container = (FrameLayout) findViewById(R.id.container);
        bottomBar = (BottomBar) findViewById(R.id.bottom_bar);
        bottomBar.setListener(bottomBarListener);
        bottomBar.selectBar(0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
        System.exit(0);
    }

    private BottomBarListener bottomBarListener = new BottomBarListener() {
        @Override
        public void onFindSelected() {
            FragmentUtils.startFragment(MainActivity.this, new FindFragment(), R.id.container);
        }

        @Override
        public void onMeetupSelected() {
            FragmentUtils.startFragment(MainActivity.this, new MeetupFragment(), R.id.container);
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
