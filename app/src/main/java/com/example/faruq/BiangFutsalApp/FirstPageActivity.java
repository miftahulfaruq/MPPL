package com.example.faruq.BiangFutsalApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.faruq.BiangFutsalApp.AccountActivity.LoginActivity;
import com.example.faruq.BiangFutsalApp.AccountActivity.Peringatan;

public class FirstPageActivity extends AppCompatActivity {

    private Button btn_lihat_list;
    private TextView masuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        //Mendeklarasikan Variable / Objek
        btn_lihat_list = (Button) findViewById(R.id.btn_lihat_list);
        btn_lihat_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NewsActivity.class));
            }
        });

        masuk = (TextView) findViewById(R.id.tv_masuk);
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Peringatan.class));
            }
        });
    }
}
