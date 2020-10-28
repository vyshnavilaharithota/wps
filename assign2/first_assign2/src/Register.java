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

//@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = new DbConnection().connect();
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();       
		String email=request.getParameter("email");  
		String phone=request.getParameter("phone");
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql;
			System.out.print("hellp"+email);
			sql = "Insert into users values('"+email+"','"+phone+"')";
			stmt.execute(sql);
			RequestDispatcher rd = request.getRequestDispatcher("booking.html");
			rd.include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
