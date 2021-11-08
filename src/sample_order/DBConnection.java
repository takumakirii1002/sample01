package sample_order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	//DB接続、切断

	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/sample_o";
	private static final String user="root";
	private static final String pass ="root";

	private Connection con;

	public Connection getConnect(){
		try {
			if(con==null) {
				Class.forName(driver);
				con=DriverManager.getConnection(url,user,pass);
			}

			}catch(SQLException e) {
				System.out.println("SQLException:"+e.getMessage());
			}catch(ClassNotFoundException e) {
				System.out.println("ClassNotFoundException:"+e.getMessage());
			}
		return con;
	}
	public void closeConnect() throws SQLException{
		if(con!=null) {
				con.close();
				System.out.println("切断");
		}
	}
}
