package com.example.demoyoutube;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {

    private static final String API_KEY = "AIzaSyBEfzPd7JBlJUJ9dWcgSzsf_y_X8rqDrRM";
    Button mPlay ,speedSlow ,speed ;
    YouTubePlayerView mYouTubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;
    YouTubePlayer youTubePlayer;
    String code;
    ImageButton seekBack ,  seekForward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        code = "2S24-y0Ij3Y";
        code = "RBumgq5yVrA";

//        Intent i  = new Intent(MainActivity.this,CustomActivity.class);
//        startActivity(i);

        mYouTubePlayerView = findViewById(R.id.ytView);
        speed = findViewById(R.id.speed);



        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(code);
                youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                Toast.makeText(MainActivity.this , "Done" , Toast.LENGTH_LONG ).show();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(MainActivity.this , "Failed" , Toast.LENGTH_LONG ).show();

            }
        };
        mYouTubePlayerView.initialize(API_KEY , mOnInitializedListener);


    }

}
