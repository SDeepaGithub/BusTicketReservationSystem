package busReservationSystem;
import java.sql.*;

public class BusDAO {
	//DAO-Data Access Object
	DbConnection dbConnection = new DbConnection();
	
	public void displayBusDetails() throws SQLException{
		
		Connection con = dbConnection.getConnection();
		String query = "select * from bus";
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(query);
		System.out.println("    --------BUS DETAILS--------   ");
		while(rs.next()) {
			// 1 meant for index here index 1 is busNo
			if(rs.getInt(2) == 1) {
				System.out.println("Bus No : " +rs.getInt(1) +" | Ac : Yes" +"| Capacity : " +rs.getInt(3));
			}else {
				System.out.println("Bus No : " +rs.getInt(1) +" | Ac : No" +" | Capacity : " +rs.getInt(3));
			}
			
		}
	}
	
	public int getCapacity(int busNo) throws SQLException{
		String query = "select capacity from bus where busNo =" +busNo;
		Connection con = dbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}

}
