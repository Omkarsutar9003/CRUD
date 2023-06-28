package Servlet_page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deleteoperation
 */
@WebServlet("/Deleteoperation")
public class Deleteoperation extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		Connection conn=null;
		try {
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/usermang","root","cdac");
			PreparedStatement prepare=conn.prepareStatement("delete from User where id=?;");
			int id=Integer.parseInt(request.getParameter("id"));
		
			prepare.setInt(1, id);
			prepare.executeUpdate();
			 PrintWriter out=response.getWriter();
			 out.write("<h1 style=\"color :royalblue\">deleted Successfull !!!<h1>");
			  out.write("<a href=\"ReadOperation\">Read</a>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
