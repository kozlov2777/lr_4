package servlet.course;
//
//import dao.CourseDAO;
//import db.DB;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import models.Course;
//
//import java.io.IOException;
//import java.sql.Date;
//import java.sql.SQLException;
//
//@WebServlet("/updateCourse")
//public class UpdateCourseServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private DB db;
//
//    public void init() throws ServletException {
//        db = new DB();
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int courseId = Integer.parseInt(request.getParameter("courseIdU"));
//        String courseName = request.getParameter("courseNameU");
//        String courseLink = request.getParameter("courseLinkU");
//        double courseCost = Double.parseDouble(request.getParameter("courseCostU"));
//        Date startDate = Date.valueOf(request.getParameter("startDateU"));
//        int subjectId = Integer.parseInt(request.getParameter("subjectIdU"));
//
//        Course updatedCourse = new Course();
//        updatedCourse.setId(courseId);
//        updatedCourse.setName(courseName);
//        updatedCourse.setLink(courseLink);
//        updatedCourse.setCost(courseCost);
//        updatedCourse.setStartDate(startDate);
//        updatedCourse.setSubjectId(subjectId);
//
//        try {
//            CourseDAO courseDAO = new CourseDAO(db.getConnection());
//            courseDAO.update(updatedCourse);
//            response.sendRedirect(request.getContextPath() + "/readCourses");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jpa.JpaManager;
import models.Course;
import models.Subject;
import service.CourseService;
import service.SubjectService;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/updateCourse")
public class UpdateCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = JpaManager.getEntityManager();
        int courseId = Integer.parseInt(request.getParameter("courseIdU"));
        CourseService courseService = new CourseService(em);
        Course existingCourse = courseService.getCourseById(courseId);

        if (existingCourse != null) {
            String courseName = request.getParameter("courseNameU");
            String courseLink = request.getParameter("courseLinkU");
            double courseCost = Double.parseDouble(request.getParameter("courseCostU"));
            Date startDate = Date.valueOf(request.getParameter("startDateU"));
            int subjectId = Integer.parseInt(request.getParameter("subjectIdU"));
            SubjectService subjectService = new SubjectService(em);
            Subject subject = subjectService.getSubjectById(subjectId);

            existingCourse.setName(courseName);
            existingCourse.setLink(courseLink);
            existingCourse.setCost(courseCost);
            existingCourse.setStartDate(startDate);
            existingCourse.setSubject(subject);

            courseService.updateCourse(existingCourse);
        }

        response.sendRedirect(request.getContextPath() + "/readCourses");
    }
}

