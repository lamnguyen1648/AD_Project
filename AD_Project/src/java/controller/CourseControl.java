/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CourseModel;

/**
 *
 * @author lamsu
 */
public class CourseControl extends HttpServlet {

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
        String action = request.getParameter("ac");
        if("view".equals(action)) {
            CourseModel cm = new CourseModel();
            ArrayList<Course> list = cm.getCourses();
            request.setAttribute("listC", list);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        
        if("add".equals(action)) {
            CourseModel cm = new CourseModel();
            String id = request.getParameter("txtId");
            String name = request.getParameter("txtName");
            String desc = request.getParameter("txtDesc");
            String content = request.getParameter("txtContent");
            String schedule = request.getParameter("txtSchedule");
            String category = request.getParameter("txtCategory");
            String trainer = request.getParameter("txtTrainer");
            if(cm.addCourse(id, name, desc, content, schedule, category, trainer) == true) {
                ArrayList<Course> list = cm.getCourses();
                request.setAttribute("listC", list);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
        }
        
        if("del".equals(action)) {
            CourseModel cm = new CourseModel();
            String id = request.getParameter("id");
            if(cm.delCourse(id) == true) {
                ArrayList<Course> list = cm.getCourses();
                request.setAttribute("listC", list);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
        }
        
        if("edit".equals(action)) {
            CourseModel cm = new CourseModel();
            String id  = request.getParameter("id");
            Course c = cm.getCourseByID(id);
            request.setAttribute("data", c);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }
        
        if("doUpdate".equals(action)) {
            CourseModel cm = new CourseModel();
            String id = request.getParameter("txtId");
            String name = request.getParameter("txtName");
            String desc = request.getParameter("txtDesc");
            String content = request.getParameter("txtContent");
            String schedule = request.getParameter("txtSchedule");
            String category = request.getParameter("txtCategory");
            String trainer = request.getParameter("txtTrainer");
            boolean res = cm.updateCourse(id, name, desc, content, schedule, category, trainer);
            if(res == true) {
                ArrayList<Course> list = cm.getCourses();
                request.setAttribute("listC", list);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
        }
        
        if("loadUpdate".equals(action)) {
            CourseModel cm = new CourseModel();
            ArrayList<Course> list = cm.getCourses();
            request.setAttribute("listC", list);
            request.getRequestDispatcher("addNew.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
