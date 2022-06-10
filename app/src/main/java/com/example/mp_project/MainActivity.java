package com.example.mp_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button videoBtn, feedBtn, voiceBtn;
    TextView te, hu, se;
    SeekBar seekBar;
    double progress;
    FirebaseDatabase database;
    DatabaseReference myRef, dbReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        feedBtn = findViewById(R.id.feedBtn);
        videoBtn = findViewById(R.id.videoBtn);
        voiceBtn= findViewById(R.id.voiceBtn);
        seekBar = findViewById(R.id.seekBar);

        te = findViewById(R.id.temperatureText);
        hu = findViewById(R.id.humidityText);
        se = findViewById(R.id.seekText);

        //feed 초기값
        dbReference = FirebaseDatabase.getInstance().getReference();
        dbReference.child("feed").setValue(0);

        //사료주기
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i * 0.5;
                se.setText(progress + "초");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        feedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dbReference = FirebaseDatabase.getInstance().getReference();

                //dbReference.child("feed").setValue(true);
                dbReference.child("feed").setValue(progress);
                Handler mHandler = new Handler();
                Toast.makeText(getApplicationContext(), "사료주기 완료", Toast.LENGTH_SHORT).show();

                /*mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dbReference.child("feed").setValue(false);
                        Toast t = Toast.makeText(getApplicationContext(), "사료주기 완료", Toast.LENGTH_SHORT);
                        t.show();
                    }
                },3000);*/
            }
        });

        //영상보기
        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
                startActivity(intent);
            }
        });

        //녹음하기
        voiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VoiceActivity.class);
                startActivity(intent);
            }
        });

        //온습도
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("temphumi");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Double value1 = snapshot.child("temperature").getValue(Double.class);
                Double value2 = snapshot.child("humidity").getValue(Double.class);
                te.setText(value1+"°C"); //"\'C"
                hu.setText(value2+"%");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}