package servlet.book;

import java.io.IOException;
import java.util.List;
import jpa.JpaManager;
import models.Book;
import service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;


@WebServlet("/readBooks")
public class ReadBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = JpaManager.getEntityManager();
        try {
            BookService bookService = new BookService(em);
            List<Book> books = bookService.getAllBooks();
            request.setAttribute("books", books);
            request.getRequestDispatcher("books.jsp").forward(request, response);
        } finally {
            em.close();
        }
    }
}
