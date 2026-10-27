package com.telephony.client;

import com.google.web.bindery.event.shared.Event;

public class CallStateChangedEvent extends Event<CallStateChangedEvent.Handler> {

    public interface Handler {
        void onCallStateChanged(CallStateChangedEvent event);
    }

    private static final Type<Handler> TYPE = new Type<Handler>();

    public static Type<Handler> getType() {
        return TYPE;
    }

    @Override
    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onCallStateChanged(this);
    }
}