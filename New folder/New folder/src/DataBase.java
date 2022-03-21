import java.sql.*;

public class DataBase {
  public static boolean validate(String email,String pass) {
	  
	  if(email.length()<4||pass.length()<4) {
		  return false;
	  }	  
	  
	  Connection c=null;
		PreparedStatement prp = null;
		try {
			  Class.forName("org.sqlite.JDBC");
			  
			  c = DriverManager.getConnection("jdbc:sqlite:E:\\Games\\dtclass.db");
			  String sql = "select * from tbl_login where email='"+email+"'and pass='"+pass+"'";
			  
			  prp = c.prepareStatement(sql);
			  ResultSet rs = prp.executeQuery();
            if(rs.next()) {
                prp.close();
                c.close();
  			  return true;            	  
            }

            prp.close();
            c.close();
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.print("error"+ e);
		}
		return false;
  }
  
  public static boolean addUser(String email,String pass) {
		if(email.length()<4||pass.length()<4) {
			return false;
		}
		Connection c =null;
		PreparedStatement prp=null;
		try {
			Class.forName("org.sqlite.JDBC");
			c=DriverManager.getConnection("jdbc:sqlite:E:\\Games\\dtclass.db");
			String sql="select * from tbl_login where email='"+email+"'";
			prp =c.prepareStatement(sql);
			ResultSet rs = prp.executeQuery();
			if(!rs.next()) {
				sql = "insert into tbl_login values(?,?);";
				prp = c.prepareStatement(sql);
				prp.setString(1, email);
				prp.setString(2, pass);
				int i = prp.executeUpdate();
				System.out.println(i);
				prp.close();
				c.close();
				return true;
				
			}
			prp.close();
			c.close();
		}
		catch(SQLException| ClassNotFoundException e) {
			System.out.print("error"+e);
			
		}
		return false;
		
	}
	public static void addFeedback(String name,String email,String phone,String message) {
		Connection c =null;
		PreparedStatement prp=null;
		try {
			Class.forName("org.sqlite.JDBC");
			c=DriverManager.getConnection("jdbc:sqlite:E:\\Games\\dtclass.db");
				String sql = "insert into tbl_feedback values(?,?,?,?);";
				prp = c.prepareStatement(sql);
				prp.setString(1, name);
				prp.setString(2, email);
				prp.setString(3, phone);
				prp.setString(4, message);
				int i = prp.executeUpdate();
				System.out.println(i);
				prp.close();
				c.close();
				
				}
		catch(SQLException| ClassNotFoundException e) {
			System.out.print("error"+e);
			
		}
		
	}
	public static void addToCart(String UserName,String productId, boolean add) {
		Connection c =null;
		PreparedStatement prp=null;
		
		if(add) {
			try {
				Class.forName("org.sqlite.JDBC");
				c=DriverManager.getConnection("jdbc:sqlite:E:\\Games\\dtclass.db");
					String sql = "insert into cart (username,flowerID)values(?,?);";
					prp = c.prepareStatement(sql);
					prp.setString(1, UserName);
					prp.setString(2, productId);
					prp.executeUpdate();
					
					prp.close();
					c.close();
					}
			catch(SQLException| ClassNotFoundException err) {
				System.out.print("error"+err);
				
			}
		}
		else {
			try {
				Class.forName("org.sqlite.JDBC");
				c=DriverManager.getConnection("jdbc:sqlite:E:\\Games\\dtclass.db");
					String sql = "delete from cart where username='"+UserName+"' and flowerID = '"+productId+"';";
					prp = c.prepareStatement(sql);
					int i = prp.executeUpdate();
					System.out.println(i);
					prp.close();
					c.close();
					}
			catch(SQLException| ClassNotFoundException e) {
				System.out.print("error"+e);
				
			}
		}
	}
	
	public static boolean isInCart(String UserName,String productId) {
		Connection c =null;
		PreparedStatement prp=null;
			try {
				Class.forName("org.sqlite.JDBC");
				c=DriverManager.getConnection("jdbc:sqlite:E:\\Games\\dtclass.db");
					String sql = "select * from cart where username=\""+UserName+"\" and flowerID = \""+productId+"\"; ";
					prp = c.prepareStatement(sql);
					
					ResultSet rs = prp.executeQuery();
		            if(rs.next()) {
		                prp.close();
		                c.close();
		  			    return true;            	  
		            }
					prp.close();
					c.close();
					return false;
					}
			catch(SQLException| ClassNotFoundException e) {
				System.out.print("error"+e);
				return false;
				
			}
	}
	
	public static String getCartDetail(String name) {
		Connection c =null;
		PreparedStatement prp=null;
			try {
				String returnvalue="";
				Class.forName("org.sqlite.JDBC");
				c=DriverManager.getConnection("jdbc:sqlite:E:\\Games\\dtclass.db");
					String sql = "select * from cart where username='abcde'; ";
					prp = c.prepareStatement(sql);
					
					ResultSet rs = prp.executeQuery();
					
					while(rs.next()) {
						returnvalue+=rs.getString(2)+":";
					}
									
					prp.close();
					c.close();
					
					return returnvalue;
					}
			catch(SQLException| ClassNotFoundException e) {
				System.out.print("error"+e);
				return "null";
			}
	}

}
