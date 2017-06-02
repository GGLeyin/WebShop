package cn.edu.zhku.jsj.huangxin.test;

import org.junit.Test;

import cn.edu.zhku.jsj.huangxin.bean.Orders;
import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.orders.Service.OrdersService;


public class OrdersTest {
	OrdersService os=new OrdersService();
	@Test
	public void getOrdersByUserTest(){
		PageBean pb=os.getOrdersByUser(1, "huang","´ý·¢»õ");
		System.out.println(pb.getData());
		System.out.println(pb.getTotalPages());
	}
}
