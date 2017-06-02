package cn.edu.zhku.linye.shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.linye.Util.ConnectionManager;
import cn.edu.zhku.linye.shop.Goods;
import cn.edu.zhku.linye.shop.Order;
import cn.edu.zhku.linye.shop.Shop;


public class ShopDao {
	public boolean addShop(Shop shop) throws Exception{

		Connection con = null;
		PreparedStatement ps = null;

		// 连接数据库
		con = ConnectionManager.getConnection();

		if (con == null) {
			throw new Exception("数据库连接不成功！");
		}

		String sql = "insert into shops(shopName, description, buildTime,username) values (?,?,?,?)";
		
		ps = con.prepareStatement(sql);
		
		ps.setString(1, shop.getShopName());
		ps.setString(2, shop.getDescription());
		ps.setString(3, shop.getBuildTime());
		ps.setString(4, shop.getUsername());
		
		int row = ps.executeUpdate();
		if(row>0)
			return true;
		else
			return false;
		
	}

	public Shop getShop(String username) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		
		Shop shop = new Shop();

		con = ConnectionManager.getConnection();
		if (con == null) {
			throw new Exception("数据库连接不成功！");
		}

		String sql = "select * from shops where username = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, username);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			shop.setShopName(rs.getString("shopName"));
			shop.setDescription(rs.getString("description"));
			shop.setBuildTime(rs.getString("buildTime"));
			shop.setUsername(username);
		}
		return shop;
	}
	
	public Shop editShop(String shopName, String description, String username) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		

		con = ConnectionManager.getConnection();
		if (con == null) {
			throw new Exception("数据库连接不成功！");
		}
	
		String sql = "update shops set shopName=?,description=? where username = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, shopName);
		ps.setString(2, description);
		ps.setString(3, username);
		int rs = ps.executeUpdate();
		if(rs>0){
			return this.getShop(username);
		}
		return null;
		
	}

	public boolean addGoods(Goods goods) throws Exception{

		Connection con = null;
		PreparedStatement ps = null;

		// 连接数据库
		con = ConnectionManager.getConnection();

		if (con == null) {
			throw new Exception("数据库连接不成功！");
		}

		String sql = "insert into goods(goodsName, type, price,inventory,shopName,imagePath) values (?,?,?,?,?,?)";
		
		ps = con.prepareStatement(sql);
		
		ps.setString(1, goods.getGoodsName());
		ps.setString(2, goods.getType());
		ps.setString(3, goods.getPrice());
		ps.setString(4, goods.getInventory());
		ps.setString(5, goods.getShopName());
		ps.setString(6, goods.getImagePath());
	
		int row = ps.executeUpdate();
		if(row>0)
			return true;
		else
			return false;
		
	}
	
	public List<Goods> getGoods(Goods goods)throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
			
		List<Goods> list = new ArrayList<Goods>();
		String goodsName = goods.getGoodsName();
		int goodsID = goods.getGoodsID();
		
		con = ConnectionManager.getConnection();
		if (con == null) {
			throw new Exception("数据库连接不成功！");
		}
