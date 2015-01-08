package com.sopride.web.filter;

import com.sopride.core.exception.AbstractException;
import com.sopride.web.controller.UserCtrl;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * This filter intercept all url requests and perform some common tasks.
 * For e.g :
 *  - add a UserCtrl instance to all incoming requests.
 *  - catch Exception and put message attribute in case of Exception catched.
 */
@WebFilter(filterName = "CommonFilter", urlPatterns = "/*")
public class CommonFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        request.getSession().setAttribute(WebConstants.SESSION_USER_CTRL, new UserCtrl(request.getSession()));
        try {
            chain.doFilter(req, resp);
        } catch (AbstractException e) {
            e.printStackTrace();
            request.setAttribute(WebConstants.ATT_MESSAGE_TYPE, e.getMessageType());
            request.setAttribute(WebConstants.ATT_MESSAGE_CONTENT, e.getMessageContent());
            WebUtils.forward(req, resp, e.getForwardingPath());
        } catch (Exception e) {
            e.printStackTrace();
            WebUtils.forward(req, resp, "unknownException.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
