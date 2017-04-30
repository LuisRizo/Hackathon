/*Author: Treasure Muchenagumbo
 * Contact: muchenagumbosteam@gmail.com
 * Date: 04/29/17
 * 
 * This is the script that deals with handling
 * the PSS (Yoyo Pay) Database.
 */

import java.sql.*;


public class Database {
	
	/// JDBC driver name and database URL
	   private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   private final String DB_URL = "jdbc:mysql://localhost:3306/Hackathon?autoReconnect=true&useSSL=false";

	   //  Database credentials
	   private final String USER = "PSSHackathon";
	   private final String PASS = "PSSDB4Yoyo";
	   
	   Connection conn = null;
	   Statement stmt = null;
	   
	   //DATABASE VARIABLES
	   private int id;
	   private String fname;
	   private String lname;
	   private String email;
	   private String username;
	   private String password;
	   private String transhist;	//TRANSACTION HISTORY
	   private int  paymentOption;	//0 IF TOUCHID, 1 IF QR CODE
	   private String ccNumber;		//CREDIT CARD NUMBER
	   private int cc3digit;		//CREDIT CARD 3 DIGIT NUMBER
	   private int ccExp;			//CREDIT CARD EXPIRATION DATE
	   
	   private String streetAddress;//CREDIT CARD BILLING INFORMATION
	   private String city;
	   private String state;
	   private String country;
	
	//DEFAULT CTOR
	public Database(){
		 RetrieveData();
		
	}
	
	//THIS METHOD IS FOR DEBUGGING PURPOSES
	//IT SENDS MESSAGES TO THE CONSOLE
	private void DebugLog(String x){
		System.out.println(x);
	}
	
	private void RetrieveData(){
		   try{
		      //JDBC DRIVER REGISTRATION
		      Class.forName(JDBC_DRIVER);

		      //CREATE CONNECTION
		      DebugLog("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      DebugLog("Connected database successfully...");
		      
		      //EXECUTE A QUERRY
		      DebugLog("Creating statement...");
		      stmt = conn.createStatement();

		      String sql = "SELECT * FROM Clients";
		      ResultSet rs = stmt.executeQuery(sql);
		      //GET THE DATA USING THE RESULT SET
		      while(rs.next()){
		         //GET DATA BY COLUMN NAME
		    	 id = rs.getInt("id");
		         fname = rs.getString("fname");
		         lname = rs.getString("lname");
		         username = rs.getString("username");
		         password = rs.getString("pw");
		         email = rs.getString("email");
		         transhist = rs.getString("transhist");
		         paymentOption = rs.getInt("paymentOption");
		         ccNumber = rs.getString("ccNumber");
		         cc3digit = rs.getInt("cc3digit");
		         ccExp = rs.getInt("ccExp");
		         streetAddress = rs.getString("stAddress");
		         city = rs.getString("city");
		         state = rs.getString("state");
		         country = rs.getString("country");
		        
		      }
		      rs.close();
		   }catch(SQLException se){
		      //HANDLES ERRORS FROM JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //HANDLES ERRORS FROM Class.forName()
		      e.printStackTrace();
		   }finally{
		      //CONNECTIONS CLOSED WITHIN THE FINALLY BLOCK
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }//DO NOTHING
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//END FINALLY TRY
		   }//END TRY
	}
	
}
