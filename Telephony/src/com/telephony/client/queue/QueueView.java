package com.telephony.client.queue;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class QueueView extends Composite {

    public QueueView() {
        VerticalPanel panel = new VerticalPanel();
        panel.setStyleName("panelBox");
        panel.addStyleName("queuePanel");
        Label title = new Label("Очередь звонков:");
        title.setStyleName("sectionTitle");
        panel.add(title);
        panel.add(new Label("89526785219"));
        panel.add(new Label("89892187364"));
        Button answerButton = new Button("Ответить");
        panel.add(answerButton);
        initWidget(panel);
    }
}