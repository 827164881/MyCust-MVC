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


public class UpdateCustServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		CustService service=BasicFactory.getFactory().getInstence(CustService.class);
		//封装数据
		Cust cust=new Cust();
		try {
			BeanUtils.populate(cust, request.getParameterMap());
			StringBuffer sb=new StringBuffer();
			String[] prefs=request.getParameterValues("preference");
			for (String pref : prefs) {
				sb.append(pref+",");
			}
			String preference=sb.substring(0,sb.length()-1);
			cust.setPreference(preference);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		//调用service中的方法，修改数据
		service.updateCustInfo(cust);
		//回到显示列表
		request.getRequestDispatcher("/servlet/ListCustServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
