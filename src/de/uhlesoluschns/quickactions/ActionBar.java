package de.uhlesoluschns.quickactions;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

public class ActionBar extends RelativeLayout {

	private static final String TAG = "ActionBar";

	public ActionBar(Context context) {
		super(context);
		Log.d(TAG, "Construct");
	}

	public ActionBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		Log.d(TAG, "Construct");
	}
	
	public ActionBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		Log.d(TAG, "Construct");
	}


}
