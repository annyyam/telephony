package com.telephony.client.room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.telephony.client.SelectionContext;
import com.telephony.shared.PhoneWithStatus;
import com.telephony.shared.Room;

public class RoomView extends Composite implements RoomDisplay {
    private FlowPanel listPanel;
    private RoomHandler handler;
    private Map<Long, FlowPanel> phonesPanels = new HashMap<Long, FlowPanel>();
    private Label selectedPhoneLabel = null;
    
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
            
            final FlowPanel phonesPanel = new FlowPanel();
            phonesPanel.setStyleName("phonesPanel");
            listPanel.add(phonesPanel);
            phonesPanels.put(room.getId(), phonesPanel);
        }
    }
    
    @Override
    public void setPhones(long roomId, List<PhoneWithStatus> phones) {
        FlowPanel phonesPanel = phonesPanels.get(roomId);
        if (phonesPanel == null) return;
        
        phonesPanel.clear();
        
        for (final PhoneWithStatus phone : phones) {
            String text = "  " + phone.getExtensionNumber() + " " + phone.getOperatorName();
            final Label phoneLabel = new Label(text);
            phoneLabel.setStyleName("listItem");
            phoneLabel.getElement().getStyle().setCursor(com.google.gwt.dom.client.Style.Cursor.POINTER);
            
            if (phone.getCurrentCallPhoneNumber() != null) {
                phoneLabel.setText(text + " (занят)");
            }
            
            phoneLabel.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (selectedPhoneLabel != null) {
                        selectedPhoneLabel.removeStyleName("listItemSelected");
                    }
                    selectedPhoneLabel = phoneLabel;
                    selectedPhoneLabel.addStyleName("listItemSelected");
                    
                    SelectionContext.get().setSelectedExtension(phone.getExtensionNumber());
                }
            });
            phonesPanel.add(phoneLabel);
        }
    }

    @Override
    public void setHandler(RoomHandler handler) {
        this.handler = handler;
    }
}