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
import java.sql.SQLException;
import java.util.ArrayList;
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
public class SearchRides extends HttpServlet {

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
            out.println("<title>Servlet SearchRides</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchRides at " + request.getContextPath() + "</h1>");
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

                String opt = request.getParameter("selected");
                
                
                if(opt.isEmpty()){
			RequestDispatcher req = request.getRequestDispatcher("AvailableRides.jsp");
			req.include(request, response);
		}
                else if(opt.equals("Available")){
			try {
                        Class.forName("com.mysql.jdbc.Driver");
                        ResultSet resultSet;
                          String query = "select * from share_ride.available_rides";
                        // Establish a connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/share_ride", "root", "root");
                        
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
					
			resultSet = preparedStatement.executeQuery();
                                        
                        ArrayList<RideObject> ridesList = new ArrayList<>();
                        
                        while (resultSet.next()) {
                            RideObject r = new RideObject();
                            r.setName(resultSet.getString(1));
                            r.setOrigin(resultSet.getString(2));
                            r.setDestination(resultSet.getString(3));
                            r.setDate(resultSet.getString(4));
                            r.setTime(resultSet.getString(5));
                            r.setSeats(resultSet.getString(6));
                            r.setContact(resultSet.getString(7));
                            
                            ridesList.add(r);
			}
                        request.setAttribute("list", ridesList);
                        
                        RequestDispatcher req = request.getRequestDispatcher("AvailableRides.jsp");
                        req.forward(request, response);
                                        
                        connection.close();       
                                        
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(RiderRegistration.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
                else if(opt.equals("Requested")){
			try {
                        Class.forName("com.mysql.jdbc.Driver");
                        ResultSet resultSet;
                          String query = "select * from share_ride.requested_rides";
                        // Establish a connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/share_ride", "root", "root");
                        
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
					
			resultSet = preparedStatement.executeQuery();
                        
                        ArrayList<RideObject> ridesList = new ArrayList<>();
                        
                        while (resultSet.next()) {
                            RideObject r = new RideObject();
                            r.setName(resultSet.getString(1));
                            r.setOrigin(resultSet.getString(2));
                            r.setDestination(resultSet.getString(3));
                            r.setDate(resultSet.getString(4));
                            r.setTime(resultSet.getString(5));
                            r.setSeats(resultSet.getString(6));
                            r.setContact(resultSet.getString(7));
                            
                            ridesList.add(r);
			}
                        request.setAttribute("list", ridesList);
                        
                        RequestDispatcher req = request.getRequestDispatcher("AvailableRides.jsp");
                        req.forward(request, response);
                                        
                        connection.close();
                        
                                        
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(RiderRegistration.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
                else{
                    
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
