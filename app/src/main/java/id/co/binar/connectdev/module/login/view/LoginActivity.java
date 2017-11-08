package id.co.binar.connectdev.module.login.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import id.co.binar.connectdev.R;
import id.co.binar.connectdev.module.login.presenter.LoginPresenter;
import id.co.binar.connectdev.module.login.presenter.OnLoginPresent;

public class LoginActivity extends AppCompatActivity {

    private ImageView facebookButton;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(loginView);

        facebookButton = (ImageView) findViewById(R.id.facebook_login_button);
        facebookButton.setOnClickListener(onFacebookClicked);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    private View.OnClickListener onFacebookClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.facebookSignIn();
        }
    };

    private OnLoginView loginView = new OnLoginView() {
        @Override
        public void onLoginSuccess() {
            // TODO: 11/8/17 Show Main Features
        }

        @Override
        public void onError(String message) {
            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };
}
