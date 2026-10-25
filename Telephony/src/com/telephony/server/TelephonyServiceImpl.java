package com.telephony.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.telephony.shared.ActiveCall;
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
        return new ArrayList<QueuedCall>();
    }

    @Override
    public List<ActiveCall> getActiveCalls() throws TelephonyException {
        return new ArrayList<ActiveCall>();
    }

    @Override
    public void answerCall(long extensionNumber, String phoneNumber) throws TelephonyException {
    }

    @Override
    public void endCall(long extensionNumber) throws TelephonyException {
    }

    @Override
    public List<PhoneWithStatus> getPhonesInRoom(long roomId) throws TelephonyException {
        return new ArrayList<PhoneWithStatus>();
    }
}