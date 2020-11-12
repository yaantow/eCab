import Servlet.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */

public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			PrintWriter out = response.getWriter();
			Connection cn = DBConnect.getCn();
			String uid = request.getParameter("uid");
			String upass = request.getParameter("upass");
			String sql = "select UNAME from AOTCAB where uid=? and upass=?";
			
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, upass);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				RequestDispatcher rd = request.getRequestDispatcher("home.html");
				out.println("<font color='green'>Welcome "+rs.getString("UNAME")+"</font>");
				HttpSession sess = request.getSession();
				sess.setAttribute("uid", uid);
				rd.include(request, response);
			}
			else{
				out.print("<font color='red'>Wrong UserID or Password</font>");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
