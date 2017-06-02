package cn.edu.zhku.jsj.haofeng.service.impl;

import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.User_list;
import cn.edu.zhku.jsj.haofeng.dao.AdminUsersDao;
import cn.edu.zhku.jsj.haofeng.dao.impl.AdminUsersDaoImpl;
import cn.edu.zhku.jsj.haofeng.service.AdminUsersService;


public class AdminUsersServiceImpl implements AdminUsersService {

	//调用业务层
	private AdminUsersDao adminUsersDao=new AdminUsersDaoImpl();
	@Override
	public int RowCount() {
		// TODO Auto-generated method stub
		return adminUsersDao.RowCount();
	}

	@Override
	public List<User_list> getAll(String name,int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return adminUsersDao.getAll(name,pageSize,pageNo);
	}

	@Override
	public int delete(String username) {
		// TODO Auto-generated method stub
		return adminUsersDao.delete(username);
	}

}
