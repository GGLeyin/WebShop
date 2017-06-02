package cn.edu.zhku.jsj.haofeng.service.impl;

import cn.edu.zhku.jsj.haofeng.bean.Admins;
import cn.edu.zhku.jsj.haofeng.bean.Boss;
import cn.edu.zhku.jsj.haofeng.dao.AdminLoginDao;
import cn.edu.zhku.jsj.haofeng.dao.impl.AdminLoginDaoImpl;
import cn.edu.zhku.jsj.haofeng.service.AdminLoginService;


public class AdminLoginServiceImpl implements AdminLoginService {
	
	private AdminLoginDao adminLoginDao=new AdminLoginDaoImpl();
	@Override
	public Boss getBoss(String username, String password) {
		// TODO Auto-generated method stub
		return adminLoginDao.getBoss(username,password);
	}

	@Override
	public Admins getAdmins(String username, String password) {
		// TODO Auto-generated method stub
		return adminLoginDao.getAdmins(username,password);
	}

	@Override
	public int update(String pwd, int id) {
		// TODO Auto-generated method stub
		return adminLoginDao.update(pwd,id);
	}

	//老板修改密码
	@Override
	public int updateB(String pwd, int id) {
		// TODO Auto-generated method stub
		return adminLoginDao.updateB(pwd,id);
	}



}
