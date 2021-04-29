package com.todo.util;

import java.text.SimpleDateFormat;

public class DateFormat {
    public static final SimpleDateFormat getFormat(){
        return  new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }
}
