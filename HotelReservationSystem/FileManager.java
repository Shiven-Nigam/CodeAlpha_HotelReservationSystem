import java.io.*;

public class FileManager {

    public static void saveBooking(Booking booking) {

        try {

            FileWriter fw = new FileWriter("bookings.txt", true);

            fw.write(booking.toString());

            fw.write("\n");

            fw.close();

        } catch(Exception e) {

            System.out.println("Error Saving Booking");

        }

    }

}