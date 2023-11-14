package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Date checkin;
    private Date checkout;
    private Integer roomNumber;

    public Reservation(Date checkin, Date checkout, Integer roomNumber) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
    public long duration(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MICROSECONDS);
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void updateDates(Date checkin, Date checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", ceck-in: "
                + sdf.format(checkin)
                + ", checkout"
                + sdf.format(checkout)
                +", "
                + duration()
                +" Nights";
    }
}
