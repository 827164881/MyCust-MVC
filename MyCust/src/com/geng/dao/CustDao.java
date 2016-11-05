package com.geng.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.geng.domain.Cust;

public interface CustDao {

	


	/**
	 * �����ݿ�������û�
	 * @param cust
	 */
	void addCust(Cust cust);

	/**
	 * chazhoa
	 * @param name
	 * @return
	 */
	Cust findCustByName(String name);

	/**
	 * ��ȡ�����û��б�
	 * @return
	 */
	List<Cust> getAllCust();

	/**
	 * �����û�id���Ҷ�Ӧ��cast�û�
	 * @param id
	 * @return ����ҵ����ظ�cust������Ҳ���������null
	 */
	Cust findCustById(String id);

	/**
	 * �����û�id�޸ĸ��û���Ϣ
	 * @param cust
	 */
	void updateCustInfo(Cust cust);

	/**
	 * ����idɾ���û�
	 * @param id
	 */
	void delCustById(String id);

	/**
	 * ����idɾ��
	 * @param conn
	 * @param id
	 * @throws SQLException 
	 */
	void delCustByIdWithTrans(Connection conn, String id) throws SQLException;

	/**
	 * ���ݷ�צ����һЩcust��Ϣ�����Ҷ�Ӧ���û��б�
	 * @param cust
	 * @return
	 */
	List<Cust> searchCustByDetail(Cust cust);

	

	



}
