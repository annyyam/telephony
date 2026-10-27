package com.telephony.client.activeCalls;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.telephony.client.AppEventBus;
import com.telephony.client.CallStateChangedEvent;
import com.telephony.shared.ActiveCall;
import com.telephony.shared.service.TelephonyService;
import com.telephony.shared.service.TelephonyServiceAsync;

public class ActiveCallsPresenter {
    private ActiveCallsDisplay display;
    private TelephonyServiceAsync service;

    public ActiveCallsPresenter(final ActiveCallsDisplay display) {
        this.display = display;
        this.service = GWT.create(TelephonyService.class);
        AppEventBus.get().addHandler(CallStateChangedEvent.getType(), new CallStateChangedEvent.Handler() {
            @Override
            public void onCallStateChanged(CallStateChangedEvent event) {
                loadActiveCalls(); 
            }
        });
        display.setHandler(new ActiveCallsDisplay.ActiveCallsHandler() {
            @Override
            public void onEndCallClicked() {
                Long extNumber = display.getSelectedExtensionNumber();
                
                if (extNumber == null) {
                    Window.alert("Сначала выберите активный звонок!");
                    return;
                }

                sendEndCallRequest(extNumber);
            }
        });
    }
    
    private void sendEndCallRequest(long extensionNumber) {
        service.endCall(extensionNumber, new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                AppEventBus.get().fireEvent(new CallStateChangedEvent());
                Window.alert("Звонок завершен!");
            }

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Ошибка при завершении: " + caught.getMessage());
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