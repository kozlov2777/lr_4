package servlet.subject;
//
//import dao.SubjectDAO;
//import db.DB;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import models.Subject;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//@WebServlet("/createSubject")
//public class CreateSubjectServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private DB db;
//
//    public void init() throws ServletException {
//        db = new DB();
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String subjectName = request.getParameter("subjectName");
//
//        Subject newSubject = new Subject();
//        newSubject.setName(subjectName);
//
//        try {
//            SubjectDAO subjectDAO = new SubjectDAO(db.getConnection());
//            subjectDAO.create(newSubject);
//            response.sendRedirect(request.getContextPath() + "/readSubjects");
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
import service.SubjectService;
import javax.persistence.EntityManager;
import java.io.IOException;

@WebServlet("/createSubject")
public class CreateSubjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = JpaManager.getEntityManager();
        String subjectName = request.getParameter("subjectName");
        Subject newSubject = new Subject();
        newSubject.setName(subjectName);

        SubjectService subjectService = new SubjectService(em);
        subjectService.createSubject(newSubject);

        response.sendRedirect(request.getContextPath() + "/readSubjects");
    }
}
