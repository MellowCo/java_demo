package filter;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("拦截请求！！！！！");
        chain.doFilter(request,response);
        System.out.println("拦截响应！！！！！");
    }

    @Override
    public void destroy() {

    }
}
