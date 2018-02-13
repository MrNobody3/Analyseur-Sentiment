package com.web.interceptors;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.bo.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7788882820853958338L;

	public String intercept(ActionInvocation invocation) throws Exception {

		Map<String, Object> session = invocation.getInvocationContext().getSession();
		User user=(User) session.get("user");
		if (user==null) {
			return ActionSupport.LOGIN;
			

		} else {
			return invocation.invoke();
			
		}

		
	}

}