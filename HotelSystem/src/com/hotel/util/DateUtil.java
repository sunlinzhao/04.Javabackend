package com.hotel.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {
    public Date format(LocalDateTime dateTime){
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
