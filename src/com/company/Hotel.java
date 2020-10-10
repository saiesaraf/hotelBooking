package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel {
    List<Room> roomList;
    List<Booking> bookingList;

    public Hotel() {
        roomList = new ArrayList<>();
        bookingList = new ArrayList<>();
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public void init() {
        //initializing rooms
        Room newRoom1 = new Room(1,RoomType.king);
        Room newRoom2 = new Room(2,RoomType.queen);
        Room newRoom3 = new Room(3,RoomType.king);
        Room newRoom4 = new Room(4,RoomType.classic);
        Room newRoom5 = new Room(5,RoomType.queen);

        roomList.add(newRoom1);
        roomList.add(newRoom2);
        roomList.add(newRoom3);
        roomList.add(newRoom4);
        roomList.add(newRoom5);
    }

    public List<Room> getAvailability(Date startTime,Date endTime, RoomType newType){
        List<Room> availableRooms = new ArrayList<>();
        for(Room room: roomList){
            if(room.getType().equals(newType) && !isBooked(room,startTime,endTime))
                availableRooms.add(room);
        }
        return availableRooms;
    }

    private boolean isBooked(Room room, Date newStartTime, Date newEndTime) {
        for(int i=0;i<bookingList.size();i++){
            Booking temp = bookingList.get(i);
            if(temp.getRoom().getRoomId() == room.getRoomId()) {
                if(newStartTime.equals(temp.getStartTime()) || newStartTime.equals(temp.getEndTime()))
                    return true;
                if(newEndTime.equals(temp.getStartTime()) || newEndTime.equals(temp.getEndTime()))
                    return true;

                if(newStartTime.after(temp.getStartTime()) && newStartTime.before(temp.getEndTime()))
                    return true;
                if(newEndTime.after(temp.getStartTime()) && newEndTime.before(temp.getEndTime()))
                    return true;

            }
        }

        return false;

    }

    public void bookRoom(Room room,Date startTime, Date endTime) {
        Booking newBooking = new Booking(room,startTime,endTime);
        bookingList.add(newBooking);
        System.out.println("your room is booked" + newBooking);
    }

    public void cancelRoom(int bookingId){
        for(int i=0;i<bookingList.size();i++) {
            if(bookingList.get(i).getBookingId() == bookingId) {
                bookingList.remove(i);
                System.out.println("Successfully cancelled id");
                return;
            }
        }
        System.out.println("invalid booking id");
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "roomList=" + roomList +
                ", bookingList=" + bookingList +
                '}';
    }
}
