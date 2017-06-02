package cn.edu.zhku.jsj.huangxin.cart.Dao;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.huangxin.util.BeanToMapUtil;
import cn.edu.zhku.jsj.huangxin.util.DBUtil;

public class CartDao {
	
	DBUtil du=new DBUtil();
	BeanToMapUtil bmu=new BeanToMapUtil();
	/**
	 * 通过用户名获取购物车的商品
	 * @param username	用户名
	 * @return	商品列表list
	 */
	public List<Map<String,Object>> getCartByUsername(String username){
		String sql="select * from cart,goods where cart.goodsID=goods.goodsID and username=?";
		Object[] params={username};
		List<Map<String,Object>> list=du.getList(sql, params);
		return list;
	}
	/**
	 * 向数据库添加一条购物项
	 * @param username	用户名
	 * @param goodsID	商品编号
	 * @param quantity	数量
	 * @param subtotal	小计
	 * @return	添加成功返回true，否则返回false
	 */
	public boolean addCartItem(String username,int goodsID,String quantity,String subtotal){
		boolean rs=false;
		String sql="insert into cart values(null,?,?,?,?)";
		Object[] params={username,goodsID,quantity,subtotal};
		int i=du.update(sql, params);
		if(i>0){
			rs=true;
		}
		return rs;
	}
	/**
	 * 更新用户购物项的商品的数量
	 * @param username	用户名
	 * @param goodsID	商品编号
	 * @param quantity	数量
	 * @return	修改成功返回true，否则返回false
	 */
	public boolean updateCartItem(String username,int goodsID,String quantity,String subtotal){
		 boolean rs=false;
		 String sql = "update cart set quantity=?,subtotal=?where username=? and goodsID=?";
		 Object[] params={quantity,subtotal,username,goodsID};
		 int i=du.update(sql, params);
		 if(i>0){
			 rs=true;
		 }
		 return rs;
	}
	/**
	 * 删除购物项
	 * @param cartID	购物项的编号
	 * @return	删除成功返回true，否则返回false
	 */
	public boolean deleteCartItem(int cartID){
		boolean rs=false;
		String sql="delete from cart where cartID=?";
		Object[] params={cartID};
		int i=du.update(sql, params);
		if(i>0){
			rs=true;
		}
		return rs;
	}
	/**
	 * 判断购物项是否已存在
	 * @param username	用户名
	 * @param goodsID	商品编号
	 * @return	存在返回true，否则返回false
	 */
	public boolean isCartItemExist(String username,int goodsID){
		boolean rs=false;
		String sql="select * from cart where username=? and goodsID=?";
		Object[] params={username,goodsID};
		Map m=du.getMap(sql, params);
		if(m!=null){
			rs=true;
		}
		return rs;
	}
	public String getQuantity(String username,int goodsID){
		String sql="select quantity from cart where username=? and goodsID=?";
		Object[] params={username,goodsID};
		Map m=du.getMap(sql, params);
		Object o=m.get("quantity");
		return (String)o;
	}
}
