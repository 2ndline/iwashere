package com.secondline.iwasthere.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.secondline.iwasthere.client.presenter.InputPresenter;
import com.secondline.iwasthere.shared.Disaster;
import com.secondline.iwasthere.shared.InputField;

public class InputView extends Composite{

	VerticalPanel container = new VerticalPanel();
	List<TextBox> inputs = new ArrayList<TextBox>();
	Button generateButton = new Button("Generate excuse!");
	Map<InputField, TextBox> fields = new HashMap<InputField, TextBox>();
	
	ListBox disasterPicker = new ListBox();
	
	InputPresenter presenter;
	public InputView(){
		initWidget(container);
		container.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		container.setWidth("100%");
		presenter = new InputPresenter(this);
		Label title = new Label("I WAS THERE!");
		title.setStyleName("title");
		Label instruction = new Label("Select a major historical event that you were totally there for. We'll come up with your story.");
		
		container.add(title);
		container.add(instruction);
		
		for(Disaster d: Disaster.values()){
			disasterPicker.addItem(d.getTitle());
		}
		container.add(disasterPicker);
		for(InputField field : InputField.values()){
			TextBox input = new TextBox();
			String display = field.toString().replace("_", " ").concat("?");
			input.getElement().setPropertyString("placeholder", display);
			input.setWidth("10em");
			inputs.add(input);
			container.add(input);
			fields.put(field, input);
		}
		
		container.add(generateButton);
		
		Image steve = new Image("/steve.jpg");
		steve.setStyleName("steve");
		RootPanel.get("container").add(steve);
	}
	
	public Button getGenerateButton(){
		return generateButton;
	}
	
	public Map<InputField, TextBox> getFieldsMap(){
		return fields;
	}

	public Disaster getDisaster() {
		return Disaster.getDisasterByName(disasterPicker.getValue(disasterPicker.getSelectedIndex()));
	}
}
