package com.geng.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.geng.domain.Cust;
import com.geng.factory.BasicFactory;
import com.geng.service.CustService;


public class addCustServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		CustService service = BasicFactory.getFactory().getInstence(CustService.class);
		//封装数据
		Cust cust=new Cust();
		try {
			BeanUtils.populate(cust, request.getParameterMap());
			String pref[]=request.getParameterValues("preference");
			StringBuffer sb=new StringBuffer();
			for (String pre : pref) {
				sb.append(pre+",");
			}
			String preference=sb.substring(0, sb.length()-1);
			cust.setPreference(preference);
			//调用service中的方法添加用户
			service.addCust(cust);
		
			//3.重定向回到主页
//			request.getSession().setAttribute("cust", cust);
			response.getWriter().write("添加成功，3秒后回到主页");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
		
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		
		//调用service中的方法，存储数据
		
		//存储成功，三秒后回到主页

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
