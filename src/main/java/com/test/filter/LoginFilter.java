package com.test.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 95 on 2016/10/14.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String path = request.getRequestURI();

        if(path.contains("index")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

//        if(path.endsWith(".css")||path.endsWith(".js")||path.endsWith(".jpg")||
//                path.endsWith(".png")||path.endsWith(".gif")){
//            filterChain.doFilter(servletRequest,servletResponse);
//            return;
//        }

        if(session.getAttribute("existEmployee")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            response.sendRedirect("/myssh/index.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
