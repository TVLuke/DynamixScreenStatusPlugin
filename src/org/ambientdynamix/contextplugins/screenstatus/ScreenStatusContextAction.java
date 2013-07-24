package org.ambientdynamix.contextplugins.screenstatus;

import java.util.Set;

import org.ambientdynamix.api.application.IContextInfo;
import org.ambientdynamix.contextplugins.context.action.device.IDeviceScreenContextAction;

import android.os.Parcel;
import android.os.Parcelable;

public class ScreenStatusContextAction implements IContextInfo, IDeviceScreenContextAction 
{

	public static Parcelable.Creator<ScreenStatusContextInfo> CREATOR = new Parcelable.Creator<ScreenStatusContextInfo>() 
			{
			public ScreenStatusContextInfo createFromParcel(Parcel in) 
			{
				return new ScreenStatusContextInfo(in);
			}

			public ScreenStatusContextInfo[] newArray(int size) 
			{
				return new ScreenStatusContextInfo[size];
			}
		};
		
	public ScreenStatusContextAction()
	{
		
	}
		
	@Override
	public void screenOn(boolean on) 
	{
		ScreenStatusPluginRuntime.setScreen(on);
	}

	@Override
	public String toString() 
	{
		return this.getClass().getSimpleName();
	}
	
	@Override
	public int describeContents() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getContextType() 
	{
		return "org.ambientdynamix.contextplugins.context.action.device.screenstatus";
	}

	@Override
	public String getImplementingClassname() 
	{
		return this.getClass().getSimpleName();
	}

	@Override
	public String getStringRepresentation(String arg0) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getStringRepresentationFormats() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
