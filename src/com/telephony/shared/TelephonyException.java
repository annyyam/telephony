package com.telephony.shared;

public class TelephonyException extends Exception {
    private Reason reason;
    
    public enum Reason {
        PHONE_NOT_FOUND,
        CALL_NOT_IN_QUEUE, 
        PHONE_BUSY,
        PHONE_FREE, 
        ROOM_NOT_FOUND, 
        QUEUE_UNAVAILABLE,    // не удалось получить очередь
        ACTIVE_CALLS_UNAVAILABLE, // не удалось получить активные звонки
        ROOMS_UNAVAILABLE     // не удалось получить комнаты
    }
    public TelephonyException() {
    }
    public TelephonyException(Reason reason, String message) {
        super(message);
        this.reason = reason;
    }
    public Reason getReason() {
        return reason;
    }
}