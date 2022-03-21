

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class myCart
 */
@WebServlet("/myCart")
public class myCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
           
           HttpSession session=request.getSession(false);
           if(session!=null){  
             String name=(String)session.getAttribute("name");  
             String webpage = DataBase.getCartDetail(name); 
             
             System.out.print("\nsession in myCart"+session+"::"+name+"::\n::"+webpage);
             
        	 PrintWriter out = response.getWriter();
        	 out.append(webpage);
             request.getRequestDispatcher("myCart.html");
           }
		}

}
