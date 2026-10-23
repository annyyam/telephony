package com.telephony.shared;

import java.io.Serializable;
import java.util.Date;

public class QueuedCall implements Serializable {
    private String phoneNumber;
    private Date time;
    
    public QueuedCall() {
    }
    public QueuedCall(String phoneNumber, Date time) {
        this.phoneNumber = phoneNumber;
        this.time = time;
    }
    public String getPhoneNumber() { 
        return phoneNumber; 
    }
    public void setPhoneNumber(String phoneNumber) { 
        this.phoneNumber = phoneNumber; 
    }
    public Date getTime() { 
        return time; 
    }
    public void setTime(Date time) { 
        this.time = time; 
    }
}