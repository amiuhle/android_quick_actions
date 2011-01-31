package de.uhlesoluschns.quickactions;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;

public class QuickActionDialog extends Dialog {
	
	private static final String TAG = "Troi.QuickActionDialog";
	
	private GridView mGrid;
	private QuickActionAdapter mAdapter;

	private OnQuickActionSelectedListener mListener;

	public QuickActionDialog(Context context) {
		super(context, R.style.Theme_QuickActionDialog);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		setContentView(R.layout.quick_action_dialog);
		
		mGrid = (GridView) findViewById(R.id.quick_action_grid);
		mGrid.setOnItemClickListener(new QuickActionClickListener());
		// TODO: for some reason, putting this in the XML layout instead makes
        // the list items unclickable.
		mGrid.setFocusable(true);
		
		Window window = getWindow();
		WindowManager.LayoutParams lp = window.getAttributes();
		lp.width = WindowManager.LayoutParams.MATCH_PARENT;
		lp.height = WindowManager.LayoutParams.MATCH_PARENT;
		// Put window on top of input method
		lp.flags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
		window.setAttributes(lp);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		mGrid.setAdapter(mAdapter);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
	public void show() {
		super.show();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_DOWN) {
			// Cancel dialog on any touch down event which is not handled by the corpus grid
			cancel();
			return true;
		}
		return false;
	}
	
	public void setOnQuickActionSelectedListener(OnQuickActionSelectedListener listener) {
		mListener = listener;
	}
	
	public void setAdapter(QuickActionAdapter adapter) {
		mAdapter = adapter;
		if(mGrid != null) {
			mGrid.setAdapter(mAdapter);
		}
	}
	
	private void selectQuickAction(int position, QuickAction quickAction) {
		dismiss();
		if(mListener != null) {
			mListener.onQuickActionSelected(position, quickAction);
		}
	}
	
	private class QuickActionClickListener implements AdapterView.OnItemClickListener {
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			QuickAction quickAction = (QuickAction) parent.getItemAtPosition(position);
			selectQuickAction(position, quickAction);
		}
	}
	
	public interface OnQuickActionSelectedListener {
        void onQuickActionSelected(int position, QuickAction quickAction);
    }
}
