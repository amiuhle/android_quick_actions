package de.uhlesoluschns.quickactions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class QuickActionView extends RelativeLayout {
	
	private ImageView mIcon;
	private TextView mLabel;

	public QuickActionView(Context context) {
		super(context);
	}

	public QuickActionView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		mIcon = (ImageView) findViewById(R.id.quick_action_icon);
        mLabel = (TextView) findViewById(R.id.quick_action_label);
	}
	
	public void setQuickAction(QuickAction action) {
		setLabel(action.getLabel());
		setIcon(action.getIconResource());
	}
	
	public void setLabel(CharSequence label) {
		mLabel.setText(label);
	}
	
	public void setIcon(Drawable icon) {
		mIcon.setImageDrawable(icon);
	}
	
	public void setIcon(int icon) {
		mIcon.setImageResource(icon);
	}
	
	public void setIcon(Bitmap icon) {
		mIcon.setImageBitmap(icon);
	}
	
}
