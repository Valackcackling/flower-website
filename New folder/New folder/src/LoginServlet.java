

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
        HttpSession session=request.getSession(false);

		System.out.print(session);
		if(session==null) {
			response.sendRedirect("index.html");
		}
		else {
			String name=(String)session.getAttribute("name");
				response.sendRedirect("in.html");	
			}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("email");
		String password =request.getParameter("password");
		
		if(DataBase.validate(name, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("name",name);
			System.out.print(session);

			response.sendRedirect("in.html");
			

		}
		else {
			request.getRequestDispatcher("index.html").include(request, response);
		}
		
		out.close();
	}

}
