package com.colafans.ifrain;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends Activity {
	private LocationManagerProxy mLocationManagerProxy;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 不显示程序的标题栏
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		mLocationManagerProxy = LocationManagerProxy.getInstance(this);
		mLocationManagerProxy.setGpsEnable(false);
		mLocationManagerProxy.requestLocationData(
				LocationManagerProxy.NETWORK_PROVIDER, 1000, 15,
				new AMapLocationListener() {

					@Override
					public void onStatusChanged(String provider, int status,
							Bundle extras) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onProviderEnabled(String provider) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onProviderDisabled(String provider) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onLocationChanged(Location location) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onLocationChanged(AMapLocation arg0) {
						// TODO Auto-generated method stub
						if (arg0 != null
								&& arg0.getAMapException()
										.getErrorCode() == 0) {
							System.out.println(arg0.toString());
							Log.i("Location", arg0.toString());
						}else{
							Log.i("Location", arg0.getAMapException().getErrorMessage());
						}
					}
				});
	}
}
