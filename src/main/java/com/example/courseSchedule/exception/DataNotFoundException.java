package com.example.courseSchedule.exception;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException() {
        super("Data not found");
    }
}
