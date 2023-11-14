import Entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int number = scanner.nextInt();

        System.out.print("Check-In date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(scanner.next());

        System.out.print("Check-Out date (dd/mm/yyyy: ");
        Date checkout = sdf.parse(scanner.next());

        if (!checkout.after(checkin)){
            System.out.println("[ERRO] Checkout date must be after checkin date");

        }else{
            Reservation reservation = new Reservation(checkin, checkout, number);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-In date (dd/MM/yyyy): ");
             checkin = sdf.parse(scanner.next());

            System.out.print("Check-Out date (dd/mm/yyyy: ");
             checkout = sdf.parse(scanner.next());

             Date now = new Date();
             if (checkin.before(now) || checkout.before(now)){
                 System.out.println("[ERRO] RESERVATION DATES FOR UPDATE MUST BE FUTURE");
             }else if(!checkout.after(checkin)) {
                 System.out.println("Enter data to update the reservation: ");
             }else{

             reservation.updateDates(checkin, checkout);
            System.out.println(reservation);
        }
    }

    }
}