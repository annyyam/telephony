package com.telephony.client.queue;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.telephony.shared.QueuedCall;
import com.telephony.shared.service.TelephonyService;
import com.telephony.shared.service.TelephonyServiceAsync;

public class QueuePresenter {
    private QueueDisplay display;
    private TelephonyServiceAsync service;

    public QueuePresenter(QueueDisplay display) {
        this.display = display;
        this.service = GWT.create(TelephonyService.class);
        display.setHandler(new QueueDisplay.QueueHandler() {
            @Override
            public void onAnswerClicked() {
                //
                Window.alert(":)))");
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