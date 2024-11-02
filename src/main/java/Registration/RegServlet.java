package Registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con ;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method s
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","9652954669");
		} catch (ClassNotFoundException | SQLException e) {
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
			String s1=request.getParameter("uname");
			String s2=request.getParameter("fname");
			String s3=request.getParameter("lname");
			//String s4=request.getParameter("pword");
			PreparedStatement ps =con.prepareStatement("insert into collageKB values(?,?,?)");
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
		//	ps.setString(4, s4);
			ps.executeUpdate();
			PrintWriter pw=response.getWriter();
			pw.println("<html> <body bgcolor =blue >");
			pw.println("reg. success");
			pw.println("<html> <body bgcolor = blue ></body></html>");
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
