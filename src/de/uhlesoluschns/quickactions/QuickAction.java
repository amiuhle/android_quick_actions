package de.uhlesoluschns.quickactions;


public class QuickAction {
	private CharSequence mLabel;
//	private Drawable mIconDrawable;
	private int mIconResource;
	
	public QuickAction(CharSequence label, int icon) {
		mLabel = label;
		mIconResource = icon;
	}
	
	public CharSequence getLabel() {
		return mLabel;
	}
	
//	public Drawable getIconDrawable() {
//		return mIconDrawable;
//	}
	
	public int getIconResource() {
		return mIconResource;
	}
	
	@Override
	public String toString() {
		return getLabel().toString();
	}
	
}
