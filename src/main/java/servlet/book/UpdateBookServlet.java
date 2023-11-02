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

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = JpaManager.getEntityManager();
        int bookId = Integer.parseInt(request.getParameter("bookIdU"));
        String updatedBookName = request.getParameter("bookNameU");
        Book updatedBook = new Book();
        updatedBook.setId(bookId);
        updatedBook.setName(updatedBookName);


        BookService bookService = new BookService(em);
        bookService.updateBook(updatedBook);

        response.sendRedirect(request.getContextPath() + "/readBooks");
    }
}


