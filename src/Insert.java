import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.134:3306/dan", "root", "Dkenneth1!");
			Statement stmt = connection.createStatement();
			int i = stmt.executeUpdate("INSERT into dan.HELLO (ID, age, firstName, lastName) VALUES ('10', '30', 'jeff', 'asdf')");
			if(i < 0) {
				System.err.println("insert failed. 0 recoeds updated");
			}else {
				System.out.println("insert succeeded");
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
