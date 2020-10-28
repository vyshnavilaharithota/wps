

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Theatre
 */
//@WebServlet("/Theatre")
public class Theatre extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Theatre() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = new DbConnection().connect();
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		System.out.print("helloooooooooooooooooooooooooooo");
		String city=request.getParameter("city");  
		String movie=request.getParameter("movie");  
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql;
			sql = "Select t.screen from theatres t,dates d where t.id=d.id and t.city='"+city+"' and d.movie='"+movie+"' and d.date='"+date+"'";
			ResultSet rs=stmt.executeQuery(sql);
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
			
			out.print("<div style='margin-top:300px' class='center container'><div class='card-panel black'>");
			out.print("<h6 class='yellow-text'>Theatres List for the movie "+movie+" in "+city+" today </h6>");
			out.print("<ul class='white-text'>");
			while(rs.next())
			{
				out.print("<li class='white-text'><span class='yellow-text'>&gt;&nbsp;&nbsp;</span>"+rs.getString(1)
						+ "</li>");
			}
			out.print("</ul>");
					out.print("</div></div>");
			out.print("</body>\r\n"
					+ "</html>");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
