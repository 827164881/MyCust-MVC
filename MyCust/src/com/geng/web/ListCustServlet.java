package com.geng.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geng.domain.Cust;
import com.geng.factory.BasicFactory;
import com.geng.service.CustService;


public class ListCustServlet extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustService  service = BasicFactory.getFactory().getInstence(CustService.class);
		List<Cust> list=null;
		//调用service中的方法查询数据
		list=service.getCustList();
		//转发给jsp显示
		request.setAttribute("list", list);
		request.getRequestDispatcher("/ListCust.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
