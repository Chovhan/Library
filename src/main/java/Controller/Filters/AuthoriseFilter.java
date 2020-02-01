package Controller.Filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthoriseFilter implements Filter {

//    private static final Logger logger = Logger.getLogger(AuthoriseFilter.class);

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig config) {
//        logger.info("Authorise filter was initialized!");
        filterConfig = config;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        logger.info("Authorise filter was started!");
        if (filterConfig.getInitParameter("active").equalsIgnoreCase("true")){

            final HttpServletResponse resp = (HttpServletResponse) servletResponse;
            final HttpServletRequest req = (HttpServletRequest) servletRequest;

            final HttpSession session = req.getSession();

            if (session.getAttribute("Admin") != null | session.getAttribute("User") != null){
                filterChain.doFilter(req, resp);
            } else {
                System.out.println(true);
                resp.sendRedirect("/login");
            }
        }
    }

    @Override
    public void destroy() {
//        logger.info("Authorise filter was destroyed!");
        filterConfig = null;
    }
}
