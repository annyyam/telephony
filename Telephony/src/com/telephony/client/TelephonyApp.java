package com.telephony.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TelephonyApp implements EntryPoint {

    @Override
    public void onModuleLoad() {
        HorizontalPanel panel = new HorizontalPanel();
        RoomView roomTreeView = new RoomView();
        panel.add(roomTreeView);
        VerticalPanel rightPanel = new VerticalPanel();
        Label appTitle = new Label("ТЕЛЕФОНИЯ");
        rightPanel.add(appTitle);
        QueueView queueView = new QueueView();
        rightPanel.add(queueView);
        ActiveCallsView activeCallsView = new ActiveCallsView();
        rightPanel.add(activeCallsView);
        panel.add(rightPanel);
        RootPanel.get().add(panel);
    }
    // +добавить setStyleName 
}