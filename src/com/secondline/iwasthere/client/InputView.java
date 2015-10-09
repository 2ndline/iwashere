package com.secondline.iwasthere.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.secondline.iwasthere.shared.InputField;

public class InputView extends Composite{

	VerticalPanel container = new VerticalPanel();
	List<TextBox> inputs = new ArrayList<TextBox>();
	Button generateButton = new Button("Generate excuse!");
	Map<InputField, TextBox> fields = new HashMap<InputField, TextBox>();
	public InputView(){
		initWidget(container);
		Label title = new Label("I WAS THERE!");
		Label instruction = new Label("Select a major historical event that you were totally there for. We'll come up with your story.");
		
		container.add(title);
		container.add(instruction);
		
		for(InputField field : InputField.values()){
			TextBox input = new TextBox();
			input.getElement().setPropertyString("placeholder", field.toString());
			input.setWidth("10em");
			inputs.add(input);
			container.add(input);
			fields.put(field, input);
		}
		
		container.add(generateButton);
	}
	
	public Button getGenerateButton(){
		return generateButton;
	}
	
	public Map<InputField, TextBox> getFieldsMap(){
		return fields;
	}
}