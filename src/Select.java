import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.134:3306/dan", "root", "Dkenneth1!");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM dan.HELLO");
			while(rs.next()) {
				System.out.print(String.format("%1$" + 6 + "s", rs.getInt("ID")));
				System.out.print(String.format("%1$" + 6 + "s", rs.getInt("age")));
				System.out.print(String.format("%1$" + 20 + "s", rs.getString("firstName")));
				System.out.println(String.format("%1$" + 20 + "s", rs.getString("lastName")));
			}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
			if (e instanceof SQLException) {
				int errorCode = ((SQLException) e).getErrorCode();
				System.err.println("SQL Error Code: " + errorCode);
			}
		}
	}
} 





