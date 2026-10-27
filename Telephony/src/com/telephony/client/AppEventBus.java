package com.telephony.client;

import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class AppEventBus {
    private static final EventBus EVENT_BUS = new SimpleEventBus();
    
    public static EventBus get() {
        return EVENT_BUS;
    }
}