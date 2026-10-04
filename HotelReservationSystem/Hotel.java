import java.util.*;

public class Hotel {

    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    public Hotel() {

        rooms.add(new Room(101,"Standard",1500));
        rooms.add(new Room(102,"Standard",1500));
        rooms.add(new Room(103,"Standard",1500));

        rooms.add(new Room(201,"Deluxe",2500));
        rooms.add(new Room(202,"Deluxe",2500));

        rooms.add(new Room(301,"Suite",4500));
    }

    public void searchRooms() {

        System.out.println("\nAvailable Rooms");

        for(Room room: rooms){

            if(room.isAvailable())
                System.out.println(room);

        }

    }

    public void bookRoom(){

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Name : ");

        String name=sc.nextLine();

        System.out.print("Enter Room Number : ");

        int roomNo=sc.nextInt();

        for(Room room:rooms){

            if(room.getRoomNumber()==roomNo && room.isAvailable()){

                Payment.processPayment(room.getPrice());

                room.setAvailable(false);

                Booking booking=new Booking(name,roomNo,room.getCategory());

                bookings.add(booking);

                FileManager.saveBooking(booking);

                System.out.println("Room Booked Successfully!");

                return;
            }

        }

        System.out.println("Room Not Available");

    }

    public void cancelBooking(){

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Room Number : ");

        int roomNo=sc.nextInt();

        Iterator<Booking> iterator=bookings.iterator();

        while(iterator.hasNext()){

            Booking booking=iterator.next();

            if(booking.getRoomNumber()==roomNo){

                iterator.remove();

                for(Room room:rooms){

                    if(room.getRoomNumber()==roomNo)

                        room.setAvailable(true);

                }

                System.out.println("Booking Cancelled");

                return;

            }

        }

        System.out.println("Booking Not Found");

    }

    public void viewBookings(){

        if(bookings.isEmpty()){

            System.out.println("No Bookings");

            return;

        }

        for(Booking booking:bookings)

            System.out.println(booking);

    }

}