package web.filter;

import domain.model.Team;
import web.SessionKey;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author L on 21.01.2017.
 */
@WebFilter(urlPatterns = {"/register.jsp", "/team.jsp"
        ,"/addMatch.html", "/addMatch.jsp","/matchHistory.jsp"})
public class TeamFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Team team = (Team) session.getAttribute(SessionKey.team);
        if (team == null) {
            ((HttpServletResponse) servletResponse).sendRedirect("/index.html");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
