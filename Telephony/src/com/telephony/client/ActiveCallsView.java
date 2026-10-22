package com.telephony.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ActiveCallsView extends Composite {

    public ActiveCallsView() {
        VerticalPanel panel = new VerticalPanel();
        Label title = new Label("Текущие звонки:");
        panel.add(title);
        panel.add(new Label("100 Вася 89571359475"));
        Button endButton = new Button("Окончить");
        panel.add(endButton);
        initWidget(panel);
    }
}