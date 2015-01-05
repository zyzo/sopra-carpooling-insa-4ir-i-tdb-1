package com.sopride.web.filter;

import com.sopride.web.controller.UserCtrl;
import com.sopride.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(filterName = "BlockIfNotAdmin",
        urlPatterns = {
                "/addworkplace",
                "/report",
                "/manageworkplaces",
                "/manageaccount",
                "/modifyworkplace",
                "/ridesharemanager",
        })
public class BlockIfNotAdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        UserCtrl userCtrl = WebUtils.getUserCtrl(req);
        if (userCtrl.isAdmin()) {
            chain.doFilter(req, resp);
        } else {
            WebUtils.forward(req, resp, "notAdmin.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
