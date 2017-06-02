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
	 * ����û��Ĺ��ﳵ
	 * @param username 	�û���
	 * @return	List<Map<String,Object>>
	 */
	public List<Map<String,Object>> getCartByUsername(String username){
		return cd.getCartByUsername(username);
	}
	/**
	 * �����Ʒ�����ﳵ
	 * @param username	�û���
	 * @param goodsID	��Ʒ���
	 * @param quantity	����
	 * @param subtotal	С��
	 * @throws Exception���ʧ���쳣
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
				throw new Exception("���ʧ�ܣ�");
			}
		}else{
			subtotal=(Integer.parseInt(quantity)*price)+"";
			boolean rs=cd.addCartItem(username, goodsID, quantity, subtotal);
			if(!rs){
				throw new Exception("�������Ʒʧ�ܣ�");
			}
		}
	}
	/**
	 * �޸�ĳ�����������Ʒ����
	 * @param username	�û���
	 * @param goodsID	��Ʒ���
	 * @param quantity	����
	 * @throws Exception	��Ʒ�����޸�ʧ���쳣
	 */
	public void updateQuentity(String username,int goodsID,String quantity) throws Exception{
		Goods goods=gs.getAGoodsByID(goodsID);
		int price=Integer.parseInt(goods.getPrice());
		String subtotal=(Integer.parseInt(quantity)*price)+"";
		boolean rs=cd.updateCartItem(username, goodsID, quantity, subtotal);
		if(!rs){
			throw new Exception("��Ʒ�����޸�ʧ�ܣ�");
		}
	}
	/**
	 * ���ݹ������IDɾ��������
	 * @param cartID		�������ID
	 * @throws Exception	ɾ��ʧ���쳣
	 */
	public void deleteCartItem(int cartID) throws Exception{
		boolean rs=cd.deleteCartItem(cartID);
		if(!rs){
			throw new Exception("ɾ��ʧ�ܣ�");
		}
	}
}
