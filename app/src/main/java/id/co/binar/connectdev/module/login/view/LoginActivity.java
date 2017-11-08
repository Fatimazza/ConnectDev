package id.co.binar.connectdev.module.login.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import id.co.binar.connectdev.R;
import id.co.binar.connectdev.module.login.presenter.LoginPresenter;
import id.co.binar.connectdev.module.main.view.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private ImageView facebookButton;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this, loginView);

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
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        @Override
        public void onError(String message) {
            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
