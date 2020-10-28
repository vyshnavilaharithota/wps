

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
 * Servlet implementation class Login
 */
//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = new DbConnection().connect();
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();       
		String email=request.getParameter("email");  
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql;
			sql = "Select email from users where email='"+email+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				RequestDispatcher rd= request.getRequestDispatcher("booking.html");
				rd.include(request,response);
			}
			else
			{
				out.print("<div class='center'><h5 style='color: red'>Email is incorrect</h5></div>");
				RequestDispatcher rd= request.getRequestDispatcher("index.html");
				rd.include(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
