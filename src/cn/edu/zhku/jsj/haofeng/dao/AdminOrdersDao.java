package cn.edu.zhku.jsj.haofeng.dao;

import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.Orders;

public interface AdminOrdersDao {

	List<Orders> getAll(String name);

	int updateById(int ifDispose, int id);
	
	

}
