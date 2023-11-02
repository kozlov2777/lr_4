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
//@WebServlet("/updateSubject")
//public class UpdateSubjectServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private DB db;
//
//    public void init() throws ServletException {
//        db = new DB();
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int subjectId = Integer.parseInt(request.getParameter("subjectIdU"));
//        String subjectName = request.getParameter("subjectNameU");
//
//        Subject updatedSubject = new Subject();
//        updatedSubject.setId(subjectId);
//        updatedSubject.setName(subjectName);
//
//        try {
//            SubjectDAO subjectDAO = new SubjectDAO(db.getConnection());
//            subjectDAO.update(updatedSubject);
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

@WebServlet("/updateSubject")
public class UpdateSubjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = JpaManager.getEntityManager();
        int subjectId = Integer.parseInt(request.getParameter("subjectIdU"));
        String subjectName = request.getParameter("subjectNameU");

        SubjectService subjectService = new SubjectService(em);
        Subject existingSubject = subjectService.getSubjectById(subjectId);

        if (existingSubject != null) {
            existingSubject.setName(subjectName);
            subjectService.updateSubject(existingSubject);
        }

        response.sendRedirect(request.getContextPath() + "/readSubjects");
    }
}

