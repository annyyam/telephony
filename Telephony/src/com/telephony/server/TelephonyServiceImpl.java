package com.telephony.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.telephony.shared.ActiveCall;
import com.telephony.shared.Phone;
import com.telephony.shared.PhoneWithStatus;
import com.telephony.shared.QueuedCall;
import com.telephony.shared.Room;
import com.telephony.shared.TelephonyException;
import com.telephony.shared.service.TelephonyService;

@SuppressWarnings("serial")
public class TelephonyServiceImpl extends RemoteServiceServlet implements TelephonyService {
    @Override
    public List<Room> getRooms() throws TelephonyException {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            RoomMapper mapper = session.getMapper(RoomMapper.class);
            return mapper.getAllRooms();
        } finally {
            session.close();
        }
    }

    //
    @Override
    public List<QueuedCall> getQueue() throws TelephonyException {
        return CallQueue.get().getAll();
    }

    @Override
    public List<ActiveCall> getActiveCalls() throws TelephonyException {
        return ActiveCalls.get().getAll();
    }

    @Override
    public void answerCall(long extensionNumber, String phoneNumber) throws TelephonyException {
        boolean inQueue = false;
        for (QueuedCall call : CallQueue.get().getAll()) {
            if (call.getPhoneNumber().equals(phoneNumber)) {
                inQueue = true;
                break;
            }
        }
        if (!inQueue) {
            throw new TelephonyException(TelephonyException.Reason.CALL_NOT_IN_QUEUE, "Входящий звонок не найден в очереди");
        }

        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        Phone phone;
        try {
            PhoneMapper mapper = session.getMapper(PhoneMapper.class);
            phone = mapper.getByExtensionNumber(extensionNumber);
        } finally {
            session.close();
        }
        
        if (phone == null) {
            throw new TelephonyException(TelephonyException.Reason.PHONE_NOT_FOUND, "Аппарат не найден");
        }

        if (ActiveCalls.get().isBusy(extensionNumber)) {
            throw new TelephonyException(TelephonyException.Reason.PHONE_BUSY, "Аппарат занят");
        }

        CallQueue.get().remove(phoneNumber);
        ActiveCall newActive = new ActiveCall(phoneNumber, extensionNumber, phone.getOperatorName(), new Date());
        ActiveCalls.get().put(extensionNumber, newActive);
    }
    

    @Override
    public void endCall(long extensionNumber) throws TelephonyException {
        if (!ActiveCalls.get().isBusy(extensionNumber)) {
            throw new TelephonyException(TelephonyException.Reason.PHONE_FREE, "Аппарат свободен (нет активного звонка)");
        }
        ActiveCalls.get().remove(extensionNumber);
    }

    @Override
    public List<PhoneWithStatus> getPhonesInRoom(long roomId) throws TelephonyException {
        return new ArrayList<PhoneWithStatus>();
    }
}