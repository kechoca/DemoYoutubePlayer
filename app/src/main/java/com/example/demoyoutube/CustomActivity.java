package com.example.demoyoutube;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class CustomActivity extends YouTubeBaseActivity {

    private static final String API_KEY = "AIzaSyBEfzPd7JBlJUJ9dWcgSzsf_y_X8rqDrRM";
    YouTubePlayerView mYouTubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;
    YouTubePlayer youTubePlayer;
    String code;
    static final String MINUTE = "";
    Integer minute = 0;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_control_player);

        code = "2S24-y0Ij3Y";
//        code = "RBumgq5yVrA";
        mYouTubePlayerView = findViewById(R.id.ytView);

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(code);
                youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
                Toast.makeText(CustomActivity.this, "Done", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(CustomActivity.this, "Failed", Toast.LENGTH_LONG).show();

            }
        };


        mYouTubePlayerView.initialize(API_KEY, mOnInitializedListener);

    }

}
