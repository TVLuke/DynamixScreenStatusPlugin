package org.ambientdynamix.contextplugins.screenstatus;

import java.util.UUID;

import org.ambientdynamix.api.contextplugin.*;
import org.ambientdynamix.api.contextplugin.security.PrivacyRiskLevel;
import org.ambientdynamix.api.contextplugin.security.SecuredContextInfo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;


public class ScreenStatusPluginRuntime extends AutoReactiveContextPluginRuntime
{
	private final static String TAG = "SCREENSTATUS";
	private static ScreenStatusPluginRuntime context;
	private BroadcastReceiver receiver;
	//Timer timer;

	@Override
	public void start() 
	{
		/*
		 * Nothing to do, since this is a pull plug-in... we're now waiting for context scan requests.
		 */
		context=this;
		Log.i(TAG, "Started!");
	}

	@Override
	public void stop() 
	{
		/*
		 * At this point, the plug-in should cancel any ongoing context scans, if there are any.
		 */
		Log.i(TAG, "Stopped!");
		//Timer.stop();
	}

	@Override
	public void destroy() 
	{
		/*
		 * At this point, the plug-in should release any resources.
		 */
		stop();
		getSecuredContext().unregisterReceiver(receiver);
		Log.i(TAG, "Destroyed!");
	}

	@Override
	public void updateSettings(ContextPluginSettings settings) 
	{
		// Not supported
	}

	@Override
	public void handleContextRequest(UUID requestId, String contextInfoType) 
	{
		PowerManager powerManager = (PowerManager) this.getSecuredContext().getSystemService(this.getSecuredContext().POWER_SERVICE);
		boolean screenstatus=powerManager.isScreenOn();
		if(contextInfoType.equals("org.ambientdynamix.contextplugins.context.info.device.screenstatus"))
		{
			SecuredContextInfo aci= new SecuredContextInfo(new ScreenStatusContextInfo(screenstatus), PrivacyRiskLevel.LOW);
			sendContextEvent(requestId, aci, 1000);
		}
		context=this;
	}

	@Override
	public void handleConfiguredContextRequest(UUID requestId, String contextInfoType, Bundle scanConfig) 
	{
		if(contextInfoType.equals("org.ambientdynamix.contextplugins.context.info.device.screenstatus"))
		{
		handleContextRequest(requestId, contextInfoType);
		}
		if(contextInfoType.equals("org.ambientdynamix.contextplugins.context.action.device.screenstatus"))
		{
			Log.d(TAG, "Action Context Requested");
			Boolean status = scanConfig.getBoolean("screenstatus");
			context=this;
			ScreenStatusContextAction ssca = new ScreenStatusContextAction();
			ssca.screenOn(false);
		}
		context=this;
	}

	@Override
	public void init(PowerScheme arg0, ContextPluginSettings arg1) throws Exception 
	{
		Log.d(TAG, "init");
		//timer=new Timer();
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_ON);
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		receiver = new BroadcastReceiver() 
		{
		    @Override
		    public void onReceive(Context context, Intent intent) 
		    {
		    	Log.d(TAG, "Update!");
		    	sendUpdate(checkScreen());
		    }
		  };
		getSecuredContext().registerReceiver(receiver, filter);
		context=this;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPowerScheme(PowerScheme arg0) throws Exception 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doManualContextScan() 
	{
		// TODO Auto-generated method stub
		
	}
	
	public static void sendUpdate(boolean x)
	{
		SecuredContextInfo aci= new SecuredContextInfo(new ScreenStatusContextInfo(x), PrivacyRiskLevel.LOW);
		if(context!=null)
		{
			context.sendBroadcastContextEvent(aci, 1000);
		}
	}
	
	public static boolean checkScreen()
	{
		if(context!=null)
		{
			PowerManager powerManager = (PowerManager) context.getSecuredContext().getSystemService(context.getSecuredContext().POWER_SERVICE);
			boolean screenstatus=powerManager.isScreenOn();
			return screenstatus;
		}
		return false;
	}
	
	public static void setScreen(boolean x)
	{
		Log.d(TAG, "set screen to");
		Activity a = new Activity();
		WindowManager.LayoutParams params = a.getWindow().getAttributes();
		if(x)
		{
			Log.d(TAG, "true");
			params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
			//TODO restoring from original value
			params.screenBrightness = 0.9f;
			a.getWindow().setAttributes(params);
		}
		else
		{
			Log.d(TAG, "false");
			params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
			//TODO Store original brightness value
			params.screenBrightness = 0.1f;
			a.getWindow().setAttributes(params);	
		}
	}

}