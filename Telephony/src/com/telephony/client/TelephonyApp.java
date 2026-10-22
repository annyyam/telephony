package com.telephony.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class TelephonyApp implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Label hello = new Label("Telephony");
        hello.setStyleName("appTitle");
        RootPanel.get().add(hello);
    }
}