package com.sopride.web.filter;

import com.sopride.web.controller.UserCtrl;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * Filter the request based on the connection state of the user.
 * Some pages are not accessible if the user is not connected.
 */
@WebFilter(filterName = "BlockIfNotConnected",
        urlPatterns = {
                WebConstants.PATH_ADD_RIDESHARE,
                WebConstants.PATH_ADD_WORKPLACE,
                WebConstants.PATH_DELETE_USER,
                WebConstants.PATH_DELETE_WORKPLACE,
                WebConstants.PATH_GET_REPORT,
                WebConstants.PATH_DISCONNECT,
                WebConstants.PATH_MANAGE_ACCOUNT,
                WebConstants.PATH_MANAGE_WORKPLACE,
                WebConstants.PATH_MODIFY_ACCOUNT,
                WebConstants.PATH_MODIFY_WORKPLACE,
                WebConstants.PATH_MODIFY_RIDESHARE, 
                WebConstants.PATH_RIDESHARE_MANAGER,
                WebConstants.PATH_RIDESHARE_POSSIBLE,
                WebConstants.PATH_USER_PROFILE,
                WebConstants.PATH_DELETE_WORKPLACE,
                WebConstants.PATH_DISCONNECT,
            })
public class BlockIfNotConnectedFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        UserCtrl userCtrl = WebUtils.getUserCtrl(req);
        if (userCtrl != null && userCtrl.isConnected()) {
            chain.doFilter(req, resp);
        } else {
            WebUtils.forward(req, resp, "notConnected.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
