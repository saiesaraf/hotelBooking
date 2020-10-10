package com.company;

public class Room {
    private int roomId;
    private RoomType type;

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", type=" + type +
                '}' + "\n";
    }

    public Room(int roomId, RoomType type) {
        this.roomId = roomId;
        this.type = type;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }
}
