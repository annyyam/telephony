package com.telephony.client.room;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.telephony.shared.PhoneWithStatus;
import com.telephony.shared.Room;

public interface RoomDisplay extends IsWidget {
    void setRooms(List<Room> rooms);
    
    void setPhones(long roomId, List<PhoneWithStatus> phones);
    
    void setHandler(RoomHandler handler);

    interface RoomHandler {
        void onRoomSelected(Room room);
    }
}