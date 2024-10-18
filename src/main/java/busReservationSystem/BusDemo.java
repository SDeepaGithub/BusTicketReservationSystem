package busReservationSystem;

import java.sql.SQLException;
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
		
		BusDAO busData = new BusDAO();
		
		try {
			busData.displayBusDetails();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	        
		int userChoice = 1;
		Scanner scanner = new Scanner(System.in);
		
		while(userChoice == 1) {
			System.out.println("Enter 1 to Booking || Enter 2 to exit");
			userChoice = scanner.nextInt();
			if(userChoice == 1) {
				Booking booking = new Booking();
				try {
					if(booking.isAvailable()) {
						BookingDAO bookingDao = new BookingDAO();
						bookingDao.addBooking(booking);
						System.out.println("Slot Confirmed");
					}else {
						System.out.println("Sorry Slot Full Please select another Date or Bus");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
