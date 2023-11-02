package servlet.teacher;
//
//import dao.TeacherDAO;
//import db.DB;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import models.Teacher;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet("/readTeachers")
//public class ReadTeacherServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private DB db;
//
//    public void init() throws ServletException {
//        db = new DB();
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        List<Teacher> teachers;
//        try {
//            TeacherDAO teacherDAO = new TeacherDAO(db.getConnection());
//            teachers = teacherDAO.getAllTeachers();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            teachers = new ArrayList<>();
//        }
//
//        request.setAttribute("teachers", teachers);
//        request.getRequestDispatcher("teachers.jsp").forward(request, response);
//    }
//}
import java.io.IOException;
import java.util.List;
import jpa.JpaManager;
import models.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.TeacherService;
import javax.persistence.EntityManager;


@WebServlet("/readTeachers")
public class ReadTeacherServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = JpaManager.getEntityManager();
        try {
            TeacherService teacherService = new TeacherService(em);
            List<Teacher> teachers = teacherService.getAllTeachers();
            request.setAttribute("teachers", teachers);
            request.getRequestDispatcher("teachers.jsp").forward(request, response);
        } finally {
            em.close();
        }
    }
}
