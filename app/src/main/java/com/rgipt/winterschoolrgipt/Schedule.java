package com.rgipt.winterschoolrgipt;

public class Schedule {
    private String date;
    private String event;


    public Schedule() {
        //empty constructor needed
    }

    public Schedule(String date, String event) {
        this.date = date;
        this.event = event;

    }

    public String getDate() {
        return date;
    }

    public String getEvent() {
        return event;
    }

}
