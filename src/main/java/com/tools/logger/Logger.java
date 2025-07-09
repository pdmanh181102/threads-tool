package com.tools.logger;

public class Logger {
    public static void log(String message) {
        System.out.println("[LOG] " + message);
    }
    public static void logError(String message, Throwable throwable) {
        System.err.println("[ERROR] " + message);
        throwable.printStackTrace();
    }
    public static void logInfo(String message) {
        System.out.println("[INFO] " + message);
    }
    public static void logDebug(String message) {
        System.out.println("[DEBUG] " + message);
    }
    public static void logWarning(String message) {
        System.out.println("[WARNING] " + message);
    }
    public static void logFatal(String message) {
        System.err.println("[FATAL] " + message);
    }
}
