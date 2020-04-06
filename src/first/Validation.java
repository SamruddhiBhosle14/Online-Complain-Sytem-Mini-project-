package first;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/valid")
public class Validation extends HttpServlet{
	
	public static String adhar;
	public static String phone;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		adhar = req.getParameter("adhar");
		
		PrintWriter out = null;
					try {
						out = res.getWriter();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					
		DataBases db = new DataBases();
		
					try {
						if(db.check(adhar)) {
							out.println("<a href=\"PinDrop.html\">Click here to register your complain.</a>");
							
						}else {
							out.println("Enter valid adhar card!");
						}
					} catch (Exception e) {
					
						e.printStackTrace();
					}
		
	}
	
	
	public static String getAdhar() {
		return adhar;
	}
	public static void setAdhar(String adhar) {
		Validation.adhar = adhar;
	}
	public static String getPhone() {
		return phone;
	}
	public static void setPhone(String phone) {
		Validation.phone = phone;
	}
	
	

}
