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
//
//@WebServlet("/updateTeacher")
//public class UpdateTeacherServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private DB db;
//
//    public void init() throws ServletException {
//        db = new DB();
//    }
//
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int teacherId = Integer.parseInt(request.getParameter("teacherIdU"));
//        String fullName = request.getParameter("fullNameU");
//        int age = Integer.parseInt(request.getParameter("ageU"));
//        String workplace = request.getParameter("workplaceU");
//        int experience = Integer.parseInt(request.getParameter("experienceU"));
//        int subjectId = Integer.parseInt(request.getParameter("subjectIdU"));
//
//        Teacher updatedTeacher = new Teacher();
//        updatedTeacher.setId(teacherId);
//        updatedTeacher.setFullName(fullName);
//        updatedTeacher.setAge(age);
//        updatedTeacher.setWorkplace(workplace);
//        updatedTeacher.setExperience(experience);
//        updatedTeacher.setSubjectId(subjectId);
//
//        try {
//            TeacherDAO teacherDAO = new TeacherDAO(db.getConnection());
//            teacherDAO.update(updatedTeacher);
//            response.sendRedirect(request.getContextPath() + "/readTeachers");
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
import models.Subject;
import models.Teacher;
import service.SubjectService;
import service.TeacherService;
import javax.persistence.EntityManager;
import java.io.IOException;


@WebServlet("/updateTeacher")
public class UpdateTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = JpaManager.getEntityManager();
        int teacherId = Integer.parseInt(request.getParameter("teacherIdU"));
        TeacherService teacherService = new TeacherService(em);
        Teacher existingTeacher = teacherService.getTeacherById(teacherId);
        if (existingTeacher != null) {
            String fullName = request.getParameter("fullNameU");
            int age = Integer.parseInt(request.getParameter("ageU"));
            String workplace = request.getParameter("workplaceU");
            int experience = Integer.parseInt(request.getParameter("experienceU"));
            existingTeacher.setFullName(fullName);
            existingTeacher.setAge(age);
            existingTeacher.setWorkplace(workplace);
            existingTeacher.setExperience(experience);

            teacherService.updateTeacher(existingTeacher);
        }

        response.sendRedirect(request.getContextPath() + "/readTeachers");
    }
}
