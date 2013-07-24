package org.ambientdynamix.contextplugins.screenstatus;

import java.util.Calendar;
import java.util.Date;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;

public class Timer 
{

	private final String TAG = "SCREENSTATUS";
	Intent intent;
	SharedPreferences prefs;
	private static boolean screenOn=true;
	private static boolean stop=false;

	
	public Timer() 
	{
	    if(!stop)
	    {
			Thread t1 = new Thread( new BackendRunner());
			t1.start();
	    }
	}

	public static void stop()
	{
		stop=true;
	}
	
	class BackendRunner implements Runnable
	{
		private Handler handler = new Handler();
		private int delay=500;
		long counter=0;
		
		@Override
		public void run() 
		{
			Log.d(TAG, "run");
			boolean screenstatus=ScreenStatusPluginRuntime.checkScreen();
			if(screenOn!=screenstatus)
			{
				ScreenStatusPluginRuntime.sendUpdate(screenstatus);
				screenOn=screenstatus;
			}
			handler.removeCallbacks(this); // remove the old callback
			if(!stop)
			{
				handler.postDelayed(this, delay); // register a new one
			}
		}
		
		public void onResume() 
		{
			handler.postDelayed(this, delay);
		}

		public void onPause() 
		{
			handler.removeCallbacks(this); // stop the map from updating
		}
	}
	
	public static boolean isRunning()
	{
		return !stop;
	}
}
