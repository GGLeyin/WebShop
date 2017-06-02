package cn.edu.zhku.linye.shop.Service;

import java.util.List;

import cn.edu.zhku.linye.shop.Order;
import cn.edu.zhku.linye.shop.Dao.ShopDao;

public class OrderService {
	
	ShopDao sd = new ShopDao();
	
	public List<Order> getOrder(Order order) throws Exception {
		
		return sd.getOrder(order);
	}

	public boolean deleOrder(String orderID) throws Exception {
		return sd.deleOrder(orderID);
		
	}

	public boolean editOrder(String orderID) throws Exception {
		 return sd.editOrder(orderID);
		
	}

	
}
