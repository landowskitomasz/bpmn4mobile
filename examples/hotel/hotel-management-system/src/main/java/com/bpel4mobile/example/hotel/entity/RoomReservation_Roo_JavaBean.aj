// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bpel4mobile.example.hotel.entity;

import com.bpel4mobile.example.hotel.entity.Room;
import com.bpel4mobile.example.hotel.entity.RoomReservation;
import java.util.Date;

privileged aspect RoomReservation_Roo_JavaBean {
    
    public Room RoomReservation.getRoom() {
        return this.room;
    }
    
    public void RoomReservation.setRoom(Room room) {
        this.room = room;
    }
    
    public String RoomReservation.getCustomerFirstName() {
        return this.customerFirstName;
    }
    
    public void RoomReservation.setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }
    
    public String RoomReservation.getCustomerLastName() {
        return this.customerLastName;
    }
    
    public void RoomReservation.setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }
    
    public Date RoomReservation.getStartDate() {
        return this.startDate;
    }
    
    public void RoomReservation.setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date RoomReservation.getEndDate() {
        return this.endDate;
    }
    
    public void RoomReservation.setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
}