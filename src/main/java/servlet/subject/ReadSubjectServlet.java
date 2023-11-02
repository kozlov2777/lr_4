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
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet("/readSubjects")
//public class ReadSubjectServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private DB db;
//
//    public void init() throws ServletException {
//        db = new DB();
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        List<Subject> subjects;
//        try {
//            SubjectDAO subjectDAO = new SubjectDAO(db.getConnection());
//            subjects = subjectDAO.getAllSubjects();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            subjects = new ArrayList<>();
//        }
//
//        request.setAttribute("subjects", subjects);
//        request.getRequestDispatcher("subjects.jsp").forward(request, response);
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
import java.util.List;

@WebServlet("/readSubjects")
public class ReadSubjectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = JpaManager.getEntityManager();
        SubjectService subjectService = new SubjectService(em);
        List<Subject> subjects = subjectService.getAllSubjects();

        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("/subjects.jsp").forward(request, response);
    }
}

