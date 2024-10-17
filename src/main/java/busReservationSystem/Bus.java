package busReservationSystem;

public class Bus {

	private int busNo;
	private boolean ac;
	private int capacity;
	
	//Need to create get and set method because all of the above data are private
	
	Bus(int busNo,boolean ac,int capacity){
		this.busNo = busNo;
		this.ac = ac;
		this.capacity = capacity;
	}
	
	public boolean getAc() { //accessor method
		return ac;
	}
	
	public void setAc(int ac) { //mutated method
		ac = ac;
	}
	
	public int getbusNo() { //accessor method
		return busNo;
	}
	
	public void setbusNo(int value) { //mutated method
		busNo = value;
	}
	
	public int getCapacity() { //accessor method
		return capacity;
	}
	
	public void setCapacity(int cap) { //mutated method
		capacity = cap;
	}
	
	public void displayBusDetails() {
		System.out.println("Bus Name:" +busNo +" | Capacity:" +capacity +" | AC:" +ac);
	}
}
