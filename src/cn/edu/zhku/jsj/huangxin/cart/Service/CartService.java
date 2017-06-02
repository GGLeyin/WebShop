package cn.edu.zhku.jsj.huangxin.cart.Service;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.huangxin.bean.Goods;
import cn.edu.zhku.jsj.huangxin.cart.Dao.CartDao;
import cn.edu.zhku.jsj.huangxin.goods.Service.GoodsService;

public class CartService {

	CartDao cd=new CartDao();
	GoodsService gs=new GoodsService();
	/**
	 * 获得用户的购物车
	 * @param username 	用户名
	 * @return	List<Map<String,Object>>
	 */
	public List<Map<String,Object>> getCartByUsername(String username){
		return cd.getCartByUsername(username);
	}
	/**
	 * 添加商品进购物车
	 * @param username	用户名
	 * @param goodsID	商品编号
	 * @param quantity	数量
	 * @param subtotal	小计
	 * @throws Exception添加失败异常
	 */
	public void addCartItem(String username,int goodsID,String quantity) throws Exception{
		Goods goods=gs.getAGoodsByID(goodsID);
		int price=Integer.parseInt(goods.getPrice());
		String subtotal=null;
		if(cd.isCartItemExist(username,goodsID)){
			String quantityold=cd.getQuantity(username, goodsID);
			int q=Integer.parseInt(quantityold);
			String quantitynew=(Integer.parseInt(quantity)+q)+"";
			subtotal=(Integer.parseInt(quantitynew)*price)+"";
			boolean rs=cd.updateCartItem(username,goodsID,quantitynew,subtotal);
			if(!rs){
				throw new Exception("添加失败！");
			}
		}else{
			subtotal=(Integer.parseInt(quantity)*price)+"";
			boolean rs=cd.addCartItem(username, goodsID, quantity, subtotal);
			if(!rs){
				throw new Exception("添加新商品失败！");
			}
		}
	}
	/**
	 * 修改某个购物项的商品数量
	 * @param username	用户名
	 * @param goodsID	商品编号
	 * @param quantity	数量
	 * @throws Exception	商品数量修改失败异常
	 */
	public void updateQuentity(String username,int goodsID,String quantity) throws Exception{
		Goods goods=gs.getAGoodsByID(goodsID);
		int price=Integer.parseInt(goods.getPrice());
		String subtotal=(Integer.parseInt(quantity)*price)+"";
		boolean rs=cd.updateCartItem(username, goodsID, quantity, subtotal);
		if(!rs){
			throw new Exception("商品数量修改失败！");
		}
	}
	/**
	 * 根据购物项的ID删除购物项
	 * @param cartID		购物项的ID
	 * @throws Exception	删除失败异常
	 */
	public void deleteCartItem(int cartID) throws Exception{
		boolean rs=cd.deleteCartItem(cartID);
		if(!rs){
			throw new Exception("删除失败！");
		}
	}
}
