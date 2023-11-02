package servlet.book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jpa.JpaManager;
import service.BookService;
import javax.persistence.EntityManager;
import java.io.IOException;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = JpaManager.getEntityManager();
        int bookId = Integer.parseInt(request.getParameter("bookId"));

        BookService bookService = new BookService(em);
        bookService.deleteBook(bookId);

        response.sendRedirect(request.getContextPath() + "/readBooks");
    }
}

