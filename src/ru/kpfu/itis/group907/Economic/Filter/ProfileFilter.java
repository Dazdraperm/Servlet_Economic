//package kpfu.itis.group907.Economic.Filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Map;
//
//@WebFilter(filterName = "profileFilter", urlPatterns = "profile/*")
//public class ProfileFilter implements Filter {
//
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest,
//                         ServletResponse servletResponse,
//                         FilterChain filterChain) throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        String uri = req.getRequestURI();
//        System.out.println(uri);
//        if(uri.contains("profile/Profile.ftl")){
//            req.getRequestDispatcher("Profile.ftl").forward(req, resp);
//        }
//        else filterChain.doFilter(servletRequest,servletResponse);
//    }
//
//
//}