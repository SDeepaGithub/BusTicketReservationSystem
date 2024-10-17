package busReservationSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class BusDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Instead of creating the Separate Object for each Bus we use the ArrayList
		//Bus busObj[] = new Bus[40];
		//Bus busObj = new Bus();
		/* Creation of List of the Bus Using ArrayList with Example
		ArrayList<Integer> nums = new ArrayList<Integer>();	
		System.out.println(nums);
		*/
		
		ArrayList<Bus> buses = new ArrayList<Bus>();
		buses.add(new Bus(1,true,2));
		buses.add(new Bus(2,true,3));
		buses.add(new Bus(3,true,4));
		
		ArrayList<Booking> bookingList = new ArrayList<Booking>();
		
		for(Bus b:buses) {
			b.displayBusDetails();
		}
		
        
		int userChoice = 1;
		Scanner scanner = new Scanner(System.in);
		
		while(userChoice == 1) {
			System.out.println("Enter 1 to Booking || Enter 2 to exit");
			userChoice = scanner.nextInt();
			if(userChoice == 1) {
				Booking booking = new Booking();
				if(booking.isAvailable(buses,bookingList)) {
					bookingList.add(booking);
					System.out.println("Slot Confirmed");
				}else {
					System.out.println("Sorry Slot Full Please select another Date or Bus");
				}
			}
		}
	}

}
