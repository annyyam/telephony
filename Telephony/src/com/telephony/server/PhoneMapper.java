package com.telephony.server;

import java.util.List;

import com.telephony.shared.Phone;

public interface PhoneMapper {
    Phone getByExtensionNumber(long extensionNumber);
    List<Phone> getPhonesByRoomId(long roomId);
}