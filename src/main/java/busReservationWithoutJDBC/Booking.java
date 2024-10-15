package busReservationWithoutJDBC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {

	private String passengerName;
	private int busNo;
	private Date date;
	Scanner scanner = new Scanner(System.in);
	
	public String getPassengerName() { //accessor method
		return passengerName;
	}
	
	public void setPassengerName(String name) { //mutated method
		passengerName = name;
	}
	
	public int getbusNo() { //accessor method
		return busNo;
	}
	
	public void setbusNo(int value) { //mutated method
		busNo = value;
	}
	
	public Date getDate() { //accessor method
		return date;
	}
	
	public void setDate(Date dateValue) { //mutated method
		date = dateValue;
	}
	
	

	Booking(String passengerName,int busNo,Date date){
		this.passengerName = passengerName;
		this.busNo = busNo;
		this.date = date;
	}
	
	Booking(){
		System.out.println("Enter Your Name");
		passengerName = scanner.next();
		System.out.println("Enter Bus No");
		busNo = scanner.nextInt();
		System.out.println("Enter Date in the format dd-MM-yyyy");
		String dataInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = dateFormat.parse(dataInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
	}
	
	public boolean isAvailable(ArrayList<Bus> buses,ArrayList<Booking> bookingList) {
		
		int capacity = 0;
		int booked = 0;
		
		for(Bus bus:buses) {
			if(bus.getbusNo() == busNo) {
				capacity = bus.getCapacity();
			}
		}
		
		for(Booking book:bookingList) {
			if(book.getbusNo() == busNo && book.getDate().equals(date)) {
				booked++;
			}
		}
		
		return booked<capacity?true:false;
	}
}
