package com.telephony.client;

public class SelectionContext {
    private static final SelectionContext INSTANCE = new SelectionContext();
    public static SelectionContext get() { return INSTANCE; }

    private Long selectedExtensionNumber = null;

    public void setSelectedExtension(Long ext) {
        this.selectedExtensionNumber = ext;
    }

    public Long getSelectedExtension() {
        return selectedExtensionNumber;
    }
}