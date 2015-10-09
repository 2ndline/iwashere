package com.secondline.iwasthere.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Iwasthere implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		ScrollPanel panel = new ScrollPanel();
		RootPanel.get("container").add(panel);
		InputView mainView = new InputView();
		panel.add(mainView);
	}
}
