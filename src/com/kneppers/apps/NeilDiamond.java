package com.kneppers.apps;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class NeilDiamond extends Activity {

	MediaPlayer sound;
	@Override
	protected void onCreate(Bundle redball) {
		// TODO Auto-generated method stub
		super.onCreate(redball);
		setContentView(R.layout.neildiamond);
		sound = MediaPlayer.create(NeilDiamond.this, R.raw.song);
		sound.start();
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(15000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openStartingpoint = new Intent("com.kneppers.apps.STARTINGPOINT");
					startActivity(openStartingpoint);
				}

			}
		};
		timer.start();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		sound.release();
		finish();
	}
	
}
