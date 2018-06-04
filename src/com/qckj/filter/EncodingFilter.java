package com.qckj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName="encodingFilter",urlPatterns="/add/*", 
initParams={  
        @WebInitParam(name="coding", value="utf-8") 
    } )
public class EncodingFilter implements Filter{
	FilterConfig config = null;
	String coding = "";
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("===================doFilter");
		HttpServletRequest req = (HttpServletRequest)request;
		System.out.println("-----------------" + req.getContextPath());
		req.setCharacterEncoding("utf-8");
		chain.doFilter(req, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("≥ı ºªØ");
		this.config = config;
		coding = this.config.getInitParameter("coding");
	}

}
