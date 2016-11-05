package com.geng.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geng.factory.BasicFactory;
import com.geng.service.CustService;


public class BatchDelServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustService service=BasicFactory.getFactory().getInstence(CustService.class);
		//获取所有要删除的id
		String[] ids=request.getParameterValues("delId");
		//调用service方法批量删除
		service.batchDel(ids);
		//请求转发
		request.getRequestDispatcher("/servlet/ListCustServlet").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

