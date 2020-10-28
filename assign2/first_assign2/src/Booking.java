import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Booking
 */
//@WebServlet("/Booking")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Booking() {
        super();
 
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = new DbConnection().connect();
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();       
		String screen=request.getParameter("screen");  
		String city=request.getParameter("city");
		String tickets=request.getParameter("tickets");
		String movie=request.getParameter("movie");
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql;
			sql = "Select * from theatres where city='"+city+"' and screen='"+screen+"' and movie='"+movie+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				int ticket=rs.getInt(4);
				ticket=ticket+Integer.parseInt(tickets);
				sql="UPDATE theatres SET tickets = "+ticket+" where city='"+city+"'and screen='"+screen+"'";
				stmt.execute(sql);
				out.print("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\r\n"
						+ "<title>Insert title here</title>\r\n"
						+ "<style>\r\n"
						+ ".inp {\r\n"
						+ "	width: 96% !important;\r\n"
						+ "	padding-left: 10px !important;\r\n"
						+ "	border-radius: 7px !important;\r\n"
						+ "	border-bottom: 1px rgb(235, 235, 235) solid !important;\r\n"
						+ "	background-color: rgba(235, 235, 235, 0.2) !important;\r\n"
						+ "	color: white !important;\r\n"
						+ "}\r\n"
						+ "\r\n"
						+ ".inp:focus {\r\n"
						+ "	border: 1px rgb(235, 235, 235) solid !important;\r\n"
						+ "	box-shadow: 0px 1px 1px rgba(0, 0, 0, 0.075) inset, 0px 0px 8px gray\r\n"
						+ "		!important;\r\n"
						+ "}\r\n"
						+ "</style>\r\n"
						+ "</head>\r\n"
						+ "<body style=\"background-image: url('download.jpg'); background-size: cover;\">"	);
				
				out.print("<div style='margin-top:300px' class='center container'><div class='card-panel black'><h5 class='white-text'>Tickets booked successfully...</h5></div></div>");
				out.print("</body>\r\n"
						+ "</html>");
				
			}
			else
			{
				out.println("<div class='center'><h5 class='red-text'>Selected combination of city, screen and movie doesn't exist today</h5></div>");
				out.println("<div class='center'><h5 class='red-text'>Please book again..</h5></div>");
				RequestDispatcher rd= request.getRequestDispatcher("booking.html");
				rd.include(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
