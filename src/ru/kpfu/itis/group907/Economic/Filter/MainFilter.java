//package kpfu.itis.group907.Economic.Filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(filterName = "authenticationFilter", urlPatterns = "/*")
//public class MainFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
//        try {
//            req.getSession().getAttribute("login");
//            System.out.println(statusCode);
//            if (statusCode == 404) {
//                resp.sendRedirect("/Login.ftl");
//            }
//            else filterChain.doFilter(servletRequest,servletResponse);
//
//        }
//        catch (NullPointerException e){
//            filterChain.doFilter(servletRequest,servletResponse);
//
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
