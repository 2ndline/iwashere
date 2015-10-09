package com.secondline.iwasthere.client.presenter;

import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.secondline.iwasthere.client.InputView;
import com.secondline.iwasthere.shared.Disaster;
import com.secondline.iwasthere.shared.InputField;

public class InputPresenter {
	private InputView view;

	public InputPresenter(InputView v){
		this.view = v;
		
		view.getGenerateButton().addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				//Get disaster and other fields
				
				Disaster d = view.getDisaster();
				Map<InputField, TextBox> values = view.getFieldsMap();
				
				PopupPanel popup = new PopupPanel(false, false);
				
				
			}
			
		});
	}
}
