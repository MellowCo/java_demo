package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter", urlPatterns = "/*")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest newReq = (HttpServletRequest) req;
//        HttpServletResponse newResp = (HttpServletResponse) resp;
//        newReq.setCharacterEncoding("utf-8");
//        newResp.setCharacterEncoding("utf-8");
//        newResp.setContentType("text/html;charset=UTF-8");
//        chain.doFilter(newReq, newResp);

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
