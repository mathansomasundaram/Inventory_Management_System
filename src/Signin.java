

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("userid");
		String password=request.getParameter("password");
		String status=null;
		
		HttpSession session=request.getSession();
		String role=(String)session.getAttribute("role");
		
		
		User user=new User();
		
		user.setId(id);
		user.setPassword(PasswordHashing.encrypt(password));
		user.setRole(role);
		
		status=RegistrationDao.validateUser(user,request);
		
		response.getWriter().println(status);
	}

}