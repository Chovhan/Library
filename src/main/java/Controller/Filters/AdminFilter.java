package Controller.Filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig config) throws ServletException {
        filterConfig = config;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (filterConfig.getInitParameter("active").equalsIgnoreCase("true")) {
            final HttpServletResponse resp = (HttpServletResponse) servletResponse;
            final HttpServletRequest req = (HttpServletRequest) servletRequest;
            final HttpSession session = req.getSession();
            if (session.getAttribute("Admin") != null) {
                resp.sendRedirect("/Admin");
            } else {
                filterChain.doFilter(req, resp);
            }
        }
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
