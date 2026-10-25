package com.telephony.client.room;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.telephony.shared.Room;
import com.telephony.shared.service.TelephonyService;
import com.telephony.shared.service.TelephonyServiceAsync;

public class RoomPresenter {
    private RoomDisplay display;
    private TelephonyServiceAsync service;

    public RoomPresenter(RoomDisplay display) {
        this.display = display;
        this.service = GWT.create(TelephonyService.class);
        display.setHandler(new RoomDisplay.RoomHandler() {
            @Override
            public void onRoomSelected(Room room) {
                //
                Window.alert("Выбрана комната: " + room.getName() + " (ID: " + room.getId() + ")");
            }
        });
    }

    public void loadRooms() {
        service.getRooms(new AsyncCallback<List<Room>>() {
            @Override
            public void onSuccess(List<Room> result) {
                display.setRooms(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Не удалось загрузить комнаты: " + caught.getMessage());
            }
        });
    }
}