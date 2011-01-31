package de.uhlesoluschns.quickactions;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class QuickActionArrayAdapter extends ArrayAdapter<QuickAction> {
	
	private LayoutInflater mInflater;

	public QuickActionArrayAdapter(Context context, List<QuickAction> quickActions) {
		super(context, R.layout.quick_action_grid_item, R.id.quick_action_label, quickActions);
		init();
	}

	public QuickActionArrayAdapter(Context context, QuickAction[] quickActions) {
		super(context, R.layout.quick_action_grid_item, R.id.quick_action_label, quickActions);
		init();
	}
	
	private void init() {
		mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		QuickActionView view = (QuickActionView) convertView;
		if(view == null) {
			view = createView(parent);
		}
		
		QuickAction item = getItem(position);
		view.setQuickAction(item);
		
		return view;
	}
	
	private QuickActionView createView(ViewGroup parent) {
		return (QuickActionView) mInflater.inflate(R.layout.quick_action_grid_item, parent, false);
	}

}
