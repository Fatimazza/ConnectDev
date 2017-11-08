package id.co.binar.connectdev.module.profile.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import id.co.binar.connectdev.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    private OnLoadProfileView loadProfileView = new OnLoadProfileView() {
        @Override
        public void onLoadProfileSucces() {
            // TODO: 11/8/17 Show Profile
            Toast.makeText(ProfileActivity.this, "Success", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLoadProfileError(String message) {

        }
    };
}
