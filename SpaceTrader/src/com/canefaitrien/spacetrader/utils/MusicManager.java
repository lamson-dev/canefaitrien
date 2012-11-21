// $codepro.audit.disable
package com.canefaitrien.spacetrader.utils;

import java.util.Collection;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import com.canefaitrien.spacetrader.R;

/**
 * To use this, each activity must have a boolean field called continueMusic or
 * whatever you want to call it. For any activity that isn't the root activity
 * (launcher), override onKeyDown and set continueMusic to true if the key is
 * the "back" key. Also set continueMusic to true when launching any activities
 * in which you want to keep playing this music in with no interruption.
 */
public class MusicManager {
	private static final String TAG = "MusicManager";

	public static final int MUSIC_PREVIOUS = -1;

	public static final int MUSIC_MENU = 0;

	public static final int MUSIC_GAME = 1;

	public static final int MUSIC_END_GAME = 2;

	private static final int PREF_DEFAULT_MUSIC_VOLUME_ITEM = 5;

	@SuppressLint("UseSparseArrays")
	private static HashMap<Integer, MediaPlayer> players = new HashMap<Integer, MediaPlayer>();

	private static int currentMusic = -1;

	private static int previousMusic = -1;

	public static void start(Context context, int music) {
		start(context, music, false);
	}

	public static void start(Context context, int music, boolean force) {
		if (!force && currentMusic > -1) {
			// already playing some music and not forced to change
			return;
		}
		if (music == MUSIC_PREVIOUS) {
			Log.d(TAG, "Using previous music [" + previousMusic + "]");
			music = previousMusic;
		}
		if (currentMusic == music) {
			// already playing this music
			return;
		}
		if (currentMusic != -1) {
			previousMusic = currentMusic;
			Log.d(TAG, "Previous music was [" + previousMusic + "]");
			// playing some other music, pause it and change
			pause();
		}
		currentMusic = music;
		Log.d(TAG, "Current music is now [" + currentMusic + "]");
		MediaPlayer mp = players.get(music); // $codepro.audit.disable
		if (mp != null) {
			if (!mp.isPlaying()) {
				mp.start();
				return;
			}
		}

		switch (music) {
		case MUSIC_MENU:
			mp = MediaPlayer.create(context, R.raw.music_menu);
			break;
		case MUSIC_GAME:
			mp = MediaPlayer.create(context, R.raw.music_game);
			break;
		case MUSIC_END_GAME:
			mp = MediaPlayer.create(context, R.raw.music_end_game);
			break;
		default:
			Log.e(TAG, "unsupported music number - " + music);
			return;
		}

		players.put(music, mp);
		// float volume = getMusicVolume(context);
		// Log.d(TAG, "Setting music volume to " + volume);
		// mp.setVolume(volume, volume);
		if (mp == null) {
			Log.e(TAG, "player was not created successfully");
		} else {
			try {
				mp.setLooping(true);
				mp.start();
				mp.setVolume(PREF_DEFAULT_MUSIC_VOLUME_ITEM,
						PREF_DEFAULT_MUSIC_VOLUME_ITEM);
			} catch (Exception e) {
				Log.e(TAG, e.getMessage(), e);
			}
		}
	}

	public static void pause() {
		Collection<MediaPlayer> mps = players.values();
		for (MediaPlayer p : mps) {
			if (p.isPlaying()) {
				p.pause();
			}
		}
		// previousMusic should always be something valid
		if (currentMusic != -1) {
			previousMusic = currentMusic;
			Log.d(TAG, "Previous music was [" + previousMusic + "]");
		}
		currentMusic = -1;
		Log.d(TAG, "Current music is now [" + currentMusic + "]");
	}

	public static void release() {
		Log.d(TAG, "Releasing media players");
		Collection<MediaPlayer> mps = players.values();
		for (MediaPlayer mp : mps) {
			try {
				if (mp != null) {
					if (mp.isPlaying()) {
						mp.stop();
					}
					mp.release();
				}
			} catch (Exception e) {
				Log.e(TAG, e.getMessage(), e);
			}
		}
		mps.clear();
		if (currentMusic != -1) {
			previousMusic = currentMusic;
			Log.d(TAG, "Previous music was [" + previousMusic + "]");
		}
		currentMusic = -1;
		Log.d(TAG, "Current music is now [" + currentMusic + "]");
	}
}
