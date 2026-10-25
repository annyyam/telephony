package com.telephony.shared.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.telephony.shared.ActiveCall;
import com.telephony.shared.PhoneWithStatus;
import com.telephony.shared.QueuedCall;
import com.telephony.shared.Room;
import com.telephony.shared.TelephonyException;

//url по которому сервер будет ждать rpc-запросы:
@RemoteServiceRelativePath("rpc")
public interface TelephonyService extends RemoteService {
    //операция 3
    List<QueuedCall> getQueue() throws TelephonyException;
    //операция 4
    void answerCall(long extensionNumber, String phoneNumber) throws TelephonyException;
    //операция 5
    void endCall(long extensionNumber) throws TelephonyException;
    //операция 6
    List<ActiveCall> getActiveCalls() throws TelephonyException;
    //операция 7
    List<Room> getRooms() throws TelephonyException;
    //операция 8
    List<PhoneWithStatus> getPhonesInRoom(long roomId) throws TelephonyException;
}