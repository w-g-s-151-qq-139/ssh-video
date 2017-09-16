package com.zhiyou100.dao.utils;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class MyInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		if(ActionContext.getContext().getSession().get("admin")==null){
			return "login";
		}else{
			return invocation.invoke();
		}
	}


}
