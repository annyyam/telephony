package com.telephony.server;

import com.telephony.shared.Phone;

public interface PhoneMapper {
    Phone getByExtensionNumber(long extensionNumber);
}