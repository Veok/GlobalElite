package web;

import dao.TemporaryCurrencyEnumHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author L on 31.12.2016.
 */
public class InitServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemporaryCurrencyEnumHelper temporaryCurrencyEnumHelper = new TemporaryCurrencyEnumHelper();
      //  temporaryCurrencyEnumHelper.insertCurrencyEnums();
    }
}
