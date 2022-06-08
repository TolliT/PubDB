package com.kocsma.controller;

public class ExceptionHandler {
    public static void errorData(Exception ex){
        System.err.println("- Error: " + ex.getMessage());
        System.err.println("- Stacktrace: ");

        ex.printStackTrace();

        System.exit(0);
    }
}
