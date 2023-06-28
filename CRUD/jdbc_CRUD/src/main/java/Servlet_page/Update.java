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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/usermang","root","cdac");
			PreparedStatement prepare=conn.prepareStatement("update User set name=?,email=?,countery=? where id=?;");
			prepare.setString(1,request.getParameter("name"));
			prepare.setString(2,request.getParameter("email"));
			prepare.setString(3,request.getParameter("country"));
			prepare.setInt(4,Integer.parseInt(request.getParameter("id")) );
		   
			prepare.executeUpdate();
			 PrintWriter out=response.getWriter();
			 out.write("<h1 style=\"color :royalblue\">Update Successfull !!!<h1>");
			  out.write("<a href=\"ReadOperation\">Read</a>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
