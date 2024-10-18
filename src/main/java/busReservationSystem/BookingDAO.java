package busReservationSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class BookingDAO {

	public int getBookedCount(int busNo,Date date) throws SQLException {
		
		String query = "select count(id) from booking where bus_No = ? and travel_date = ?";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, busNo);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		pst.setDate(2,sqlDate);
		ResultSet rs = pst.executeQuery();
		//Becaue the Query Return the single column of index Count
		int count = 0;
		if (rs.next()) {
		        count = rs.getInt(1);
		};
		return count;
	}
	
	public void addBooking(Booking booking) throws SQLException {
		String query = "INSERT INTO booking (bus_No, passenger_name, travel_date) VALUES (?, ?, ?)";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, booking.getbusNo());
		pst.setString(2, booking.getPassengerName());
		java.sql.Date sqlDate = new java.sql.Date(booking.getDate().getTime());
		pst.setDate(3,sqlDate);
		pst.executeUpdate();
		
	}
}
