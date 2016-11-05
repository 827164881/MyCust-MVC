package com.geng.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.geng.domain.Cust;

public interface CustDao {

	


	/**
	 * 像数据库中添加用户
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
	 * 获取所有用户列表
	 * @return
	 */
	List<Cust> getAllCust();

	/**
	 * 根据用户id查找对应的cast用户
	 * @param id
	 * @return 如果找到返回该cust。如果找不到，返回null
	 */
	Cust findCustById(String id);

	/**
	 * 根据用户id修改该用户信息
	 * @param cust
	 */
	void updateCustInfo(Cust cust);

	/**
	 * 根据id删除用户
	 * @param id
	 */
	void delCustById(String id);

	/**
	 * 根据id删除
	 * @param conn
	 * @param id
	 * @throws SQLException 
	 */
	void delCustByIdWithTrans(Connection conn, String id) throws SQLException;

	/**
	 * 根据凤爪个的一些cust信息，查找对应的用户列表
	 * @param cust
	 * @return
	 */
	List<Cust> searchCustByDetail(Cust cust);

	

	



}
