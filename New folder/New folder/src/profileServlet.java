

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class profileServlet
 */
@WebServlet("/profileServlet")
public class profileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		  
        HttpSession session=request.getSession(false);  
        if(session!=null){  
        String name=(String)session.getAttribute("name");  
          System.out.print(name);  
        }
        
        if(request.getParameter("id").equals("de42a4")) {
        	out.print(session);
        }
//		if(ck==null) {
//			response.sendRedirect("index.html");
//		}
//		else {
//			String name =ck[0].getValue();
//			if(name.equals("")||name==null) {
//				response.sendRedirect("index.html");
//			}
//			else {
//				
//			}
//		}
	}

}
