package com.geng.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geng.factory.BasicFactory;
import com.geng.service.CustService;


public class DelCustServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustService service = BasicFactory.getFactory().getInstence(CustService.class);
		//�õ�id������service�еķ�����ɾ���û�
		String id=request.getParameter("id");
		service.delCustById(id);
		
		//�ص�listcustҳ��
		request.getRequestDispatcher("/servlet/ListCustServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
