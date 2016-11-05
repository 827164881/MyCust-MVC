package com.geng.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geng.domain.Cust;
import com.geng.factory.BasicFactory;
import com.geng.service.CustService;


public class CustInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustService service=BasicFactory.getFactory().getInstence(CustService.class);
		//获取id
		String id=request.getParameter("id");
		//调用Service中的方法，根据id查找cust
		Cust cust=service.findCustById(id);
		if(cust==null){
			throw new RuntimeException("该用户不存在"+id);
		}
		//将该cust放到requset域中进行，转发给updateCust。jsp修改
		request.setAttribute("cust", cust);
		request.getRequestDispatcher("/UpdateCust.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
