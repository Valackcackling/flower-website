

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class productDetail
 */
@WebServlet("/productDetail")
public class productDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		String flowerCompleteDetail = request.getParameter("id");
		
		String flowerid="";
		for(int i=0;i<flowerCompleteDetail.length();i++) {
			if(flowerCompleteDetail.charAt(i)==':') break;
			flowerid+= flowerCompleteDetail.charAt(i);
		}
		
		
		
		String name;
		boolean flag = false;
		HttpSession session=request.getSession(false); 
		
        if(session!=null){  
             name=(String)session.getAttribute("name");
             flag = DataBase.isInCart(name,flowerid);

      		System.out.print(flowerid+"->is "+(flag?"":"not")+" Presesnt:->for "+name+"\n");
        }
		
		String webPage = "<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"    <link rel=\"stylesheet\" href=\"\r\n" + 
				"    https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" +
				"<script src=\"js/jquery-migrate-3.3.2.js\"></script>"+
				"<script src=\"js/jquery-3.6.0.js\"></script>"+
				"    <style>\r\n" + 
				"        .mySlides {display: none;}\r\n" + 
				"        \r\n" + 
				"        .dropdown {\r\n" + 
				"            position: relative;\r\n" + 
				"            display: inline-block;\r\n" + 
				"        }\r\n" +
			    "        .logo{\r\n" + 
			    "   	width:44px;\r\n" + 
				"       height:44px;\r\n" + 
				"        }\r\n"+ 
				"        .dropdown-content {\r\n" + 
				"            display: none;\r\n" + 
				"            position: absolute;\r\n" + 
				"            background-color: #f9f9f9;\r\n" + 
				"            min-width: 120px;\r\n" + 
				"            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\r\n" + 
				"            padding: 12px 16px;\r\n" + 
				"            z-index: 1;\r\n" + 
				"        }\r\n" + 
				"        .dropdown:hover .dropdown-content{\r\n" + 
				"            display: block;\r\n" + 
				"        }\r\n" + 
				"    </style>\r\n" + 
				"    <meta charset=\"UTF-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
				"    <title>flower shop</title>\r\n" + 
				"</head>\r\n" + 
				"<body bgcolor=\"#F1F3F6\">\r\n" + 
				" <table border=\"0\" width=\"100%\" bgcolor=\"black\">\r\n" + 
				"  <tr>\r\n" + 
				"      <td align=\"center\"><img src=\"img\\logo.jpg\" class=\"logo\"></td>\r\n" + 
				"      <td><input type=\"text\" placeholder=\"Search for products\" style=\"width: 550px; height: 25px;\">\r\n" + 
				"        <input type=\"button\" value=\"Search\" style=\"width: 120px; height: 30px;\">\r\n" + 
				"    </td>\r\n" + 
				"      <th><font color=\"white\">More</font></th>\r\n" + 
				"      <th><img src=\"img\\cart.png\"></th>\r\n" + 
				"  </tr>   \r\n" + 
				" </table>\r\n" + 
				" <br> \r\n" + 
				" <section id=\"navbar\">\r\n" + 
				" <table border=\"0\" width=\"100%\" bgcolor=\"white\" heigth=\"10%\">\r\n" + 
				"     <tr>\r\n" + 
				"         <th width=\"12.5%\">\r\n" + 
				"             <div class=\"dropdown\">\r\n" + 
				"             <span>Carnation</span>\r\n" + 
				"             <div class=\"dropdown-content\">\r\n" + 
				"                 <p>Sweet William</p> \r\n" + 
				"                  <p>China pink</p>\r\n" + 
				"                    <p>Maiden pink</p>\r\n" + 
				"                      <p>Garden pink</p>\r\n" + 
				"             </div>\r\n" + 
				"            </div>\r\n" + 
				"        </th>\r\n" + 
				"         <th width=\"12.5%\">\r\n" + 
				"             <div class=\"dropdown\">\r\n" + 
				"             <spam>Rose</spam>\r\n" + 
				"             <div class=\"dropdown-content\">\r\n" + 
				"                 <p>Damask rose</p>\r\n" + 
				"                 <p>White rose of york</p>\r\n" + 
				"                 <p>Rosa peace</p>\r\n" + 
				"                 <p>Beach rose</p>\r\n" + 
				"                 </div>\r\n" + 
				"             </div>\r\n" + 
				"            </th>\r\n" + 
				"         <th width=\"12.5%\">\r\n" + 
				"             <div class=\"dropdown\">\r\n" + 
				"             <spam>Orchids</spam>\r\n" + 
				"             <div class=\"dropdown-content\">\r\n" + 
				"                 <p>Moth Orchids</p>\r\n" + 
				"                 <p>Boat Orchids</p>\r\n" + 
				"                 <p>Chinese ground Orchids</p>\r\n" + 
				"                 <p>Vanilla Orchids</p>\r\n" + 
				"             </div>\r\n" + 
				"             </div>\r\n" + 
				"            </th>\r\n" + 
				"         <th width=\"12.5%\">\r\n" + 
				"             <div class=\"dropdown\">\r\n" + 
				"             <spam>Tulip</spam>\r\n" + 
				"                <div class=\"dropdown-content\">\r\n" + 
				"                    <p>Garden tulip</p>\r\n" + 
				"                    <p>Parrot tulip</p>\r\n" + 
				"                    <p>Lady tulip</p>\r\n" + 
				"                    <p>Red cross tulip</p>\r\n" + 
				"                </div>\r\n" + 
				"                </div>\r\n" + 
				"            </th>\r\n" + 
				"         <th width=\"12.5%\">\r\n" + 
				"             <div class=\"dropdown\">\r\n" + 
				"            <spam>Peach flowers</spam>\r\n" + 
				"            <div class=\"dropdown-content\">\r\n" + 
				"                <p>Dwarf peach dahlia</p>\r\n" + 
				"                <p>Aprikola rose</p>\r\n" + 
				"                <p>Gabrielle marie</p>\r\n" + 
				"                <p>Artistry rose</p>\r\n" + 
				"            </div>\r\n" + 
				"            </div>\r\n" + 
				"        </th>\r\n" + 
				"         <th width=\"12.5%\">\r\n" + 
				"                <div class=\"dropdown\">\r\n" + 
				"                <spam>Daisy</spam>\r\n" + 
				"                <div class=\"dropdown-content\">\r\n" + 
				"                    <p>Common daisy</p>\r\n" + 
				"                    <p>Oxeye daisy</p>\r\n" + 
				"                    <p>Calendula</p>\r\n" + 
				"                    <p>Solidago</p>\r\n" + 
				"                </div>\r\n" + 
				"                </div>\r\n" + 
				"            </th>\r\n" + 
				"         <th width=\"12.5%\">\r\n" + 
				"                <div class=\"dropdown\">\r\n" + 
				"                <spam>Marguerite</spam>\r\n" + 
				"                <div class=\"dropdown-content\">\r\n" + 
				"                    <p>Angustifolia</p>\r\n" + 
				"                    <p>Coccinea</p>\r\n" + 
				"                    <p>Rogersiana</p>\r\n" + 
				"                    <p>Koidzumii</p>\r\n" + 
				"                </div>\r\n" + 
				"                </div>\r\n" + 
				"               </th>\r\n" + 
				"     </tr>\r\n" + 
				"     </table>\r\n" + 
				"     </section>\r\n" + 
				"    <br>\r\n" + 
				"  <section id=\"mainSection\">\r\n" + 
				"    <p id=\"flowerID\">"+flowerCompleteDetail+"</p>\r\n" + 
				"    <p id=\"flowerpresent\">"+flag+"</p>\r\n" + 
				"    </section>\r\n" + 
				"    <footer>\r\n" + 
				"        <table border=\"0\"  width=\"100%\" bgcolor=\"black\">\r\n" + 
				"        <tr>\r\n" + 
				"            <td bgcolor=\"black\" width=\"20%\"><font color=\"white\"><b>Quick links</b></font></td>\r\n" + 
				"            <td bgcolor=\"black\" width=\"20%\"><font color=\"white\"><b>Follow us</b></font></td>\r\n" + 
				"            <td bgcolor=\"black\" width=\"20%\"><font color=\"white\"><b>Contact</b></font></td>\r\n" + 
				"            <td bgcolor=\"black\" width=\"20%\"><font color=\"white\"><b>Search</b></font></td>\r\n" + 
				"        \r\n" + 
				"        <tr>\r\n" + 
				"            <td>\r\n" + 
				"            <ul>\r\n" + 
				"            <li><font color=\"white\">Tulip</font></li>\r\n" + 
				"            <li><font color=\"white\">Peach flowers</font></li>\r\n" + 
				"            <li><font color=\"white\">Roses</font></li>\r\n" + 
				"            <li><font color=\"white\">Orchids</font></li>\r\n" + 
				"            </ul>\r\n" + 
				"            <td>\r\n" + 
				"            <ul>\r\n" + 
				"            <li><font color=\"white\">Facebook</font></li>\r\n" + 
				"            <li><font color=\"white\">Twitter</font></li>\r\n" + 
				"            <li><font color=\"white\">Instagram</font></li>\r\n" + 
				"            <li><font color=\"white\">YouTube</font></li>\r\n" + 
				"            </ul>\r\n" + 
				"            <td>\r\n" + 
				"                <ul>\r\n" + 
				"                <li><font color=\"white\">Cyber worriors</font></li>\r\n" + 
				"                <li><font color=\"white\">+91 9898765489</font></li>\r\n" + 
				"                <li><font color=\"white\">India</font></li>\r\n" + 
				"                <li><font color=\"white\">540000</font></li>\r\n" + 
				"                </ul>\r\n" + 
				"                <td><input type=\"text\" placeholder=\"Search\">\r\n" + 
				"                    <input type=\"button\" value=\"Search\">\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"        \r\n" + 
				"    </table> \r\n" + 
				"<script src=\"productDetail.js\"></script>"+
				"</body>\r\n" + 
				"</html>";		
		
		PrintWriter out = response.getWriter();
		out.print(webPage);
	}

}


