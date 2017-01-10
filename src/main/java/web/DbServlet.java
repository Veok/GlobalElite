package web;

import dao.RepositoryCatalog;
import dao.repositories.IRepository;
import dao.repositories.IRepositoryCatalog;
import domain.model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author L on 31.12.2016.
 */
@WebServlet("/DbServlet")
public class DbServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DbServlet() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{

            IRepositoryCatalog catalog = new RepositoryCatalog("jdbc:hsqldb:hsql://localhost/workdb");
            HttpSession session = req.getSession();
            Player player = (Player) session.getAttribute("player");
            catalog.players().add(player);
            catalog.saveAndClose();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
