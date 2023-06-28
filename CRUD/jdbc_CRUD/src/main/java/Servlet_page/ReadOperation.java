package Servlet_page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadOperation
 */
@WebServlet("/ReadOperation")
public class ReadOperation extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/usermang","root","cdac");
			 
			  PreparedStatement prepare=conn.prepareStatement("select * from User;");
			  
			  ResultSet read=prepare.executeQuery();
			  PrintWriter out=response.getWriter();
			  out.write("<table>");
				out.write("<tr>");
				out.write("<th>ID</th>");
				out.write("<th>NAME</th>");
				out.write("<th>EMAIL</th>");
				out.write("<th>COUNTRY</th>");
				out.write("</tr>");
			out.write("<tr>");
				while(read.next())
				{
					int id=Integer.parseInt(read.getString("id"));
					String name=read.getString("name");
					String email=read.getString("email");
					String country=read.getString("countery");
					
					out.write("<td>"+id+"</td>");
					out.write("<td>"+name+"</td>");
					out.write("<td>"+email+"</td>");
					out.write("<td>"+country+"</td>");
					out.write("</tr>");
					
					
				}
			
				out.write("</table>");
				 out.write("<a href=\"Form.jsp\">ADD&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>");
				 out.write("<a href=\"delete.jsp\"> &nbsp;&nbsp;&nbsp;delete</a>");
				 out.write("<a href=\"UpdateOp.jsp\"> &nbsp;&nbsp;&nbsp;Update</a>");
				
			  
		     }
		    
		 catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
}
