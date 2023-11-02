package servlet.book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jpa.JpaManager;
import models.Book;
import models.Subject;
import service.BookService;
import service.SubjectService;
import javax.persistence.EntityManager;
import java.io.IOException;


@WebServlet("/createBook")
public class CreateBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = JpaManager.getEntityManager();
        String bookName = request.getParameter("bookName");
        Book newBook = new Book();
        newBook.setName(bookName);

        BookService bookService = new BookService(em);
        bookService.createBook(newBook);

        response.sendRedirect(request.getContextPath() + "/readBooks");
    }
}

