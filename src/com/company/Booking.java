package com.company;

import java.util.Date;

public class Booking {
    private static int currId = 1;

    private int bookingId;
    private Room room;
    private Date startTime;
    private Date endTime;


    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", room=" + room +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId1) {
        bookingId = bookingId1;
    }

    public Booking(Room room, Date startTime, Date endTime) {
        bookingId = currId;
        currId++;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
