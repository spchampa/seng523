import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ATMDatabaseClass {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    private final String MYSQL_USERNAME  = "root";
    private final String MYSQL_PASSWORD = "abc123";
    
    private void connect() {
    	 try {
             // This will load the MySQL driver, each DB has its own driver
             Class.forName("com.mysql.jdbc.Driver");
             // Setup the connection with the DB
             connect = DriverManager
                     .getConnection("jdbc:mysql://localhost:3306/atmdb?useSSL=false"
                             ,MYSQL_USERNAME ,MYSQL_PASSWORD);
    	 }catch(Exception e) {
    		 
    	 }
    	 
    }
	private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
	private void test() {
		
	}
	public static void main(String[] args) {
		System.out.println("testing atmdb class");
		ATMDatabaseClass atmdb = new ATMDatabaseClass();
		atmdb.connect();
		System.out.println("connected");
		try {
			
			atmdb.preparedStatement = atmdb.connect.prepareStatement("SELECT user FROM system_database");
			atmdb.resultSet = atmdb.preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
