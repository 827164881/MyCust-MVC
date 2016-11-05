package com.geng.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.geng.domain.Cust;
import com.geng.utils.DataSourceUtils;

public class CustDaoImpl extends Exception implements CustDao {


	@Override
	public void addCust(Cust cust) {
		// TODO Auto-generated method stub
		String sql="insert into customer values(FIRST_ID.NEXTVAL,?,?,?,?,?,?,?,?)";
		QueryRunner 	runner=new QueryRunner(DataSourceUtils.getSource());
		try {
			runner.update(sql, cust.getName(),cust.getGender(),cust.getBirthday(),cust.getCellphone(),cust.getEmail(),cust.getPreference(),cust.getType(),cust.getDescription());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Cust findCustByName(String name) {
		String sql = "select * from customer where name = ?";
		try{
			QueryRunner runner = new QueryRunner(DataSourceUtils.getSource());
			return runner.query(sql, new BeanHandler<Cust>(Cust.class),name);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<Cust> getAllCust() {
		String sql="select * from customer";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getSource());
		try {
			return runner.query(sql, new BeanListHandler<Cust>(Cust.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Cust findCustById(String id) {
		// TODO Auto-generated method stub
		String sql="select * from customer where id=?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getSource());
		try {
			return runner.query(sql, new BeanHandler<Cust>(Cust.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateCustInfo(Cust cust) {
		// TODO Auto-generated method stub
		String sql="update customer set gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getSource());
		try {
			runner.update(sql, cust.getGender(),cust.getBirthday(),cust.getCellphone(),cust.getEmail(),cust.getPreference(),cust.getType(),cust.getDescription(),cust.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delCustById(String id) {
		// TODO Auto-generated method stub
		String sql="delete from customer where id=?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getSource());
		try {
			runner.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delCustByIdWithTrans(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from customer where id=?";
		QueryRunner runner=new QueryRunner();
		
			runner.update(conn,sql, id);
		
		
	}

	@Override
	public List<Cust> searchCustByDetail(Cust cust) {
		// TODO Auto-generated method stub
		String sql="select * from customer where 1=1";
		List<String> params=new ArrayList<>();
		if(cust.getName()!=null && !"".equals(cust.getName())){
			sql=sql+" and name like ?";
			params.add("%"+cust.getName()+"%");
		}
		if(cust.getGender()!=null && !"".equals(cust.getGender())){
			sql=sql+" and gender=?";
			params.add(cust.getGender());
		}
		if(cust.getType()!=null && !"".equals(cust.getType())){
			sql=sql+" and type=?";
			params.add(cust.getType());
		}
		QueryRunner runner=new QueryRunner(DataSourceUtils.getSource());
		try{
		if(params.size()==0){
			return runner.query(sql, new BeanListHandler<Cust>(Cust.class));
		}else {
			return runner.query(sql, new BeanListHandler<Cust>(Cust.class), params.toArray());
		}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
