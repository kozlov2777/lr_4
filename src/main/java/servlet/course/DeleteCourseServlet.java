//package servlet.course;
//
//import dao.CourseDAO;
//import db.DB;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//@WebServlet("/deleteCourse")
//public class DeleteCourseServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private DB db;
//
//    public void init() throws ServletException {
//        db = new DB();
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int courseId = Integer.parseInt(request.getParameter("courseId"));
//
//        try {
//            CourseDAO courseDAO = new CourseDAO(db.getConnection());
//            courseDAO.delete(courseId);
//            response.sendRedirect(request.getContextPath() + "/readCourses");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
package servlet.course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jpa.JpaManager;
import service.CourseService;
import javax.persistence.EntityManager;
import java.io.IOException;

@WebServlet("/deleteCourse")
public class DeleteCourseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = JpaManager.getEntityManager();
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        CourseService courseService =  new CourseService(em);
        courseService.deleteCourse(courseId);

        response.sendRedirect(request.getContextPath() + "/readCourses");
    }
}
