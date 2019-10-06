import java.time.*;
import java.sql.*;
public class DateTimeFirstDemo 
{
	public static void main(String[] args)
	{
		LocalDate date1 = LocalDate.parse("2018-12-13");
		LocalTime time = LocalTime.parse("06:30");
		LocalDateTime dtDemo = date1.atTime(time);
		System.out.println(dtDemo);
		Connection connection = null;
		PreparedStatement st = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.2 Connect to Database
		try {
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databaseName=testDb;username=sa;password=sunlife_1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st = connection.prepareStatement("insert into TimeDateDemo values(?,?,?,?)");
			st.setObject(1,dtDemo);
			st.setObject(2,LocalDateTime.parse("2019-10-12T12:30"));
			st.setInt(3,102);
			st.setString(4,"Shourya1");
			int a = st.executeUpdate();
			System.out.println(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}