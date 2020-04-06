package first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/map")
public class Map extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		PrintWriter out = res.getWriter();		//obj created to write on webpage
		
	
		//Validation v = new Validation();
		
		String adhar = Validation.getAdhar();
		String phone = Validation.getPhone();
		
		String a = req.getParameter("latitude");
		String b = req.getParameter("longitude");
		String c = req.getParameter("crime");
		
					DataBases db = new DataBases();
						try {
							db.insert(adhar, phone, c, a, b);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						out.println("<h1>Your complian has been registerd successfully</h1>"
								+ "<br><a href=\"Home_page.html\">Return to Home Page</a>");
		
		
	}
	
	
}
