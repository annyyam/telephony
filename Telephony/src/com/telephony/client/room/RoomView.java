package com.telephony.client.room;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RoomView extends Composite {

    public RoomView() {
        VerticalPanel panel = new VerticalPanel();
        panel.setStyleName("panelBox");
        panel.addStyleName("roomPanel");
        panel.setWidth("250px");
        Label title = new Label("Комнаты");
        title.setStyleName("sectionTitle");
        panel.add(title);

        Label room1 = new Label("Главный зал");
        room1.setStyleName("listItem");
        panel.add(room1);
        panel.add(new Label("100 Вася")); 
        panel.add(new Label("101 Коля"));
        Label room2 = new Label("Офис");
        room2.setStyleName("listItem");
        panel.add(room2);
        panel.add(new Label("202 Юля"));
        initWidget(panel);
    }
}