package com.mukesh.foursquare.android;

/**
 * Encapsulation of a MainActivity: a demo for using api
 *
 * @author Mukesh Yadav
 */
import java.io.IOException;
import java.net.MalformedURLException;

import com.jiramot.foursquare.android.R;
import com.mukesh.foursquare.android.Foursquare.DialogListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Main extends Activity {
	Foursquare foursquare;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		foursquare = new Foursquare(
				"DM4OYFGJJ4XP14OP42T2MCDSA1ONCAROQGGRMB0CO5DSHNY0",
				"JDH0K044UEESQRQ4OUNELA10QMVM4POJVAI3MJQJJFT2MWVQ",
				"http://www.androiddevelopersolution.com/://connect");

		foursquare.authorize(this, new FoursquareAuthenDialogListener());

	}

	private class FoursquareAuthenDialogListener implements DialogListener {

		@Override
		public void onComplete(Bundle values) {
			try {
				String aa = null;
				aa = foursquare.request("users/self");
				Log.d("Foursquare-Main", aa);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void onFoursquareError(FoursquareError e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onError(DialogError e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onCancel() {
			// TODO Auto-generated method stub

		}

	}
}