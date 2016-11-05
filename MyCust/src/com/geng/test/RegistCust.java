package com.geng.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.geng.utils.DataSourceUtils;

public class RegistCust {
	@Test
	public void regist(){
		String sql="insert into customer values(FIRST_ID.NEXTVAL,?,?,to_date('08-21-2003','MM-DD-YYYY'),?,?,?,?,?)";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getSource());
		for(int i=0;i<100;i++){
		try {
			runner.update(sql,  "name"+i,"ÄÐ","77777","4444","ÀºÇò","ÀàÐÍ1","ÃèÊö"+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		}
		}

}
