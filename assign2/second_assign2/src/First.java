import java.io.IOException;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@WebServlet("/First")
public class First extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public PrintWriter out;

	public First() {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html"); 
			out = response.getWriter(); 
			String str=this.fetch(request);
			
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
			out.print("<div style='margin-top:300px' class='center container'><div class='card-panel black ' style='opacity: 0.5;' ><h5 class='white-text'>Welcome User!!</h5><h5 class='white-text'>"+str+"</h5></div></div>");
			out.print("</body>\r\n"
					+ "</html>");
			
			
			
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			Date d = new Date();
			Cookie cd=new Cookie("lastseen",df.format(d));
			response.addCookie(cd);
			out.close();   
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String fetch(HttpServletRequest request)
	{
		
		try{  
			Cookie ck[]=request.getCookies();  
			if(ck[0]==null)
			{
				return "You haven't visited the website";
			}
			else 
			{
				return "Last seen at "+ck[0].getValue();
			} 
		}
		catch(Exception e)
		{
//			System.out.println(e);
			return "You haven't visited the website";
			
		}  

	}
}