System.out.println(goodsID+"_"+goodsName+"_"+goods.getShopName());

		if(goodsID==0){
			if(goodsName==null||goodsName.equals("")){    
				String sql = "select * from goods where shopName = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, goods.getShopName());
			}else{
				String sql = "select * from goods where shopName = ? and goodsName = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, goods.getShopName());
				ps.setString(2, goodsName);
			}
		}else{
			String sql = "select * from goods where goodsID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, goods.getGoodsID());
		}
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Goods newGoods = new Goods();
			newGoods.setGoodsID(rs.getInt("goodsID"));
			newGoods.setGoodsName(rs.getString("goodsName"));
			newGoods.setType(rs.getString("type"));
			newGoods.setInventory(rs.getString("inventory"));
			newGoods.setSales(rs.getString("sales"));
			newGoods.setPrice(rs.getString("price"));
			newGoods.setImagePath(rs.getString("imagePath"));
			list.add(newGoods);
		}
		return list;
	}
	
	public boolean deleGoods(String goodsID) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;

		// 连接数据库
		con = ConnectionManager.getConnection();

		if (con == null) {
			throw new Exception("数据库连接不成功！");
		}

		String sql = "delete from goods where goodsID = ?";
		
		ps = con.prepareStatement(sql);
		
		ps.setString(1,goodsID);
		
		int row = ps.executeUpdate();
		if(row>0)
			return true;
		else
			return false;
		
	}

	public boolean editGoods(Goods goods) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		

		con = ConnectionManager.getConnection();
		if (con == null) {
			throw new Exception("数据库连接不成功！");
		}
	
		String sql = "update goods set goodsName=?,type=?,price=?,inventory=?,imagePath=? where goodsID = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, goods.getGoodsName());
		ps.setString(2, goods.getType());
		ps.setString(3, goods.getPrice());
		ps.setString(4, goods.getInventory());
		ps.setString(5, goods.getImagePath());
		ps.setInt(6, goods.getGoodsID());
		int rs = ps.executeUpdate();
		if(rs>0){
			return true;
		}
		return false;

	}

	public List<Order> getOrder(Order order) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
			
		List<Order> list = new ArrayList<Order>();
		int orderID = order.getOrderID();//刚刚开始为0，不输入查询也为0
		String state = order.getState();//刚刚开始和全部 为null 
		
		con = ConnectionManager.getConnection();
		if (con == null) {
			throw new Exception("数据库连接不成功！");
		}
		if(orderID==0 && state==null){    
			String sql = "select * from orders where shopName = ?"; //查找该店全部订单
			ps = con.prepareStatement(sql);
			ps.setString(1, order.getShopName());
		}else if(orderID!=0){
			String sql = "select * from orders where orderID = ?"; //按照订单编号查找 
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderID);
		}else{
			String sql = "select * from orders where shopName = ? and state = ?";//按照订单状态查找
			ps = con.prepareStatement(sql);
			ps.setString(1, order.getShopName());
			ps.setString(2, order.getState());
		}
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Order newOrder = new Order();
			newOrder.setOrderID(rs.getInt("orderID"));
			newOrder.setUsername(rs.getString("username"));
			newOrder.setShopName(rs.getString("shopName"));
			newOrder.setGoodsName(rs.getString("goodsName"));
			newOrder.setQuantity(rs.getString("quantity"));
			newOrder.setPrice(rs.getString("price"));
			newOrder.setTime(rs.getString("time"));
			newOrder.setAddress(rs.getString("address"));
			newOrder.setConsignee(rs.getString("consignee"));
			newOrder.setPhone(rs.getString("phone"));
			newOrder.setState(rs.getString("state"));
			list.add(newOrder);
		}
		return list;
	}

	public boolean deleOrder(String orderID) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		// 连接数据库
		con = ConnectionManager.getConnection();

		if (con == null) {
			throw new Exception("数据库连接不成功！");
		}
			
		String sql = "delete from orders where orderID = ?";
		
		ps = con.prepareStatement(sql);
		ps.setInt(1,Integer.parseInt(orderID));
		
		int row = ps.executeUpdate();
		if(row>0)
			return true;
		else
			return false;
		
	}

	public boolean editOrder(String orderID) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		// 连接数据库
		con = ConnectionManager.getConnection();

		if (con == null) {
			throw new Exception("数据库连接不成功！");
		}
	
		String sql = "update orders set state=? where orderID = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, "待收货");
		ps.setInt(2,Integer.parseInt(orderID));
		
		int row = ps.executeUpdate();
		if(row>0)
			return true;
		else
			return false;
		
		
	}

	public boolean updateUser(Shop shop) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		// 连接数据库
		con = ConnectionManager.getConnection();

		if (con == null) {
			throw new Exception("数据库连接不成功！");
		}
	
		String sql = "update user_list set shopName=? where username = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, shop.getShopName());
		ps.setString(2,shop.getUsername());
		
		int row = ps.executeUpdate();
		if(row>0)
			return true;
		else
			return false;
		
	}

	public User getUser(String username) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		
		// 连接数据库
		con = ConnectionManager.getConnection();

		if (con == null) {
			throw new Exception("数据库连接不成功！");
		}
	
		String sql = "select * from user_list where username = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, username);
	
		ResultSet rs = ps.executeQuery();
		User user = new User();
		if(rs.next()){
			user.setUsername(rs.getString("username"));
			user.setShopName(rs.getString("shopName"));
			user.setAddress(rs.getString("address"));
			user.setConsignee(rs.getString("consignee"));
			user.setMoney(rs.getString("money"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
		}
		return user;
		
	}
	
}
