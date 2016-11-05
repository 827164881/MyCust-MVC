package com.geng.service;

import java.util.List;

import com.geng.domain.Cust;

public interface CustService {

	/**
	 * ����û�
	 * @param cust ��װ�õ�cust��
	 */


	void addCust(Cust cust);

	/**
	 * ��ȡ�����û����б�
	 * @return
	 */
	List<Cust> getCustList();

	/**
	 * ����id���Ҷ�Ӧ���û���
	 * @param id
	 * @return ������ҵ������ظ�cust������Ҳ������򷵻�null
	 */
	Cust findCustById(String id);

	/**
	 * �����û�id���޸��û���Ϣ
	 * @param cust
	 */
	void updateCustInfo(Cust cust);

	/**
	 * �����û�idɾ���û�
	 * @param id
	 */
	void delCustById(String id);

	/**
	 * ����ɾ��
	 * @param ids
	 */
	void batchDel(String[] ids);

	/**
	 * ����cast�е�һЩ��Ϣ�����в���
	 * @param cust
	 * @return ���ز��ҵ����û��б�
	 */
	List<Cust> searchCustByDetail(Cust cust);

}
