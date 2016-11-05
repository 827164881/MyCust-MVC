package com.geng.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.geng.dao.CustDao;
import com.geng.domain.Cust;
import com.geng.factory.BasicFactory;
import com.geng.utils.DataSourceUtils;

public class CustServiceImpl implements CustService{

	CustDao dao=BasicFactory.getFactory().getInstence(CustDao.class);
	
	@Override
	public void addCust(Cust cust) {
		// ����dao�еķ������ж��û����Ƿ����
		if(dao.findCustByName(cust.getName())!=null){
			throw new RuntimeException("���û��Ѿ����ڣ�");
		}
		//����dao�еķ���������û�
		dao.addCust(cust);
	}

	@Override
	public List<Cust> getCustList() {
		// TODO Auto-generated method stub
		return dao.getAllCust();
	}

	@Override
	public Cust findCustById(String id) {
		// TODO Auto-generated method stub
		return dao.findCustById(id);
	}

	@Override
	public void updateCustInfo(Cust cust) {
		// TODO Auto-generated method stub
		dao.updateCustInfo(cust);
		
	}

	@Override
	public void delCustById(String id) {
		// TODO Auto-generated method stub
		dao.delCustById(id);
		
	}

	@Override
	public void batchDel(String[] ids) {
		// TODO Auto-generated method stub
	  Connection conn=DataSourceUtils.getConnection();
	  try {
		conn.setAutoCommit(false);
		for (String id : ids) {
			dao.delCustByIdWithTrans(conn,id);
		}
		DbUtils.commitAndCloseQuietly(conn);
	} catch (SQLException e) {
		DbUtils.rollbackAndCloseQuietly(conn);
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	  
		
	}

	@Override
	public List<Cust> searchCustByDetail(Cust cust) {
		// TODO Auto-generated method stub
		return dao.searchCustByDetail(cust);
	}

}
