package com.sopride.web.filter;

import com.sopride.core.beans.UserBE;
import com.sopride.web.controller.UserCtrl;
import com.sopride.web.util.WebConstants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * This filter add UserCtrl to all incoming requests.
 */
@WebFilter(filterName = "AddUserCtrl", urlPatterns = "/*")
public class AddUserCtrlFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        request.getSession().setAttribute(WebConstants.SESSION_USER_CTRL, new UserCtrl(request.getSession()));
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
