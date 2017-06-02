package cn.edu.zhku.jsj.huangxin.orders.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.huangxin.bean.Orders;
import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.orders.Dao.OrdersDao;

public class OrdersService {
	OrdersDao od=new OrdersDao();
	/**
	 * 通过用户名和订单状态获取订单信息，分页显示
	 * @param curPage	当前页数
	 * @param username	用户名
	 * @param state		订单状态
	 * @return	PageBean
	 */
	public PageBean getOrdersByUser(int curPage,String username,String state){
		return od.getOrdersByUser(curPage, username, state);
	}
	/**
	 * 向数据库添加一条订单记录
	 * @param orders	订单信息
	 * @throws Exception 订单添加失败异常
	 */
	public void addOrders(List<Map<String, Object>> pendingCart,String consignee,String phone,String address) throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time=df.format(new Date());
		for(Map<String, Object> map:pendingCart){
			Orders orders=new Orders((String)map.get("username"),(String) map.get("shopName"),(String)map.get("goodsName"),
					(String)map.get("quantity"), (String)map.get("subtotal"),consignee,phone,
					address,time);
			boolean rs=od.addOrders(orders);
			if(!rs){
				throw new Exception("添加订单失败！");
			}
		}
	}
	/**
	 * 删除订单
	 * @param ordersID	订单编号
	 * @return 删除成功返回true，否则返回false
	 * @throws Exception 删除订单失败异常
	 */
	public void deleteOrders(int ordersID) throws Exception{
		boolean rs=od.deleteOrders(ordersID);
		if(!rs){
			throw new Exception("删除订单失败！");
		}
	}
	/**
	 * 将某一订单的状态设置为已收货
	 * @param ordersID	订单编号
	 * @throws Exception	修改出错异常
	 */
	public void updateOrdersState(int ordersID) throws Exception{
		boolean rs=od.updateOrdersState(ordersID, "已收货");
		if(!rs){
			throw new Exception("修改订单状态失败！");
		}
	}
}
