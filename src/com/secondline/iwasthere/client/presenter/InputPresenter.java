package com.secondline.iwasthere.client.presenter;

import java.util.Map;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.secondline.iwasthere.client.InputView;
import com.secondline.iwasthere.shared.Disaster;
import com.secondline.iwasthere.shared.InputField;

public class InputPresenter {
	private InputView view;
	PopupPanel popup;
	ResizeLayoutPanel popupContainer = new ResizeLayoutPanel();

	public InputPresenter(InputView v) {
		this.view = v;

		view.getGenerateButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// Get disaster and other fields

				popup = new PopupPanel(false, false);
				popup.setWidget(popupContainer);

				HTMLPanel container = new HTMLPanel("");
				Button cancel = new Button("Try again");
				container.add(cancel);

				cancel.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						popup.hide();
					}
				});

				popupContainer.clear();
				popupContainer.add(container);
				ScrollPanel scrollContainer = new ScrollPanel();
				container.add(scrollContainer);

				Disaster d = view.getDisaster();
				container.getElement().getStyle()
						.setBackgroundImage("url(/" + d.getUrl() + ")");
				container.getElement().getStyle()
						.setProperty("backgroundSize", "cover");

				Map<InputField, TextBox> values = view.getFieldsMap();
				String job = values.get(InputField.Job).getText();
				String employer = values.get(InputField.Employer).getText();
				HTMLPanel scriptPanel = new HTMLPanel("");
				Label script = new Label();
				scriptPanel.add(script);
				scrollContainer.add(scriptPanel);
				// Todo: set script
				String scriptText = "So there I was, doing "
						+ job
						+ " at "
						+ employer
						+ ", when suddenly "
						+ d.getTitle()
						+ " happens. It was crazy. I'm in "
						+ d.getPlace()
						+ " and I just feel this jostling. So I leave and I'm by "
						+ d.getLandmark()
						+ " and that's when I realize that it's really bad.";
				script.setText(scriptText);
				script.getElement().getStyle().setColor("red");
				Window.addResizeHandler(new ResizeHandler() {

					@Override
					public void onResize(ResizeEvent event) {
						resize();
					}
				});
				resize();
			}

		});
	}

	protected void resize() {
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				int windowWidth = Window.getClientWidth();
				int windowHeight = Window.getClientHeight();

				int width = (windowWidth - 25);
				int height = (windowHeight - 25);
				popupContainer.setWidth("" + width + "px");
				popupContainer.setHeight("" + height + "px");

				popup.center();

			}
		});
	}
}
