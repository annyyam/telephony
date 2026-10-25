package com.telephony.client.room;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.telephony.shared.Room;

public class RoomView extends Composite implements RoomDisplay {
    private FlowPanel listPanel;
    private RoomHandler handler;

    public RoomView() {
        FlowPanel rootPanel = new FlowPanel();
        rootPanel.setStyleName("panelBox");
        rootPanel.addStyleName("roomPanel");
        Label title = new Label("Комнаты");
        title.setStyleName("sectionTitle");
        rootPanel.add(title);
        listPanel = new FlowPanel();
        rootPanel.add(listPanel);
        initWidget(rootPanel);
    }

    @Override
    public void setRooms(List<Room> rooms) {
        listPanel.clear();
        for (final Room room : rooms) {
            Label label = new Label(room.getName());
            label.setStyleName("listItem");
            label.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (handler != null) {
                        handler.onRoomSelected(room);
                    }
                }
            });
            listPanel.add(label);
        }
    }

    @Override
    public void setHandler(RoomHandler handler) {
        this.handler = handler;
    }
}