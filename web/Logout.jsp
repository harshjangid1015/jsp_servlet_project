<%@ page import = "java.io.*,java.util.*" %>
<%
    HttpSession session2 = request.getSession();
    request.getSession().setAttribute("user_id","");
    response.sendRedirect("Login.jsp");
%>