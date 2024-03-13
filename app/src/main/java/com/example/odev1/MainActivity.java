package com.example.odev1;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar1, seekBar2;
    private EditText editTextNumber;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar1 = findViewById(R.id.seekBar);
        seekBar2 = findViewById(R.id.seekBar2);
        editTextNumber = findViewById(R.id.editTextNumber);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min = seekBar1.getProgress();
                int max = seekBar2.getProgress();

                Random random = new Random();
                int randomNumber = random.nextInt(max - min + 1) + min;

                ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "", "Yükleniyor...", true);
                progressDialog.setCancelable(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                        // İkinci sayfaya geçiş
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("randomNumber", randomNumber);
                        startActivity(intent);
                        finish();
                    }
                }, 1000);
            }
        });
    }
}
