package com.sopride.web.filter;

import com.sopride.web.util.WebConstants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Add google map api key to the pages that actually need it.
 */
@WebFilter(filterName = "AddMapApiKeyFilter", urlPatterns =
        {
                WebConstants.PATH_MANAGE_WORKPLACE,
                WebConstants.PATH_RIDESHARE_MANAGER,
        })
public class AddMapApiKeyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setAttribute(WebConstants.ATT_GOOGLE_API_KEY, "AIzaSyAWtwnk0kNJlxITog0xf9y7EDYaywrnUDk");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
