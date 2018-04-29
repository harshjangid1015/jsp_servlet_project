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
            System.out.println("processRequest");
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
        System.out.println("GET Request");
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
        System.out.println("info 11");
        String opt = request.getParameter("selected");
        String submit = request.getParameter("bookride");

        System.out.println("info 12" + submit);

        if (submit != null && !submit.isEmpty() && submit.equals("Book Ride")) {
            System.out.println("Book Ride Box");
            String ride_id = request.getParameter("ride_id");
            try {
                System.out.println("Book Ride try box");
                // updatwe ride id booked in table
                if (!ride_id.isEmpty()) {

                    System.out.println("Book Ride ride id" + ride_id);
                    Class.forName("com.mysql.jdbc.Driver");
                    ResultSet resultUpdateSet;
                    String queryUpdate = "UPDATE `available_rides` SET `status` = 'booked' WHERE `available_rides`.`id` = " + ride_id;
                    // Establish a connection
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/share_ride", "root", "root");
                    System.out.println("Book Ride connection ");

                    PreparedStatement preparedUpdateStatement = connection.prepareStatement(queryUpdate);
                    System.out.println("Book Ride connection query execute " + queryUpdate);
                    preparedUpdateStatement.executeUpdate();
                    System.out.println("Book Ride update execution");

                    ResultSet resultSet;
                    String query = "select * from share_ride.available_rides  ";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    resultSet = preparedStatement.executeQuery();
                    ArrayList<RideObject> ridesList = new ArrayList<>();
                    System.out.println("Book Ride select record");
                    while (resultSet.next()) {
                        RideObject r = new RideObject();

                        r.setId(resultSet.getString(1));
                        r.setName(resultSet.getString(2));
                        r.setOrigin(resultSet.getString(3));
                        r.setDestination(resultSet.getString(4));
                        r.setDate(resultSet.getString(5));
                        r.setTime(resultSet.getString(6));
                        r.setSeats(resultSet.getString(7));
                        r.setContact(resultSet.getString(8));
                        r.setStatus(resultSet.getString(9));

                        ridesList.add(r);
                    }
                    request.setAttribute("list", ridesList);
                    System.out.println("Book Ride RequestDispatcher");
                    RequestDispatcher req = request.getRequestDispatcher("AvailableRides.jsp");
                    req.forward(request, response);
                    connection.close();
                }

            } catch (ClassNotFoundException | SQLException ex) {
                log("something went wrong " + ex.getMessage());
            }

        } else if (opt.equals("Available")) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                ResultSet resultSet;
                String query = "select * from share_ride.available_rides  ";
                // Establish a connection
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/share_ride", "root", "root");

                PreparedStatement preparedStatement = connection.prepareStatement(query);

                resultSet = preparedStatement.executeQuery();

                ArrayList<RideObject> ridesList = new ArrayList<>();

                while (resultSet.next()) {
                    RideObject r = new RideObject();

                    r.setId(resultSet.getString(1));
                    r.setName(resultSet.getString(2));
                    r.setOrigin(resultSet.getString(3));
                    r.setDestination(resultSet.getString(4));
                    r.setDate(resultSet.getString(5));
                    r.setTime(resultSet.getString(6));
                    r.setSeats(resultSet.getString(7));
                    r.setContact(resultSet.getString(8));
                    r.setStatus(resultSet.getString(9));
                    ridesList.add(r);
                }
                request.setAttribute("list", ridesList);

                RequestDispatcher req = request.getRequestDispatcher("AvailableRides.jsp");
                req.forward(request, response);

                connection.close();

            } catch (ClassNotFoundException | SQLException ex) {
                 log("something went wrong " + ex.getMessage());
                Logger.getLogger(RiderRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (opt.equals("Requested")) {
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

                    r.setId(resultSet.getString(1));
                    r.setName(resultSet.getString(2));
                    r.setOrigin(resultSet.getString(3));
                    r.setDestination(resultSet.getString(4));
                    r.setDate(resultSet.getString(5));
                    r.setTime(resultSet.getString(6));
                    r.setSeats(resultSet.getString(7));
                    r.setContact(resultSet.getString(8));
                    r.setStatus(resultSet.getString(9));
                    ridesList.add(r);
                }
                request.setAttribute("list", ridesList);

                RequestDispatcher req = request.getRequestDispatcher("AvailableRides.jsp");
                req.forward(request, response);

                connection.close();

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(RiderRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (opt.isEmpty()) {
            RequestDispatcher req = request.getRequestDispatcher("AvailableRides.jsp");
            req.include(request, response);
        } else {

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
        System.out.println("getServletInfo");
        return "Short description";
    }// </editor-fold>

}
