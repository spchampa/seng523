import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

public class ATMDatabaseClass {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    private final String MYSQL_USERNAME  = "root";
    private final String MYSQL_PASSWORD = "abc123";
    private final String MYSQL_DATABASE = "system_database";
    
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
    public boolean checkPin(Vector<Integer> pinVector , int accountNum) {
    	try {
    		int pin = 0;
    		for(int i = 0; i <4; i++) {
    			pin += Math.pow(10, i)*pinVector.get(3-i); 
    		}
    		System.out.println("checking for pin : "+ pin);
    		System.out.println("SELECT user FROM "+MYSQL_DATABASE + " WHERE accountNum  = " + accountNum+ " AND pin = " +pin);
			preparedStatement  = connect.prepareStatement("SELECT user FROM "+MYSQL_DATABASE + "WHERE accountNum  = " + accountNum+ " AND pin = " +pin+";");
			resultSet = preparedStatement.executeQuery();
			if(resultSet.wasNull()) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return false;
    }
    public ATMDatabaseClass() {
    	connect();
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
			while(atmdb.resultSet.next()) {
				//this should return first name in database it does for me
				System.out.println(atmdb.resultSet.getString(1));
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
