package cn.edu.zhku.jsj.haofeng.service.impl;

import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.Orders;
import cn.edu.zhku.jsj.haofeng.dao.AdminOrdersDao;
import cn.edu.zhku.jsj.haofeng.dao.impl.AdminOrdersDaoImpl;
import cn.edu.zhku.jsj.haofeng.service.AdminOrdersService;


public class AdminOrdersServiceImpl implements AdminOrdersService {

	private AdminOrdersDao adminOrdersDao =new AdminOrdersDaoImpl();
	@Override
	public List<Orders> getAll(String name) {
		// TODO Auto-generated method stub
		return adminOrdersDao.getAll(name);
	}
	@Override
	public int updateById(int ifDispose, int id) {
		// TODO Auto-generated method stub
		return adminOrdersDao.updateById(ifDispose, id);
	}
	

}
