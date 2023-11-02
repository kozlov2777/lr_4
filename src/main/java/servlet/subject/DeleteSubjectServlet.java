package servlet.subject;
//
//import dao.SubjectDAO;
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
//@WebServlet("/deleteSubject")
//public class DeleteSubjectServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private DB db;
//
//    public void init() throws ServletException {
//        db = new DB();
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        Long subjectId = Long.parseLong(request.getParameter("subjectId"));
//
//        try {
//            SubjectDAO subjectDAO = new SubjectDAO(db.getConnection());
//            subjectDAO.delete(subjectId);
//            response.sendRedirect(request.getContextPath() + "/readSubjects");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jpa.JpaManager;
import service.SubjectService;

import javax.persistence.EntityManager;
import java.io.IOException;

@WebServlet("/deleteSubject")
public class DeleteSubjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = JpaManager.getEntityManager();
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));

        SubjectService subjectService = new SubjectService(em);
        subjectService.deleteSubject(subjectId);

        response.sendRedirect(request.getContextPath() + "/readSubjects");
    }
}
