package com.telephony.shared.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.telephony.shared.ActiveCall;
import com.telephony.shared.PhoneWithStatus;
import com.telephony.shared.QueuedCall;
import com.telephony.shared.Room;

public interface TelephonyServiceAsync {
    void getQueue(AsyncCallback<List<QueuedCall>> callback);
    void answerCall(long extensionNumber, String phoneNumber, AsyncCallback<Void> callback);
    void endCall(long extensionNumber, AsyncCallback<Void> callback);
    void getActiveCalls(AsyncCallback<List<ActiveCall>> callback);
    void getRooms(AsyncCallback<List<Room>> callback);
    void getPhonesInRoom(long roomId, AsyncCallback<List<PhoneWithStatus>> callback);
}