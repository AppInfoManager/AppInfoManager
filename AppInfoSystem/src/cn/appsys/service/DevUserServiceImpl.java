package cn.appsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.DevUserDao;
import cn.appsys.pojo.DevUser;
@Service
public class DevUserServiceImpl implements DevUserService {
	@Autowired
	private DevUserDao devUserDao;

	public DevUserDao getDevUserDao() {
		return devUserDao;
	}



	public void setDevUserDao(DevUserDao devUserDao) {
		this.devUserDao = devUserDao;
	}



	@Override
	public DevUser appDologin(DevUser devUser) {
		
		return devUserDao.appDologin(devUser);
	}

}
