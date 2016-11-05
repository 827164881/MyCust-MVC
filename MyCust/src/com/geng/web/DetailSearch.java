package com.geng.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.geng.domain.Cust;
import com.geng.factory.BasicFactory;
import com.geng.service.CustService;


public class DetailSearch extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		CustService service = BasicFactory.getFactory().getInstence(CustService.class);	
		
		//1.��ȡ��ѯ��������װ����
		try{
		Cust cust=new Cust();
		BeanUtils.populate(cust, request.getParameterMap());
		//2.����service�еķ�������������ѯ
		List<Cust> list=service.searchCustByDetail(cust);
		
		//3.��ѯ����������ѯ������浽requext���У��ض���listCustServlet
		request.setAttribute("list", list);
		request.getRequestDispatcher("/ListCust.jsp").forward(request, response);
		
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
