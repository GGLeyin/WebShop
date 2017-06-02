package cn.edu.zhku.jsj.haofeng.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.Orders;
import cn.edu.zhku.jsj.haofeng.dao.AdminOrdersDao;
import cn.edu.zhku.jsj.haofeng.util.DBUtil;


public class AdminOrdersDaoImpl extends DBUtil implements AdminOrdersDao {
	@Override
	public List<Orders> getAll(String name) {
		List<Orders> orderslist =new ArrayList<Orders>();
		String sql="select * from Orders where 1=1";
		if(name!=null&&name.length()>0){
			sql += " and userName like '%"+ name + "%'";
		}
		try {
			Orders order=null;
			rs=commonQuery(sql);
			while(rs.next()){
				order=new Orders();
				order.setOrderID(rs.getInt("orderID"));
				order.setUsername(rs.getString("username"));
				order.setShopName(rs.getString("shopName"));
				order.setGoodsName(rs.getString("goodsName"));
				order.setQuantity(rs.getString("quantity"));
				order.setPrice(rs.getString("price"));
				order.setConsignee(rs.getString("consignee"));
				order.setPhone(rs.getString("phone"));
				order.setAddress(rs.getString("address"));
				order.setState(rs.getString("state"));
				order.setTime(rs.getString("time"));
	
				orderslist.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderslist;
	}

	@Override
	public int updateById(int ifDispose, int id) {
		int result=0;
		String sql=null;
		if(ifDispose==0){
			sql="update Orders set ifDispose=1 where id=?";
		}
		if(ifDispose==1){
			sql="update Orders set ifDispose=0 where id=?";
		}
		 result=commonUpdate(sql,id);
		return result;
	}

	
}
