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

import org.ambientdynamix.contextplugins.info.meta.IDevice;

import android.os.Parcel;

public class Device implements IDevice
{

	@Override
	public String sourceId() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int describeContents() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel arg0, int arg1) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public String diviceName() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String urlOfDeviceSymbol() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float energyLevel() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hardwareVersionNumber() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int firmwareVersionNumber() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int firmwareRevisionNumber() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isBatteryPowered() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRecharable() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCharging() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWireless() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConnected() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String ConnectionType() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMACAddress() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remainingStorage() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
