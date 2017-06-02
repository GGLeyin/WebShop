package cn.edu.zhku.jsj.haofeng.service;

import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.Orders;


public interface AdminOrdersService {

	List<Orders> getAll(String name);

	int updateById(int ifDispose, int id);

}
