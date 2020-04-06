package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBases {
	
	
	String url = "jdbc:mysql://localhost:3306/SIH";
	String uname = "root";
	String pass = "root";
	
	public void insert(String adhar,String phone,String c,String a, String b) throws ClassNotFoundException, Exception {
			
			
			String querry = "insert into MapLocation(adhar,phone,crime,latitude,longitude) values('"+adhar+"','"+phone+"','"+c+"','"+a+"','"+b+"'); ";
			
			
			
						try {
								Class.forName("com.mysql.jdbc.Driver");	//Step 2
								
								
								Connection con = DriverManager.getConnection(url , uname , pass);	//Step 3
								
								Statement st = con.createStatement();		//Step 4
								
								int count = st.executeUpdate(querry);		//Step 5
								
								System.out.println(count+" rows affected.");
								
								st.close();		//Step 6
								con.close();	//Step 7 
								
						}catch(Exception e){
							
								e.printStackTrace();
						}
						
			
				}

	public boolean check(String a) throws Exception {
		
		String querry = "select * from Adhar_Validation; ";
		int out = 0;
		
		//Validation v = new Validation();
		
		
		Class.forName("com.mysql.jdbc.Driver");	//Step 2
		
		Connection con = DriverManager.getConnection(url , uname , pass);	//Step 3
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(querry);
		
		while(rs.next()) {
			out++;
			String b = rs.getString(1).toString();
			
					if(b.equals(a)) {
						System.out.println("Validation Successful!");
						
						Validation.setAdhar(rs.getString(1));
						Validation.setPhone(rs.getString(2));
						//int count = st.executeUpdate("insert into MapLocation(adhar,phone) values('"+rs.getString(1)+"','"+rs.getString(2)+"')");
						
						st.close();
						con.close();
						return true;
					}
			
			
		}
		
		st.close();
		con.close();
		return false;
	}

}
