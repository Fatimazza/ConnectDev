package id.co.binar.connectdev.module.launcher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;

import id.co.binar.connectdev.module.login.view.LoginActivity;
import id.co.binar.connectdev.module.main.view.MainActivity;

/**
 * Created by rioswarawan on 11/9/17.
 */

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AccessToken token = AccessToken.getCurrentAccessToken();
        startActivity(new Intent(this, null != token ? MainActivity.class : LoginActivity.class));
        finish();
    }
}
