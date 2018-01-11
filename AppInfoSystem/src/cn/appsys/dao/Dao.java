package cn.appsys.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class Dao extends SqlSessionTemplate{
	@Autowired
	public Dao(SqlSessionFactory sqlSessionFactory) {
		
		super(sqlSessionFactory);
		
	}	
}
