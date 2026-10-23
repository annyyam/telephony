package com.telephony.client.queue;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.telephony.shared.QueuedCall;

public interface QueueDisplay extends IsWidget {
    void setQueue(List<QueuedCall> calls);

    void setHandler(QueueHandler handler);

    interface QueueHandler {
        void onAnswerClicked();
    }
}