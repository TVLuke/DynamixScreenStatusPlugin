/*
 * Copyright (C) Institute of Telematics, Lukas Ruge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.ambientdynamix.contextplugins.screenstatus;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.ambientdynamix.api.application.IContextInfo;
import org.ambientdynamix.contextplugins.context.info.device.IDeviceScreenContextInfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class ScreenStatusContextInfo implements IContextInfo, IDeviceScreenContextInfo
{

	private final String TAG = "SCREENSTATUS";
	
	boolean screenstatus;
	
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
		
	ScreenStatusContextInfo(boolean x)
	{
		screenstatus=x;
	}
	
	public ScreenStatusContextInfo(Parcel in) 
	{
		screenstatus= in.readByte() == 1;
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
	public void writeToParcel(Parcel out, int flags) 
	{
		out.writeByte((byte) (screenstatus ? 1 : 0));
	}

	@Override
	public String getContextType() 
	{
		return "org.ambientdynamix.contextplugins.context.info.device.screenstatus";
	}

	@Override
	public String getImplementingClassname() 
	{
		return this.getClass().getName();
	}

	@Override
	public String getStringRepresentation(String format) 
	{
		String result="";
		if (format.equalsIgnoreCase("text/plain"))
		{
			if(screenstatus)
			{
				result="on";
			}
			else
			{
				result="off";
			}
			return result;
		}
		else if (format.equalsIgnoreCase("XML"))
		{
			if(screenstatus)
			{
				result="on";
			}
			else
			{
				result="off";
			}
			return "<screenstatus>"+result+"</screenstatus>";
		}
		else if(format.equalsIgnoreCase("RDF/XML"))
		{
			result="<rdf:RDF\n" +
					"xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n" +
					"xmlns:z.0=\"http://dynamix.org/semmodel/org.ambientdynamix.contextplugins.context.info.device.screen/0.1/\"\n" +
					"xmlns:z.1=\"http://dynamix.org/semmodel/0.1/\" > \n";
			result=result+" <rdf:Description rdf:about=\"http://purl.org/device_RANDOMID\">\n";
			result=result+" <rdf:type>http://purl.org/device/screenstatus</rdf:type>\n";
			result=result+"<z.0:status>"+screenstatus+"</z.0:status>\n" +
							"  </rdf:Description>\n </rdf:RDF>";
			return result;
		}
		else if (format.equalsIgnoreCase("JSON"))
		{
			return " { \"screen\": \""+screenstatus+"\"}";
		}
		else
			return null;
	}

	@Override
	public Set<String> getStringRepresentationFormats() 
	{
		Set<String> formats = new HashSet<String>();
		formats.add("text/plain");
		formats.add("XML");
		formats.add("JSON");
		formats.add("RDF/XML");
		return formats;
	}

	@Override
	public boolean screenOn() 
	{
		return screenstatus;
	}

}