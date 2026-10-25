package com.telephony.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.telephony.client.activeCalls.ActiveCallsPresenter;
import com.telephony.client.activeCalls.ActiveCallsView;
import com.telephony.client.queue.QueuePresenter;
import com.telephony.client.queue.QueueView;
import com.telephony.client.room.RoomPresenter;
import com.telephony.client.room.RoomView;

public class TelephonyApp implements EntryPoint {

    @Override
    public void onModuleLoad() {
        HorizontalPanel panel = new HorizontalPanel();
        panel.setStyleName("mainLayout");
        panel.setSpacing(20);
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP); 
        
        //rooms
        RoomView roomView = new RoomView();
        RoomPresenter roomPresenter = new RoomPresenter(roomView);
        roomPresenter.loadRooms(); // Просим данные с сервера
        panel.add(roomView);
        
        //queue
        QueueView queueView = new QueueView();
        QueuePresenter queuePresenter = new QueuePresenter(queueView);
        queuePresenter.loadQueue(); // Просим данные с сервера
        panel.add(queueView);
        
        //calls
        VerticalPanel rightPanel = new VerticalPanel();
        Label appTitle = new Label("ТЕЛЕФОНИЯ");
        appTitle.setStyleName("appTitle");
        rightPanel.add(appTitle);
        ActiveCallsView activeCallsView = new ActiveCallsView();
        ActiveCallsPresenter activeCallsPresenter = new ActiveCallsPresenter(activeCallsView);
        activeCallsPresenter.loadActiveCalls(); // Просим данные с сервера
        rightPanel.add(activeCallsView);
        panel.add(rightPanel);
        
        RootPanel.get().add(panel);
    }
}