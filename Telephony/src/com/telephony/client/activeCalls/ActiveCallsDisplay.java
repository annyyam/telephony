package com.telephony.client.activeCalls;

import java.util.List;
import com.google.gwt.user.client.ui.IsWidget;
import com.telephony.shared.ActiveCall;

public interface ActiveCallsDisplay extends IsWidget {
    void setActiveCalls(List<ActiveCall> calls);

    void setHandler(ActiveCallsHandler handler);

    interface ActiveCallsHandler {
        void onEndCallClicked();
    }
}