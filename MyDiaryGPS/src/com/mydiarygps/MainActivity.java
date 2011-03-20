package com.mydiarygps;

import com.mydiarygps.R;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity<button> extends Activity {
	/** Called when the activity is first created. */
	public Context context = this;
	Intent iNewThing;
	Intent iAviso;
	public static double latitude;
	public static double longitude;
	public static double altitude;
	public static float radius;
	public static int janela = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final Button btn_newThing = (Button) findViewById(R.id.main_new_thing);

		btn_newThing.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				iNewThing = new Intent(v.getContext(), NewAnnotation.class);
				startActivity(iNewThing);
			}
		});
		// AndroidManifest.xml must have the following permission:
		final NewAnnotation na = new NewAnnotation();
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
				0, new LocationListener() {
					public void onStatusChanged(String provider, int status,
							Bundle extras) {
						// called when the provider status changes. Possible
						// status: OUT_OF_SERVICE, TEMPORARILY_UNAVAILABLE or
						// AVAILABLE.
					}

					public void onProviderEnabled(String provider) {
						// called when the provider is enabled by the user
					}

					public void onProviderDisabled(String provider) {
						// called when the provider is disabled by the user, if
						// it's already disabled, it's called immediately after
						// requestLocationUpdates
					}

					public void onLocationChanged(Location location) {

						latitude = location.getLatitude();
						longitude = location.getLongitude();
						altitude = location.getAltitude();
						if (janela == 1) {
							na.lat.setText(String.valueOf(latitude));
							na.lng.setText(String.valueOf(longitude));
							na.alt.setText(String.valueOf(altitude));
						}
						// do whatever you want with the coordinates
					}
				});
		iAviso = new Intent(this, AlertaPosicaoEncontrada.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 1,
				iAviso, 0);

		locationManager.addProximityAlert(-22.893935, -43.255534, 20, -1,
				pendingIntent);
		
		locationManager.addProximityAlert(-22.894424, -43.254598, 10, -1,
				pendingIntent);
		

	}

}