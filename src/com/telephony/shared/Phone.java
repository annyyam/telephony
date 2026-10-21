package com.telephony.shared;

import java.io.Serializable;

public class Phone implements Serializable {
    private long id;
    private long extensionNumber;
    private long roomId;
    private String operatorName;

    public Phone() {
    }
    public Phone(long id, long extensionNumber, long roomId, String operatorName) {
        this.id = id;
        this.extensionNumber = extensionNumber;
        this.roomId = roomId;
        this.operatorName = operatorName;
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
    public long getRoomId() { 
        return roomId; 
    }
    public void setRoomId(long roomId) { 
        this.roomId = roomId; 
    }
    public String getOperatorName() { 
        return operatorName; 
    }
    public void setOperatorName(String operatorName) { 
        this.operatorName = operatorName; 
    }
}