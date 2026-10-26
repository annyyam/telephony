package com.telephony.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.telephony.shared.QueuedCall;

public class CallQueue {
    //синглтон
    private static final CallQueue INSTANCE = new CallQueue();
    public static CallQueue get() { return INSTANCE; }

    private final List<QueuedCall> queue = new ArrayList<QueuedCall>();

    private CallQueue() {
        queue.add(new QueuedCall("8-999-111-22-33", new Date())); //bebebe
    }

    public synchronized boolean add(String phoneNumber) {
        for (QueuedCall call : queue) {
            if (call.getPhoneNumber().equals(phoneNumber)) {
                return false;
            }
        }
        queue.add(new QueuedCall(phoneNumber, new Date()));
        return true;
    }

    public synchronized boolean remove(String phoneNumber) {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).getPhoneNumber().equals(phoneNumber)) {
                queue.remove(i);
                return true;
            }
        }
        return false; 
    }

    public synchronized List<QueuedCall> getAll() {
        return new ArrayList<QueuedCall>(queue);
    }
}