package com.telephony.client.activeCalls;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.telephony.shared.ActiveCall;
import com.telephony.shared.service.TelephonyService;
import com.telephony.shared.service.TelephonyServiceAsync;

public class ActiveCallsPresenter {
    private ActiveCallsDisplay display;
    private TelephonyServiceAsync service;

    public ActiveCallsPresenter(ActiveCallsDisplay display) {
        this.display = display;
        this.service = GWT.create(TelephonyService.class);
        display.setHandler(new ActiveCallsDisplay.ActiveCallsHandler() {
            @Override
            public void onEndCallClicked() {
                //
                Window.alert(":)))");
            }
        });
    }

    public void loadActiveCalls() {
        service.getActiveCalls(new AsyncCallback<List<ActiveCall>>() {
            @Override
            public void onSuccess(List<ActiveCall> result) {
                display.setActiveCalls(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Не удалось загрузить активные звонки: " + caught.getMessage());
            }
        });
    }
}