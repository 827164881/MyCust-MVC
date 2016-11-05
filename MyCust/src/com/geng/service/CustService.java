package com.geng.service;

import java.util.List;

import com.geng.domain.Cust;

public interface CustService {

	/**
	 * 添加用户
	 * @param cust 封装好的cust类
	 */


	void addCust(Cust cust);

	/**
	 * 获取所有用户的列表
	 * @return
	 */
	List<Cust> getCustList();

	/**
	 * 根据id查找对应的用户，
	 * @param id
	 * @return 如果查找到，返回该cust，如果找不到。则返回null
	 */
	Cust findCustById(String id);

	/**
	 * 根据用户id，修改用户信息
	 * @param cust
	 */
	void updateCustInfo(Cust cust);

	/**
	 * 根据用户id删除用户
	 * @param id
	 */
	void delCustById(String id);

	/**
	 * 批量删除
	 * @param ids
	 */
	void batchDel(String[] ids);

	/**
	 * 根据cast中的一些信息，进行查找
	 * @param cust
	 * @return 返回查找到的用户列表
	 */
	List<Cust> searchCustByDetail(Cust cust);

}
