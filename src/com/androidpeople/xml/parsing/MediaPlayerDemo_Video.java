package com.androidpeople.xml.parsing;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;


public class MediaPlayerDemo_Video extends Activity {

    /**
     * 
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        try{
        setContentView(R.layout.mediaplayer_2);
        
        VideoView videoView =(VideoView)findViewById(R.id.VideoView);
        	        MediaController mediaController = new MediaController(this);
        	        mediaController.setAnchorView(videoView);
        	// Set video link (mp4 format )
        	        Uri video = Uri.parse("http://brightcove.vo.llnwd.net/d9/unsecured/media/62605515001/62605515001_104574678001_req1-6-cancer-camacho-segment.mp4?videoId=104535901001");
        	        videoView.setMediaController(mediaController);
        	        videoView.setVideoURI(video);
        	        videoView.start();
        }
        catch(Exception e){
        	
        	System.out.println("MAin :"+e.getMessage());
        }
    }

   
}