package com.telephony.client.activeCalls;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.telephony.shared.ActiveCall;

public class ActiveCallsView extends Composite implements ActiveCallsDisplay {
    private FlowPanel listPanel;
    private Button endButton;
    private ActiveCallsHandler handler;
    
    public ActiveCallsView() {
        FlowPanel panel = new FlowPanel();
        panel.setStyleName("panelBox");
        panel.addStyleName("activePanel");
        
        Label title = new Label("Текущие звонки:");
        title.setStyleName("sectionTitle");
        panel.add(title);
        
        listPanel = new FlowPanel();
        panel.add(listPanel);
        
        Button endButton = new Button("Окончить");
        endButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if (handler != null) {
                    handler.onEndCallClicked();
                }
            }
        });
        panel.add(endButton);
        initWidget(panel);
    }

    @Override
    public void setActiveCalls(List<ActiveCall> calls) {
        listPanel.clear();
        for (ActiveCall call : calls) {
            String text = call.getExtensionNumber() + " " + call.getOperatorName() + " " + call.getPhoneNumber();
            Label label = new Label(text);
            label.setStyleName("listItem");
            listPanel.add(label);
        }
    }

    @Override
    public void setHandler(ActiveCallsHandler handler) {
        this.handler = handler;
    }
}