package cn.edu.zhku.jsj.haofeng.service;

import java.util.List;


import cn.edu.zhku.jsj.haofeng.bean.Shops;

public interface AdminShopsService {
	List<Shops> getAll(String name);
	
	int insert(String shopName, String description, String buildTime, String username);
	
	int update(String shopName, String description, String buildTime, String username);
	
	int deleteByShopName(String shopName);
	
	Shops getShopName(String shopName) ;

	int RowCount();

	List<Shops> getAll(int pageSize, int pageNo);
}
