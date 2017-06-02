package cn.edu.zhku.jsj.huangxin.orders.Dao;

import cn.edu.zhku.jsj.huangxin.bean.Orders;
import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.util.DBUtil;

public class OrdersDao {
	
	DBUtil du=new DBUtil();
	/**
	 * 通过用户名和订单状态获取订单信息，分页显示
	 * @param curPage	当前页数
	 * @param username	用户名
	 * @param state		订单状态
	 * @return	PageBean
	 */
	public PageBean getOrdersByUser(int curPage,String username,String state){
		String sql="select * from orders where username=? and state=? order by orderID desc";
		Object[] params={username,state};
		PageBean pb=du.getPageBean(sql,params,curPage);
		return pb;
	}
	/**
	 * 向数据库添加一条订单记录
	 * @param orders	订单信息
	 * @return	添加成功返回true，否则返回false
	 */
	public boolean addOrders(Orders orders){
		boolean rs=false;
		String sql="insert into orders values(null,?,?,?,?,?,?,?,?,'待发货',?)";
		Object[] params={orders.getUsername(),orders.getShopName(),orders.getGoodsName(),orders.getQuantity(),orders.getPrice(),orders.getConsignee(),orders.getPhone(),orders.getAddress(),orders.getTime()};
		int i=du.update(sql, params);
		if(i>0){
			rs=true;
		}
		return rs;
	}
	/**
	 * 删除订单
	 * @param ordersID	某一订单
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean deleteOrders(int ordersID){
		boolean rs=false;
		String sql="delete from orders where orderID=?";
		Object[] params={ordersID};
		int i=du.update(sql, params);
		if(i>0){
			rs=true;
		}
		return rs;
	}
	public boolean updateOrdersState(int ordersID,String state){
		boolean rs=false;
		String sql="update orders set state=? where orderID=?";
		Object[] params={state,ordersID};
		int i=du.update(sql, params);
		if(i>0){
			rs=true;
		}
		return rs;
	}
}
