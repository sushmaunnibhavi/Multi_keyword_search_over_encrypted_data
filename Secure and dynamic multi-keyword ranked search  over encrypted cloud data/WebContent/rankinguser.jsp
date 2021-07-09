
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="db.DBconnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css.css">
        <title>  Secure Data Sharing in Real Cloud </title>
    </head>
    <body class="body">
        <header class="mainheader">

            <h1> Multi keyword ranked search</h1>
            <nav>
                <ul>
                    <li><a href="userPage.jsp">Keyword Request</a></li>
                    <li><a class="active" href="rankinguser.jsp">Ranking</a></li>
                    <li><a href="multikeywordSearch.jsp">Multi Keyword Search</a></li>
                    <li><a href="template.jsp">Sign Out</a></li>
                    
                </ul>
            </nav>
        </header>


        <div class="maincontent">
            <div class="content">

                <article class="topcontent">
                    
                    <content>
                        
                        <div align="center" style="overflow-x: auto">
        <table>
            <caption><h2>File Ranking</h2></caption>
            <tr>
                
                <th>Secret Key</th>
                <th>Ranking</th>
                
            </tr>
            <%
                
                try
                {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enablingkeyword_search","fyp", "Mummy2512&");

                java.sql.Statement st=con.createStatement();
                String sql="select appkey, count(*)  from fileupload group by appkey";
                ResultSet rs=st.executeQuery(sql);
                while(rs.next())
                {
                    
            %>
                <tr>
                    <td><%=rs.getString("appkey")%></td>
                    <td><%=rs.getInt("count(*)")%></td>
                    
                </tr>
           <%
                }
}
catch(Exception ex)
{
out.print(ex);
}
                %>
        </table>
    </div>
                        
                    </content>
                </article>

            </div>
        </div        <footer class="mainfooter">
            <p>Multi keyword ranked search</p>
        </footer>
    </body>
</html>
