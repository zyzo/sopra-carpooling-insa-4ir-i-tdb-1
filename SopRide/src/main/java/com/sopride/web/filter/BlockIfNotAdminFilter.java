package com.sopride.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(filterName = "BlockIfNotAdmin",
        urlPatterns = {
                "/addworkplace",
                "/report",
                "/manageworkplaces",
                "/modifyworkplace",
                "/ridesharemanager",
        })
public class BlockIfNotAdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filtering block if not admin");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
