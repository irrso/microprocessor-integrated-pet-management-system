package com.example.mp_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class VoiceActivity extends AppCompatActivity {

    MediaPlayer player;
    ExtAudioRecorder recorder;
    String filename;
    Button recordBtn, playBtn, pauseBtn, sendBtn;
    File file;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        File sdcard = Environment.getExternalStorageDirectory(); //SD카드접근
        file = new File(sdcard, "recorded.wav"); //파일위치, 파일명 지정
        filename = file.getAbsolutePath(); //저장할 파일명 가져옴 /storage/emulated/0/recorded.mp4
        Log.d("VoiceActivity","저장할 파일 명: " + filename);

        recordBtn = findViewById(R.id.recordBtn);
        recordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { recordAudio(); }
        });

        playBtn = findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAudio();
            }
        });

        pauseBtn = findViewById(R.id.pauseBtn);
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAudio();
            }
        });

        sendBtn = findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { fireBase(); }
        });
    }

    public void recordAudio(){
        if(index == 0){ //녹음
            recordBtn.setBackgroundResource(R.drawable.radio_waves);
            recordBtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#959a77")));
            recorder = ExtAudioRecorder.getInstanse(false);
            recorder.setOutputFile(filename);

            try{
                recorder.prepare();
            }catch (Exception e){
                e.printStackTrace();
            }

            recorder.start();;
            Toast.makeText(getApplicationContext(), "녹음 시작", Toast.LENGTH_LONG).show();
            index = 1;
        }

        else if(index == 1){ //중지
            recordBtn.setBackgroundResource(R.drawable.mic);
            recordBtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A8E77")));
            if(recorder != null){
                recorder.stop();
                recorder.release(); //리소스 전부 해제
                recorder = null; //비움

                Toast.makeText(getApplicationContext(), "녹음 중지", Toast.LENGTH_LONG).show();
                index = 0;
            }
        }
    }

    //재생
    public void playAudio(){
        try{
            player = new MediaPlayer(); //초기화
            player.setDataSource(filename); //파일을 가져와 출력
            player.prepare();
            player.start();

            Toast.makeText(getApplicationContext(), "재생", Toast.LENGTH_LONG).show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //멈춤
    public void stopAudio(){
        if(player != null && player.isPlaying()){
            player.stop();;
            if (player != null){
                player.release();; player = null;
            }
            Toast.makeText(getApplicationContext(), "멈춤", Toast.LENGTH_LONG).show();
        }

    }

    //전송
    public void fireBase(){
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        Uri file = Uri.fromFile(new File(filename)); // /storage/emulated/0/recorded.mp4
        StorageReference voiceRef = storageRef.child("voice/"+"recorded.wav");
        UploadTask uploadtask = voiceRef.putFile(file);

        uploadtask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "업로드 실패", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getApplicationContext(), "업로드 성공", Toast.LENGTH_SHORT).show();
            }
        });

        DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference();
        dbReference.child("voice").setValue(true);
    }
}