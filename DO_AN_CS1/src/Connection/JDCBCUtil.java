package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDCBCUtil {
	 public static Connection getConnection() {
	        Connection c = null;
	        try {
	            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	           // "jdbc:mysql://localhost:3306/dataquanlytaikhoan", "root", "841308072005"
	            String url= "jdbc:mysql://localhost:3306/quanlycafe";
	            String usreName="root";
	            String passWord="841308072005";

	            c = DriverManager.getConnection(url, usreName, passWord);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return c;
	    }
	    public static void closeConnection(Connection c) {
	        try {
	            if(c!=null) {
	                c.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


