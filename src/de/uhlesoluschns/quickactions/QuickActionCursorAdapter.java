package de.uhlesoluschns.quickactions;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;

public class QuickActionCursorAdapter extends CursorAdapter implements ListAdapter {

	private LayoutInflater mInflater;

	private int mLabelColumn;
	private int mIconColumn;

	public QuickActionCursorAdapter(Context context, Cursor c, int labelColumn, int iconColumn) {
		super(context, c);
		
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		mLabelColumn = labelColumn;
		mIconColumn = iconColumn;
	}
	
	@Override
	public void bindView(View rawView, Context context, Cursor cursor) {
		QuickActionView view = (QuickActionView) rawView;
		view.setLabel(cursor.getString(mLabelColumn));
		byte [] imageData = cursor.getBlob(mIconColumn);
		view.setIcon(BitmapFactory.decodeByteArray(imageData, 0, imageData.length));
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		return mInflater.inflate(R.layout.quick_action_grid_item, parent, false);
	}

	

}
