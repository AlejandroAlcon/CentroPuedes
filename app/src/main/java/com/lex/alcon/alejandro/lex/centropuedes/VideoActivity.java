package com.lex.alcon.alejandro.lex.centropuedes;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;
    private MediaController mediacontroller;
    private Uri uri;
    private boolean isContinuously = false;
    private ProgressBar progressBar;
    private Button btnonce, btncontinuously, btnstop, btnplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView=findViewById(R.id.videoViewCurs);

        progressBar = (ProgressBar) findViewById(R.id.progrss);
        btnonce = findViewById(R.id.btnonce);
        btncontinuously = (Button) findViewById(R.id.btnconti);
        btnstop = (Button) findViewById(R.id.btnstop);
        btnplay = (Button) findViewById(R.id.btnplay);

        mediacontroller = new MediaController(this);
        mediacontroller.setAnchorView(videoView);
        String uriPath = "https://www.demonuts.com/Demonuts/smallvideo.mp4"; //update package name
        uri = Uri.parse(uriPath);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(isContinuously){
                    videoView.start();
                }
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.pause();
            }
        });

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.start();
            }
        });

        btnonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isContinuously = false;
                progressBar.setVisibility(View.VISIBLE);
                videoView.setMediaController(mediacontroller);
                videoView.setVideoURI(uri);
                videoView.requestFocus();
                videoView.start();
            }
        });

        btncontinuously.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isContinuously = true;
                progressBar.setVisibility(View.VISIBLE);
                videoView.setMediaController(mediacontroller);
                videoView.setVideoURI(uri);
                videoView.requestFocus();
                videoView.start();
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                progressBar.setVisibility(View.GONE);
            }
        });




    }
}
