/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author harsh
 */
public class RiderLogin extends HttpServlet {

    ArrayList<String> _userInfo = new ArrayList<>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RiderLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RiderLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
         // store the User object in the session
        HttpSession session = request.getSession();
        String user_id = (String) session.getAttribute("user_id");

        System.out.println("user_id" + user_id);
        if (user_id != null && !user_id.isEmpty()) {
            // redirect me on home or dashboard page
             RequestDispatcher req = request.getRequestDispatcher("Welcome.jsp");
            req.forward(request, response);
        }
        else
        {
             RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
            req.forward(request, response);
        }
       
        
//        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // store the User object in the session
        HttpSession session = request.getSession();
        String user_id = (String) session.getAttribute("user_id");

        System.out.println("user_id" + user_id);
        if (user_id != null && !user_id.isEmpty()) {
            // redirect me on home or dashboard page
            response.sendRedirect("Welcome.jsp");
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            System.out.println("Validate 1");
            if (loginValidation(username, password)) {
                System.out.println("Validate done");

                // Check if this is new comer on your Webpage.
                //if (session.isNew()) {
                //session.setAttribute("user_info", _userInfo);
                System.out.println("Validate done" + _userInfo);
                session.setAttribute("user_id", _userInfo.get(0));
                //}

                RequestDispatcher req = request.getRequestDispatcher("Welcome.jsp");
                req.forward(request, response);

//                RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
//                req.include(request, response);
            } else {
                RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
                req.include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RiderLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean loginValidation(String username, String password) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String query = "select * from share_ride.user_detail where username = ? and password = ?";
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/share_ride", "root", "root");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            if (resultSet.next()) {
                ArrayList<String> userInfo = new ArrayList<>();
                System.out.println("Book Ride select record");
                if (resultSet.first()) {
                    System.out.println("while in");
                    _userInfo.add(resultSet.getString(1));
                      _userInfo.add(resultSet.getString(2));
                        _userInfo.add(resultSet.getString(3));
                          _userInfo.add(resultSet.getString(4));
                            _userInfo.add(resultSet.getString(5));
                              _userInfo.add(resultSet.getString(6));
                    System.out.println("111" + _userInfo);

                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
