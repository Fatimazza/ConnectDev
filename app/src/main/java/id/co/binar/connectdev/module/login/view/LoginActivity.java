package id.co.binar.connectdev.module.login.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.module.main.view.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private ImageView facebookButton;

    private String[] permissions = {"public_profile"};
    private CallbackManager facebookCallbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        facebookButton = (ImageView) findViewById(R.id.facebook_login_button);
        facebookButton.setOnClickListener(onFacebookClicked);

        facebookCallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(facebookCallbackManager, facebookCallback);
    }

    @Override
    protected void onStart() {
        super.onStart();
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if (accessToken != null) {
            routeToMain();
        }
    }

    private View.OnClickListener onFacebookClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList(permissions));
        }
    };

    private FacebookCallback<LoginResult> facebookCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            routeToMain();
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onError(FacebookException e) {
            Toast.makeText(LoginActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    private void routeToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            facebookCallbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }
}
