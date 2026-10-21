package com.telephony.shared;

import java.io.Serializable;

public class PhoneWithStatus implements Serializable {
    private long id;
    private long extensionNumber;
    private String operatorName;
    private String currentCallPhoneNumber; 
    
    public PhoneWithStatus() {
    }
    public PhoneWithStatus(long id, long extensionNumber, String operatorName, String currentCallPhoneNumber) {
        this.id = id;
        this.extensionNumber = extensionNumber;
        this.operatorName = operatorName;
        this.currentCallPhoneNumber = currentCallPhoneNumber;
    }
    public long getId() { 
        return id; 
    }
    public void setId(long id) { 
        this.id = id; 
    }
    public long getExtensionNumber() { 
        return extensionNumber; 
    }
    public void setExtensionNumber(long extensionNumber) { 
        this.extensionNumber = extensionNumber; 
    }
    public String getOperatorName() { 
        return operatorName; 
    }
    public void setOperatorName(String operatorName) { 
        this.operatorName = operatorName; 
    }
    public String getCurrentCallPhoneNumber() {
        return currentCallPhoneNumber; 
    }
    public void setCurrentCallPhoneNumber(String currentCallPhoneNumber) { 
        this.currentCallPhoneNumber = currentCallPhoneNumber; 
    }
}