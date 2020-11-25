package first;
import java.io.IOException;
import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.*;

import javax.servlet.ServletException;

public class Employee {
	private String name;
	private int empid;
	private String dob;
	private String photo;
	public void setEmpid(int empid) {
		Connection con=new DbConnection().connect();
		Statement stmt;
		try 
		{
			stmt=con.createStatement();
			String sql="Select name,photo,dob from employee where employee.id="+empid+";";
			ResultSet rs=stmt.executeQuery(sql);
			if(!rs.next())
				System.out.print("error");
			name=rs.getString(1);
			dob=rs.getString(3);
//			Blob b=rs.getBlob(2);
//			byte barr[]=b.getBytes(1,(int)b.length());
//			photo=empid+".jpg";
//			FileOutputStream fout=new FileOutputStream(photo);  
			Blob blob = rs.getBlob(2);
			 
			InputStream inputStream = blob.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			 
			while ((bytesRead = inputStream.read(buffer)) != -1) {
			    outputStream.write(buffer, 0, bytesRead);
			}
			 
			byte[] imageBytes = outputStream.toByteArray();
			 
			photo = Base64.getEncoder().encodeToString(imageBytes);
//			System.out.print(photo);
			inputStream.close();
			outputStream.close();
			System.out.print(rs.getString(1)+"hello");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.print(empid);
	}
	public String getName() {
		return name;
	}
	
	public String getDob() {
		return dob;
	}
	
	public String getPhoto()
	{
		return photo;
	}

}
