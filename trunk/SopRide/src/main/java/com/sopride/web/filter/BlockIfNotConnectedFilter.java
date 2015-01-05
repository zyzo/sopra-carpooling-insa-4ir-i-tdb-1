package com.sopride.web.filter;

import com.sopride.web.controller.UserCtrl;
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
                "/addrideshare",
                "/addworkplace",
                "/deleteuser",
                "/deleteworkplace",
                "/report",
                "/disconnect",
                "/manageaccount",
                "/manageworkplaces",
                "/modifyaccount",
                "/modifyworkplace",
                "/ridesharemanager",
                "/ridesharePossible",
                "/userProfile",
            })
public class BlockIfNotConnectedFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        UserCtrl userCtrl = WebUtils.getUserCtrl(req);
        if (userCtrl.isConnected()) {
            chain.doFilter(req, resp);
        } else {
            WebUtils.forward(req, resp, "notConnected.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
