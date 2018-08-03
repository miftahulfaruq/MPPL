package com.example.faruq.BiangFutsalApp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class TambahLapanganActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri mImageUri;

    private EditText set_title, set_desc, set_image, set_url, set_cost, set_telp;
    private Button send, bt_gambar;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_lapangan);

        databaseReference = FirebaseDatabase.getInstance().getReference("News");

        set_title = (EditText) findViewById(R.id.lapangan_nama);
        set_desc = (EditText) findViewById(R.id.lapangan_alamat);
        set_cost = (EditText) findViewById(R.id.lapangan_cost);
        set_telp = (EditText) findViewById(R.id.lapangan_telp);

        bt_gambar = (Button) findViewById(R.id.bt_gambar);
        bt_gambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TambahLapanganActivity.this, "Data Has Been Send", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), NewsActivity.class));
                finish();
                addLapangan();
            }
        });

    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri = data.getData();
            addLapangan();
        }
    }

    public void addLapangan(){
//        Mengambil value inputan
        String title = set_title.getText().toString();
        String desc = set_desc.getText().toString();
        String image = "";
        String url = "";
        String cost = set_cost.getText().toString();
        String telp = set_telp.getText().toString();

        //Mengecek inputan kosong
        if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(desc)) {
            String id = databaseReference.push().getKey();

            //Menginpukan ke database
            News News = new News(title,desc, image, url, cost, telp);

            databaseReference.child(id).setValue(News);
            set_title.setText("");
            set_desc.setText("");
            set_image.setText("");
            set_url.setText("");
            set_cost.setText("");
            set_telp.setText("");
        } else {
            Toast.makeText(TambahLapanganActivity.this, "Please Type Students Name or Class", Toast.LENGTH_LONG).show();
        }
    }
}