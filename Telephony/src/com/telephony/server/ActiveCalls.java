package com.telephony.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.telephony.shared.ActiveCall;

public class ActiveCalls {
    //синглтон
    private static final ActiveCalls INSTANCE = new ActiveCalls();
    public static ActiveCalls get() { return INSTANCE; }
    private final Map<Long, ActiveCall> activeMap = new HashMap<Long, ActiveCall>();
    private ActiveCalls() {
    }

    public synchronized boolean isBusy(long extensionNumber) {
        return activeMap.containsKey(extensionNumber);
    }

    public synchronized void put(long extensionNumber, ActiveCall call) {
        activeMap.put(extensionNumber, call);
    }

    public synchronized ActiveCall remove(long extensionNumber) {
        return activeMap.remove(extensionNumber);
    }

    public synchronized List<ActiveCall> getAll() {
        return new ArrayList<ActiveCall>(activeMap.values());
    }
}