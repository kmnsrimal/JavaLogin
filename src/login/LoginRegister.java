package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/loginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginRegister() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO cd =new UserDAOImpl();
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		String submitType=request.getParameter("submit");
		User u =cd.getUser(userName, password);
		
		if(submitType.equals("login") && u!=null && u.getName()!=null) {
		
			request.setAttribute("message",u.getName());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
//		doGet(request, response);
	}else if(submitType.equals("register")) {
		u.setName(request.getParameter("name"));
		u.setPassword(password);
		u.setUsername(userName);
		cd.insertUser(u);
		System.out.println(password);
        request.setAttribute("successMessage","Registration done, please login to continue!!!");
        request.getRequestDispatcher("login.jsp").forward(request,response);
//        request.getRequestDispatcher("login.jsp");
	}else {
		request.setAttribute("message","data not found ,click on register!!!");
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}

	}
	
}
