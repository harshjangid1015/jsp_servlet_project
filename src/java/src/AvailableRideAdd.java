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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author harsh
 */
public class AvailableRideAdd extends HttpServlet {

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
            out.println("<title>Servlet AvailableRideAdd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AvailableRideAdd at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);

                String name = request.getParameter("name");
                String origin = request.getParameter("origin");
                String destination = request.getParameter("destination");
                String date = request.getParameter("date");
                String time = request.getParameter("time");
                String seats = request.getParameter("seats");
                String contact = request.getParameter("contact");
                
                System.out.println(name);
                System.out.println(origin);
                System.out.println(destination);
                System.out.println(date);
                System.out.println(time);
                System.out.println(seats);
                System.out.println(contact);
                
                if(name.isEmpty() || origin.isEmpty() || destination.isEmpty() || date.isEmpty() || time.isEmpty() || seats.isEmpty() || date.isEmpty() || contact.isEmpty()){
			RequestDispatcher req = request.getRequestDispatcher("WantToShareRide.jsp");
			req.include(request, response);
		}else{
                    
                    try {
                        Class.forName("com.mysql.jdbc.Driver");

                        // Establish a connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/share_ride", "root", "root");
                        
                        PreparedStatement preparedStatement = connection.prepareStatement("insert into share_ride.available_rides (name, origin, destination, date, time, seats, contact) " + "values (?, ?, ?, ?, ?, ?, ?)");
					preparedStatement.setString(1, name);
					preparedStatement.setString(2, origin);
                                        preparedStatement.setString(3, destination);
					preparedStatement.setString(4, date);
                                        preparedStatement.setString(5, time);
                                        preparedStatement.setString(6, seats);
                                        preparedStatement.setString(7, contact);
					preparedStatement.executeUpdate();
                                        
                                 connection.close();       
                                        
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(RiderRegistration.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
			RequestDispatcher req = request.getRequestDispatcher("AvailableRides.jsp");
			req.forward(request, response);
		}
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
