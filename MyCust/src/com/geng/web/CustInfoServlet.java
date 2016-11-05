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
		//��ȡid
		String id=request.getParameter("id");
		//����Service�еķ���������id����cust
		Cust cust=service.findCustById(id);
		if(cust==null){
			throw new RuntimeException("���û�������"+id);
		}
		//����cust�ŵ�requset���н��У�ת����updateCust��jsp�޸�
		request.setAttribute("cust", cust);
		request.getRequestDispatcher("/UpdateCust.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
