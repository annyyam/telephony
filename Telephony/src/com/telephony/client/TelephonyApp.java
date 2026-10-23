package com.telephony.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.telephony.client.activeCalls.ActiveCallsView;
import com.telephony.client.queue.QueueView;
import com.telephony.client.room.RoomView;

public class TelephonyApp implements EntryPoint {

    @Override
    public void onModuleLoad() {
        HorizontalPanel panel = new HorizontalPanel();
        panel.setStyleName("mainLayout");
        panel.setSpacing(20); //
        
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP); 
        
        RoomView roomView = new RoomView();
        panel.add(roomView);
        
        QueueView queueView = new QueueView();
        panel.add(queueView);
        
        VerticalPanel rightPanel = new VerticalPanel();
        Label appTitle = new Label("ТЕЛЕФОНИЯ");
        appTitle.setStyleName("appTitle");
        rightPanel.add(appTitle);
        
        ActiveCallsView activeCallsView = new ActiveCallsView();
        rightPanel.add(activeCallsView);
        
        panel.add(rightPanel);
        RootPanel.get().add(panel);
    }
}