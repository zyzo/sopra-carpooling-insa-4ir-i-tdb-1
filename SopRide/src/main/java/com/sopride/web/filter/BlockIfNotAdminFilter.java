package com.sopride.web.filter;

import com.sopride.web.controller.UserCtrl;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/** This filter checks admin rights on accessing some priviliged pages
 * and redirect user to error message if user is not admin
 */
@WebFilter(filterName = "BlockIfNotAdmin",
        urlPatterns = {
                WebConstants.PATH_ADD_WORKPLACE,
                WebConstants.PATH_GET_REPORT,
                WebConstants.PATH_MANAGE_WORKPLACE,
                WebConstants.PATH_MANAGE_ACCOUNT,
                WebConstants.PATH_MODIFY_WORKPLACE,
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
