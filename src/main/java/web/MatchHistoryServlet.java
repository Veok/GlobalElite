package web;

import domain.model.MatchHistory;
import hdao.MatchHistoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author L on 20.01.2017.
 */
@WebServlet("/MatchHistoryServlet")
public class MatchHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       MatchHistoryService matchHistoryService = new MatchHistoryService();
        ArrayList<MatchHistory> histories = (ArrayList<MatchHistory>) matchHistoryService.getListOfHistory();
        if(histories!=null){
            req.setAttribute(SessionKey.histories, histories);
        }
        else{
            resp.getWriter().write("Brak zadanych rekordow w bazie");
        }
    }
}
