
package enablingKeyWordSearch;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.DBconnection;

public class servlet_register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String username = request.getParameter("uname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String dob = request.getParameter("dob");
        String pincode = request.getParameter("pincode");
        String status="waiting";
        Connection con=null;
        try{
        con=(Connection)DBconnection.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into registration(username,password,email,mobile,dob,pincode) values(?,?,?,?,?,?)");
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, email);
        ps.setString(4, mobile);
        ps.setString(5, dob);
        ps.setString(6, pincode);
            System.out.println("Hiiiiiii");
        
        int i=ps.executeUpdate();
            
          if(i>0)
          {
                       
            response.sendRedirect("registration.jsp?msg=registration success!");
                       
          }
          else
          {
            response.sendRedirect("registration.jsp?msg=registration not success!");  
          }
        
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
