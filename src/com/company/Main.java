package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {

        Hotel hotel = new Hotel();
        hotel.init();

        Date startDate=new SimpleDateFormat("dd/MM/yyyy").parse("22/02/2020");
        Date endDate=new SimpleDateFormat("dd/MM/yyyy").parse("25/02/2020");

        List<Room> availableRooms = hotel.getAvailability(startDate, endDate, RoomType.queen);
        System.out.println("Before booking" + availableRooms);
        hotel.bookRoom(availableRooms.get(0), startDate, endDate);

        availableRooms = hotel.getAvailability(startDate, endDate, RoomType.queen);
        System.out.println("after booking" + availableRooms);

        hotel.cancelRoom(1);
        availableRooms = hotel.getAvailability(startDate, endDate, RoomType.queen);
        System.out.println("after cancelling" + availableRooms);
    }
}
