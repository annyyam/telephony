package com.telephony.client.queue;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.telephony.shared.QueuedCall;

public class QueueView extends Composite implements QueueDisplay {
    private FlowPanel listPanel;
    private Button answerButton;
    private QueueHandler handler;
    private String selectedPhoneNumber = null;
    private Label selectedLabel = null;
   
    public QueueView() {
        FlowPanel panel = new FlowPanel();
        panel.setStyleName("panelBox");
        panel.addStyleName("queuePanel");

        Label title = new Label("Очередь звонков:");
        title.setStyleName("sectionTitle");
        panel.add(title);

        listPanel = new FlowPanel();
        panel.add(listPanel);

        Button answerButton = new Button("Ответить");
        answerButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (handler != null) {
                    handler.onAnswerClicked();
                }
            }

        });
        panel.add(answerButton);
        initWidget(panel);
    }

    @Override
    public void setQueue(List<QueuedCall> calls) {
        listPanel.clear();
        selectedLabel = null;
        for (final QueuedCall call : calls) {
            final Label label = new Label(call.getPhoneNumber());
            label.setStyleName("listItem");
            label.getElement().getStyle().setCursor(com.google.gwt.dom.client.Style.Cursor.POINTER);
            if (call.getPhoneNumber().equals(selectedPhoneNumber)) {
                label.addStyleName("listItemSelected");
                selectedLabel = label;
            }
            label.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    // офф подсветку со старого
                    if (selectedLabel != null) {
                        selectedLabel.removeStyleName("listItemSelected");
                    }
                    // он новый
                    selectedLabel = label;
                    selectedLabel.addStyleName("listItemSelected");
                    selectedPhoneNumber = call.getPhoneNumber();
                }
            });
            
            listPanel.add(label);
        }
    }

    @Override
    public void setHandler(QueueHandler handler) {
        this.handler = handler;
    }

    @Override
    public String getSelectedPhoneNumber() {
        return selectedPhoneNumber;
    }
}