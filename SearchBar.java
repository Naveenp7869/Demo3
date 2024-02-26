import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.util.stream.*;
public class SearchBar extends HttpServlet
{

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	ArrayList<String> list = new ArrayList<>();
	PrintWriter	 out = response.getWriter();
	String s = request.getParameter("u1");
	out.println(s);
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///naveendb","root","root");
		Statement st  = con.createStatement();
		ResultSet rs = st.executeQuery("select * from login where uname like '"+s+"%'");
		while(rs.next())
		{
			list.add(rs.getString(1));
		}
		out.println(list);
		// List<String> result= list.stream().filter(n->n.startsWith(s)).collect(Collectors.toList());
		con.close();
		// out.println(result);
	}
	catch(Exception e)
	{ out.println(e);}
	
}
}