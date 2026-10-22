package com.telephony.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RoomView extends Composite {

    public RoomView() {
        VerticalPanel panel = new VerticalPanel();
        panel.setWidth("250px");
        Label title = new Label("Комнаты");
        panel.add(title);
        panel.add(new Label("Главный зал"));
        panel.add(new Label("100 Вася")); 
        panel.add(new Label("101 Коля"));
        panel.add(new Label("Офис"));
        panel.add(new Label("202 Юля"));
        initWidget(panel);
    }
}