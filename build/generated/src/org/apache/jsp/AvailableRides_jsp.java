package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import src.RideObject;
import java.util.ArrayList;

public final class AvailableRides_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Available Rides Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <a href=\"Welcome.jsp\">Home</a>\n");
      out.write("        <a href=\"Login.jsp\">Logout</a>\n");
      out.write("\t<br />\n");
      out.write("        <h1>Search all available or requested rides</h1>\n");
      out.write("         <br />\n");
      out.write("        <form action=\"SearchRides\" method=\"post\">\n");
      out.write("\t\t\t<table style=\"with: 50%\">\n");
      out.write("\t\t\t\t\n");
      out.write("                                <tr>\n");
      out.write("                                        <td>Select Option</td>\n");
      out.write("                                        <td><select name=\"selected\">\n");
      out.write("                                        <option></option>\n");
      out.write("                                        <option>Available</option>\n");
      out.write("                                        <option>Requested</option>\n");
      out.write("                                        </select>\n");
      out.write("                                        </td>\n");
      out.write("\t\t\t\t</tr>    \n");
      out.write("\t\t\t\t\n");
      out.write("                        </table>\n");
      out.write("\t\t\t<input type=\"submit\" value=\"Submit\" />\n");
      out.write("\t</form>\n");
      out.write("         \n");
      out.write("         <table border==\"1\">\n");
      out.write("            ");
  
                 // retrieve your list from the request, with casting 
                ArrayList<RideObject> list = (ArrayList<RideObject>) request.getAttribute("list");
//                try{
                    if(list!= null && !list.isEmpty())
                    {

                   // print the information about every category of the list
                              for(RideObject rideObject : list) {
                                  out.println(rideObject.getName());
                                  out.println(rideObject.getOrigin());
                                  out.println(rideObject.getDestination());
                                  out.println(rideObject.getDate());
                                  out.println(rideObject.getTime());
                                  out.println(rideObject.getSeats());
                                  out.println(rideObject.getContact());
                                  out.println("<br/>");
                              }
                    }
//                }
//                catch(Exception e)
//                {
//                    out.println(e.getMessage());
//                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
