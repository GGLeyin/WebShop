package cn.edu.zhku.jsj.haofeng.service.impl;

import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.Shops;
import cn.edu.zhku.jsj.haofeng.dao.AdminShopsDao;
import cn.edu.zhku.jsj.haofeng.dao.impl.AdminShopsDaoImpl;
import cn.edu.zhku.jsj.haofeng.service.AdminShopsService;


public class AdminShopsServiceImpl implements AdminShopsService {

	private AdminShopsDao adminShopsDao=new AdminShopsDaoImpl();
	@Override
	public List<Shops> getAll(String name) {
		return adminShopsDao.getAll(name);
	}

	@Override
	public int insert(String shopName, String description, String buildTime,
			String username) {
		return adminShopsDao.insert(shopName, description, buildTime, username);
	}

	@Override
	public int update(String shopName, String description, String buildTime,
			String username) {
		return adminShopsDao.update(shopName, description, buildTime, username);
	}
	

	@Override
	public int deleteByShopName(String shopName) {
		return adminShopsDao.deleteByShopName(shopName);
	}
	
	public Shops getShopName(String shopName) {
		return adminShopsDao.getShopName(shopName);
	}
	
	public int RowCount() {
		// TODO Auto-generated method stub
		return adminShopsDao.RowCount();
	}

	@Override
	public List<Shops> getAll(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return adminShopsDao.getAll(pageSize,pageNo);
	}

}
