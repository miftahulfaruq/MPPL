package com.example.faruq.BiangFutsalApp.AccountActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.faruq.BiangFutsalApp.NewsActivity;
import com.example.faruq.BiangFutsalApp.R;

public class Peringatan extends AppCompatActivity {

    private Button pengelolah, user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peringatan);

        pengelolah = (Button) findViewById(R.id.bt_pengelolah);
        pengelolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });

        user = (Button) findViewById(R.id.bt_user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NewsActivity.class));
                finish();
            }
        });
    }
}
