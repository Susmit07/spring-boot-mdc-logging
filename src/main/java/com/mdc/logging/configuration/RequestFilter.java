package com.mdc.logging.configuration;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

@Component
public class RequestFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			String mdcData = String.format("[userId:%s | requestId:%s] ", user(), requestId());
			MDC.put("mdcData", mdcData); //Referenced from logging configuration.
			chain.doFilter(request, response); //Causes invocation of next filter in the chain
		} finally {
			MDC.clear();
		}
	}

	private String requestId() {
		return UUID.randomUUID().toString();
	}

	private String user() {
		return "Sunny";
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
