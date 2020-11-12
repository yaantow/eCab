import Servlet.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Insert here
 */
//@Webservlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			PrintWriter out = response.getWriter();
			Connection cn = DBConnect.getCn();
			String uname = request.getParameter("uname");
			String upass = request.getParameter("upass");
			String uphn = request.getParameter("uphn");
			String umail = request.getParameter("umail");
			String uid = request.getParameter("uid");
			
			String sql = "select UNAME from AOTCAB where UID=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, uid);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				out.println("<font color='red'>UserID already exists</font>");
				RequestDispatcher rd = request.getRequestDispatcher("regis.html");
				rd.include(request, response);
			}
			else{
				 sql = "insert into AOTCAB values(?,?,?,?,?)";
				 ps = cn.prepareStatement(sql);
				 ps.setString(1, uid);
				 ps.setString(2, upass);
				 ps.setString(3, uname);
				 ps.setString(4, umail);
				 ps.setString(5, uphn);
				 
				 ps.execute();
				 
				 out.println("<font color='green'>Successfully registered</font><br>"
				 		+ "<font color='red'>Please login</font>");
				 
				 RequestDispatcher rd = request.getRequestDispatcher("index.html");
					rd.include(request, response);
			}
		}catch(IOException | SQLException | ServletException e){
			System.out.println(e);
		}
	}
}