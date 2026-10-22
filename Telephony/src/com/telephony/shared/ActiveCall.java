package com.telephony.shared;

import java.io.Serializable;
import java.util.Date;

public class ActiveCall implements Serializable {
    private String phoneNumber;
    private long extensionNumber;
    private String operatorName;
    private Date time;

    public ActiveCall() {
    }

    public ActiveCall(String phoneNumber, long extensionNumber, String operatorName, Date time) {
        this.phoneNumber = phoneNumber;
        this.extensionNumber = extensionNumber;
        this.operatorName = operatorName;
        this.time = time;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) { 
        this.phoneNumber = phoneNumber; 
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
    public Date getTime() { 
        return time; 
    }
    public void setTime(Date time) { 
        this.time = time; 
    }
}