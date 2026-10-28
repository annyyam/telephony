package com.telephony.client.queue;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.telephony.client.AppEventBus;
import com.telephony.client.CallStateChangedEvent;
import com.telephony.client.SelectionContext;
import com.telephony.shared.QueuedCall;
import com.telephony.shared.service.TelephonyService;
import com.telephony.shared.service.TelephonyServiceAsync;

public class QueuePresenter {
    private QueueDisplay display;
    private TelephonyServiceAsync service;

    public QueuePresenter(final QueueDisplay display) {
        this.display = display;
        this.service = GWT.create(TelephonyService.class);
        display.setHandler(new QueueDisplay.QueueHandler() {
            @Override
            public void onAnswerClicked() {
                String phoneNumber = display.getSelectedPhoneNumber();
                
                if (phoneNumber == null) {
                    Window.alert("Сначала выберите звонок из очереди!");
                    return;
                }

                Long extensionNumber = SelectionContext.get().getSelectedExtension();
                
                if (extensionNumber == null) {
                    Window.alert("Сначала выберите аппарат (оператора) в левой панели!");
                    return;
                }

                sendAnswerRequest(extensionNumber, phoneNumber);
            }
        });
    }
    
    private void sendAnswerRequest(long extensionNumber, String phoneNumber) {
        service.answerCall(extensionNumber, phoneNumber, new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                loadQueue();
                AppEventBus.get().fireEvent(new CallStateChangedEvent());
                Window.alert("Звонок успешно принят!");
            }

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Ошибка при ответе: " + caught.getMessage());
            }
        });
    }


    public void loadQueue() {
        service.getQueue(new AsyncCallback<List<QueuedCall>>() {
            @Override
            public void onSuccess(List<QueuedCall> result) {
                display.setQueue(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Не удалось загрузить очередь: " + caught.getMessage());
            }
        });
    }
}