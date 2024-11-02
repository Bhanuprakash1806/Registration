package log;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/log")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet #init(ServletConfig)
	 */Connection cn;
	public void init(ServletConfig config) throws ServletException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","9652954669");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
	String s1= request.getParameter("uname");
	String s2=request.getParameter("fname");
	PrintWriter pw = response.getWriter();
	
		PreparedStatement ps =cn.prepareStatement("select * from collageKb where uname=? AND fname=?");
		
		ps.setString(1, s1);
		ps.setString(2, s2);
		
		ResultSet rs = ps.executeQuery();
		pw.println("<html> <body bgcolor =orange text =blue >");
		if(rs.next())
		{
			pw.println("Welcome");
		}
		else
		{
			pw.println("Invalid un/pw");
		}
		pw.println("<html> <body bgcolor =orange text =blue ></body></html>");

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
	
	}

}
