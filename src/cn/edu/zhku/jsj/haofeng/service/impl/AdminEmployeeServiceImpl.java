package cn.edu.zhku.jsj.haofeng.service.impl;

import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.Admins;
import cn.edu.zhku.jsj.haofeng.dao.AdminEmployeeDao;
import cn.edu.zhku.jsj.haofeng.dao.impl.AdminEmployeeDaoImpl;
import cn.edu.zhku.jsj.haofeng.service.AdminEmployeeService;


public class AdminEmployeeServiceImpl implements AdminEmployeeService {
	//������ݿ��
	private AdminEmployeeDao adminEmployeeDao=new AdminEmployeeDaoImpl();
	@Override
	public List<Admins> getAll(String name) {
		// TODO Auto-generated method stub
		return adminEmployeeDao.getAll(name);
	}
	@Override
	public int insert(String name, String pwd, int age, String gender,
			String address, String phone) {
		// TODO Auto-generated method stub
		return adminEmployeeDao.insert(name,pwd,age,gender,address,phone);
	}
	@Override
	public Admins getById(int id) {
		// TODO Auto-generated method stub
		return adminEmployeeDao.getById(id);
	}
	@Override
	public int update(String name, int age, String gender, String address,
			String phone, int id) {
		// TODO Auto-generated method stub
		return adminEmployeeDao.update(name,age,gender,address,phone,id);
	}
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return adminEmployeeDao.deleteById(id);
	}

}
