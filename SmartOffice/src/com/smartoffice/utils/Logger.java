package com.smartoffice.utils;

public class Logger {
    public static void log(String msg) {
        System.out.println("[INFO] " + msg);
    }

    public static void error(String msg) {
        System.err.println("[ERROR] " + msg);
    }
}
