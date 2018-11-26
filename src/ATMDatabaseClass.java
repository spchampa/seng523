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
    private final String MYSQL_PASSWORD = "testtest";
    private final String MYSQL_DATABASE = "seng523";
    
    private void connect() {
    	 try {
             // This will load the MySQL driver, each DB has its own driver
             Class.forName("com.mysql.jdbc.Driver");
             // Setup the connection with the DB
             connect = DriverManager
                     .getConnection("jdbc:mysql://localhost:3306/seng523?useSSL=false"
                             ,MYSQL_USERNAME ,MYSQL_PASSWORD);
    	 }catch(Exception e) {
    		 
    	 }
    	 
    }
    public int vectoint(Vector<Integer> vecnum) {
    	int x = 0;
		for(int i = 0; i <vecnum.size(); i++) {
			x += Math.pow(10, i)*vecnum.get(vecnum.size()-i -1); 
		}
		return x;
    }
    public int checkBalence(Vector<Integer> amountVector, int accountNum) {
    	int amount = vectoint(amountVector);
    	int tempbalance = 0;
    	System.out.println("checking for amount: "+amount);
    	try {
			preparedStatement = connect.prepareStatement("SELECT balance FROM system_database WHERE accountNum = "+ accountNum + " AND balance >= "+amount);
			resultSet = preparedStatement.executeQuery();
			if(!resultSet.next()) {
				
				return -1;
			}

			//this should return first name in database it does for me
			System.out.println(" current balence is: " +resultSet.getString(1));
			tempbalance = Integer.parseInt(resultSet.getString(1));
			tempbalance = tempbalance - amount;
			System.out.println(" new balance is: " +tempbalance);
			preparedStatement = connect.prepareStatement("UPDATE system_database SET balance ="+ tempbalance +" WHERE accountNum = "+ accountNum);
			preparedStatement.executeUpdate();
			return tempbalance;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return -1;
    }
    public boolean checkPin(Vector<Integer> pinVector , int accountNum) {
    	try {
    		int pin = vectoint(pinVector);
    		System.out.println("checking for pin : "+ pin);
    		//System.out.println("SELECT user FROM system_database WHERE accountNum  = " +accountNum+ " AND pin = " +pin);
			preparedStatement  = connect.prepareStatement("SELECT pin FROM system_database WHERE accountNum  = "+accountNum+" AND pin = "+pin+";");
			resultSet = preparedStatement.executeQuery();
			if(!resultSet.next()) {
				
				return false;
			}
			while(resultSet.next()) {
				//this should return first name in database it does for me
				System.out.println(resultSet.getString(1));
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
			int accountNum = 1234567;
			int pin = 1235;
			atmdb.preparedStatement = atmdb.connect.prepareStatement("SELECT user FROM system_database WHERE accountNum  = " + accountNum+ " AND pin = " +pin+";");
			atmdb.resultSet = atmdb.preparedStatement.executeQuery();
			if(!atmdb.resultSet.next()) {
				System.out.println("no result found");
			}
			while(atmdb.resultSet.next()) {
				//this should return first name in database it does for me
				System.out.println(atmdb.resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
