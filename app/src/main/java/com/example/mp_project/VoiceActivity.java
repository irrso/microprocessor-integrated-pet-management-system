package com.example.mp_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

public class VoiceActivity extends AppCompatActivity {

    MediaPlayer player;
    MediaRecorder recorder;
    //ExtAudioRecorder recorder;
    String filename;
    Button btn1, btn2, btn3, btn4, btn5;
    private FirebaseStorage storage;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        File sdcard = Environment.getExternalStorageDirectory(); //SD카드접근
        file = new File(sdcard, "recorded.mp4"); //파일위치, 파일명 지정
        filename = file.getAbsolutePath(); //저장할 파일명 가져옴 /storage/emulated/0/recorded.mp4
        Log.d("VoiceActivity","저장할 파일 명: " + filename);


        btn1 = findViewById(R.id.button4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordAudio();
            }
        });

        btn2 = findViewById(R.id.button5);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopRecording();
            }
        });

        btn3 = findViewById(R.id.button6);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAudio();
            }
        });

        btn4 = findViewById(R.id.button7);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAudio();
            }
        });

        btn5 = findViewById(R.id.button8);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { data(); }
        });
    }

    public void recordAudio(){
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC); //마이크에서 들어온 음성 처리
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4); //압축포맷 지정
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT); //인코딩을 위한 것

        //recorder = ExtAudioRecorder.getInstanse(false);
        recorder.setOutputFile(filename);

        try{
            recorder.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }

        recorder.start();;
        Toast.makeText(getApplicationContext(), "녹음 시작", Toast.LENGTH_LONG).show();
    }

    public void stopRecording(){
        if(recorder != null){
            recorder.stop();
            recorder.release(); //리소스 전부 해제
            recorder = null; //비움

            Toast.makeText(getApplicationContext(), "녹음 중지", Toast.LENGTH_LONG).show();
        }
    }
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

    public void stopAudio(){
        if(player != null && player.isPlaying()){
            player.stop();;
            if (player != null){
                player.release();; player = null;
            }
            Toast.makeText(getApplicationContext(), "멈춤", Toast.LENGTH_LONG).show();
        }

    }

    public void data(){
        storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        Uri file = Uri.fromFile(new File("/storage/emulated/0/recorded.mp4")); // /sdcard/recorded.mp4
        StorageReference voiceRef = storageRef.child("voice/"+file.getLastPathSegment()); //"recorded.mp4"
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
    }
}